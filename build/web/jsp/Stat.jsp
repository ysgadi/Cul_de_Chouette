<%-- 
    Document   : modification
    Created on : 22 nov. 2016, 00:59:35
    Author     : utilisateur
--%>

<%@page import="java.util.Formatter"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="Singleton.ListeJoueurPartie"%>
<%@page import="Singleton.tourGame"%>
<%@page import="Donnes.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<%@page import="servlet.*"%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>
<%  String Pseudo_invit= (String)session.getAttribute("invite"); %>
<%       
     DAOINST dao=new DAOINST();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/historique.css" />
           
         
        <title>Statistique</title>
    </head>
    
    <body>

        
        <h1></h1>
           <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
        <h1 size>Statistique <font color="green"><%out.print( j.getPseudo());%> </font></h1>
        
 <table id="table">
 
  </table>  
             
        <%
          Joueur l=new Joueur();
                           l.setPseudo(j.getPseudo());
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
                            EntityManager em = emf.createEntityManager();
                            //historique du joueur (liste)
                           javax.persistence.Query querhHist = em.createQuery("select h from Historique h where h.joueur=:param");
                           querhHist.setParameter("param",l);
                            List<Historique> listJoueurHist =querhHist.getResultList();
                            int totaleScoreJoueur=0;
                            int totaleSuiteJoueur=0;
                            int totaleChouettesJoueur=0;
                            int totaleChouettesPartie=0;
                            int totaleSuitesPartie=0;
                           if(!listJoueurHist.isEmpty())
                           {
                             for(Historique his:listJoueurHist)
                                {
                                totaleScoreJoueur=totaleScoreJoueur+his.getScoreJoueur();
                                totaleSuiteJoueur=totaleSuiteJoueur+his.getNbrSuiteGanger();
                                totaleChouettesJoueur=totaleChouettesJoueur+his.getNbrChouPerdue();
                                javax.persistence.Query queryChouettePartieTotale = em.createQuery("select p.nbrchouettes from Partie p where p.idPartie=:param");
                                queryChouettePartieTotale.setParameter("param",his.getHistoriquePK().getIdPartie());
                                totaleChouettesPartie=totaleChouettesPartie+(Integer)queryChouettePartieTotale.getSingleResult();
                                javax.persistence.Query querySuitePartieTotale = em.createQuery("select p.nbrsuite from Partie p where p.idPartie=:param");
                                querySuitePartieTotale.setParameter("param",his.getHistoriquePK().getIdPartie());
                                totaleSuitesPartie=totaleSuitesPartie+(Integer)querySuitePartieTotale.getSingleResult();
                                }
                            
                                //listJoueurHist.size()=nombre de partie jouer
                                double moyScore= (double)totaleScoreJoueur / listJoueurHist.size();
                                double moySuite=0;
                                double moyChouette=0;
                                if(totaleSuitesPartie!=0)
                                moySuite= (double)totaleSuiteJoueur/totaleSuitesPartie;

                                if(totaleChouettesPartie!=0) 
                                moyChouette= (double)totaleChouettesJoueur/totaleChouettesPartie;
                               l.setScoreMoy(moyScore);
                                l.setMoyNbrSuiteGagner(moySuite);
                                l.setMoyNbrChouPerdue(moyChouette);
                                //mettre a jour le nombre de suite et chouettes perdues dans la table joueur
                               l.setNbrchouettesperdues(totaleChouettesJoueur);
                               l.setNbrsuitesgagnes(totaleSuiteJoueur);
                               //calculer la MoyVect
                                javax.persistence.Query querhPartie = em.createQuery("select p from Partie p where p.winner=:param");
                                querhPartie.setParameter("param",j);
                                List<Joueur> listJoueurPartie =querhPartie.getResultList();
                                double VictMoy=(double)listJoueurPartie.size()/listJoueurHist.size();

                                l.setNbrVectMoyen(VictMoy);
                          try {
                              //mettre A jour la table joueur
                           
                                  
                              dao.getdaojoueur().update(l);
                                
                          } catch (DAOException ex) {
                              Logger.getLogger(FinPartie.class.getName()).log(Level.SEVERE, null, ex);
                          }       
                           }
                           Joueur jj =dao.getdaojoueur().find(j);
                           %>
                           <table>
                               <tr>
                                   <th>Statistique</th>
                                   <th>Valeurs</th>
                                       
                               </tr>
                               
                               <tr><td>Pourcentage de victoire</td>
                               <td>
                                   <%
                                        Formatter MoyV = new Formatter();
                                        if(jj.getNbrVectMoyen()==null )
                                         out.print(0);
                                        else
                                        {
                                          double prc1=jj.getNbrVectMoyen()*100;
                                         MoyV.format("%.2f",prc1);
                                        out.print(MoyV+"%");
                                        }
                                   %>
                               </td>
                             </tr>
                                   <tr>
                                   <td>Score Moyen</td>
                                   <td>
                           <%
                           Formatter scoreM = new Formatter();
                           scoreM.format("%.2f",jj.getScoreMoy());
                           if(jj.getScoreMoy()==null )
                            out.print(0);
                           else
                           out.print(scoreM);
                           %>
                                   </td>
                               </tr>
                               <tr>
                                   <td> Pourcentage suites gagnées</td>
                                   <td>
                           <%
                                  Formatter Suiteg = new Formatter();
                                        if(jj.getMoyNbrSuiteGagner()==null )
                                         out.print(0);
                                        else
                                        {
                                          double prc2=jj.getMoyNbrSuiteGagner()*100;
                                         Suiteg.format("%.2f",prc2);
                                        out.print(Suiteg+"%");
                                        }
                           %>
                                   </td></tr>
                               <tr><td>Pourcentage chouettes perdues</td>
                                   <td>
                           <%
                                   Formatter ChouettesP = new Formatter();
                                        if(jj.getMoyNbrChouPerdue()==null )
                                         out.print(0);
                                        else
                                        {
                                          double prc3=jj.getMoyNbrChouPerdue()*100;
                                         ChouettesP.format("%.2f",prc3);
                                        out.print(ChouettesP+"%");
                                        }
                           %>
                                   </td></tr>
                           </table>
       <input type="submit" value="Historique" id="historique"/>
        <script>
             $( "#historique" ).click(function( event ) {
                     window.location="historique";
                    //fin get
                    });//fin submit
       </script>
   
    </div>
   
   
     
      <%-- -----------------------------------------------------------%>
      
     
    <div class="login-help">
    
         <a href="Compte">Click here to return to you're account</a>
        
    </div>
    
  </section>
     
     
    </body>
</html>
