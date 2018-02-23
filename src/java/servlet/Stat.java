
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Donnes.Historique;
import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Stat", urlPatterns = {"/Stat"})
public class Stat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session =request.getSession();
         Joueur j=(Joueur)session.getAttribute("joueur");
         String message = null;
         Joueur invite=(Joueur)session.getAttribute("joueur_invit");
         Joueur jre=SingInvite.getInstance(j).get_joueur_invit();
          String dmd = request.getParameter("reqo").trim();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
             PrintWriter out=response.getWriter();
            String texte="";
             DAOINST dao=new DAOINST();
            ListeInvite listI=ListeInvite.getInstance();
         
            
            
         switch(dmd)
         {
                 case("statistique"):
                 {
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
                                queryChouettePartieTotale.setParameter("param",his.getPartie().getIdPartie());
                                totaleChouettesPartie=totaleChouettesPartie+(int)queryChouettePartieTotale.getSingleResult();
                                javax.persistence.Query querySuitePartieTotale = em.createQuery("select p.nbrsuite from Partie p where p.idPartie=:param");
                                querySuitePartieTotale.setParameter("param",his.getPartie().getIdPartie());
                                totaleSuitesPartie=totaleSuitesPartie+(int)querySuitePartieTotale.getSingleResult();
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
                        try {
                         Joueur jj =dao.getdaojoueur().find(j);
                                              
                                    texte = "{\"tab\":\""+"<tr><th>Informations</th><th>Valeur</th></tr>"; 
                                      texte=texte+
                                         "<tr>"+"<td>"+"Score Moyen "+"</td><td>"+jj.getScoreMoy()+"</td><td>"+"</tr>"+
                                       "<tr>"+"<td>"+"Pourcentage victoire"+"</td><td>"+jj.getNbrVectMoyen()+"</td><td>"+"</tr>"+
                                       "<tr>"+"<td>"+"Pourcentage suites gagnées "+"</td><td>"+jj.getMoyNbrSuiteGagner()+"</td><td>"+"</tr>"+
                                              "<tr>"+"<td>"+"Pourcentage Chouettes perdues "+"</td><td>"+jj.getMoyNbrChouPerdue()+"</td><td>"+"</tr>";
                                   
                                 
                                      
                               
                      } catch (DAOException ex) {
                          Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
                      }
                          
                       
                        texte = texte + "\"}";
                        response.setContentType("text/plain");
                        response.getWriter().write(texte);
              
               break;
               }
         }
        
      
    }

  

}
