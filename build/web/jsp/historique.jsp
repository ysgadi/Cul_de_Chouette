<%-- 
    Document   : modification
    Created on : 22 nov. 2016, 00:59:35
    Author     : utilisateur
--%>


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
          <link type="text/css" rel="stylesheet" href="css/hiss.css" />
           
          <!-- compte modifier la classe container !-->
        <title>Historique</title>
    </head>
    
    <body>

        
        <h1></h1>
           <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
        <h1 size>Historique <font color="green"><%out.print( j.getPseudo());%> </font></h1>
        
                            <table>
                               <tr>
                                   <th>Numéro Partie</th>
                                   <th>Nombre de Suites Gagnées</th>
                                   <th>Nombre de Chouettes Perdues</th>
                                    <th>Score Partie </th> 
                                    <th>Résultat</th>
                               </tr>
                               
             
        <%
                            Joueur l=new Joueur();
                           l.setPseudo(j.getPseudo());
                            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
                            EntityManager em = emf.createEntityManager();
                           javax.persistence.Query querhHist = em.createQuery("select h from Historique h where h.joueur=:param");
                           querhHist.setParameter("param",l);
                            List<Historique> listJoueurHist =querhHist.getResultList();
                            
                           if(!listJoueurHist.isEmpty())
                           {
                            for(Historique his:listJoueurHist)
                             {
                                 //listJoueurHist.size()=nombre de partie jouer
                                  javax.persistence.Query queryG = em.createQuery("select p.winner from Partie p where p.idPartie=:param ");
                                  queryG.setParameter("param",his.getHistoriquePK().getIdPartie());
                                  Joueur g =(Joueur)queryG.getSingleResult();
                               %>
                         
                               <tr>
                               <td>
                                   <%
                                      out.print(his.getHistoriquePK().getIdPartie());
                                   %>
                               </td>
                             
                                   
                                   <td>
                                    <%
                                    out.print(his.getNbrSuiteGanger());
                                    %>
                                   </td>
                                                                
                                   <td>
                                    <%
                                      out.print(his.getNbrChouPerdue());
                                    %>
                                   </td>
                              
                                   <td>
                                    <%
                                      out.print(his.getScoreJoueur());
                                    %>
                                   </td>
                                   <td>
                                       <%
                                           if(g.getPseudo().equals(j.getPseudo()))
                                           {
                                       %>
                                      <font color="green" size="2px"><span style="font-weight:bold">
                                          Victoire
                                       <%
                                           }
                                           else
                                           {
                                           %>
                                         <font color="red" size="2px"><span style="font-weight:bold">
                                          Défaite
                                           <%
                                          }
                                       %>
                                       
                                   </td>
                                      </tr>
                          
                                    <%
                                        }//fin for
                                        }//fin if
                                     %>
       </table>
    </div>
   
   
     
      <%-- -----------------------------------------------------------%>
      
     
    <div class="login-help">
    
         <a href="Compte">Cliquer ici pour retourner à votre compte</a>
        
    </div>
    
  </section>
     
     
    </body>
</html>