
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import DAOJPA.idpartie;
import Donnes.Historique;
import Donnes.Joueur;
import Donnes.Partie;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import java.util.List;
import static javafx.beans.binding.Bindings.select;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static sun.misc.MessageUtils.where;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;



@WebServlet(name = "essay", urlPatterns = {"/essay"})
public class essay extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
        HttpSession session =request.getSession();
         Joueur j=(Joueur)session.getAttribute("joueur");
         Joueur invite=(Joueur)session.getAttribute("joueur_invit");
         Joueur jre=SingInvite.getInstance(j).get_joueur_invit();
          String dmd = request.getParameter("reqo").trim();
             PrintWriter out=response.getWriter();
             response.setContentType("text/plain");
                          
            String texte="";
            ListeInvite listI=ListeInvite.getInstance();
         
         switch(dmd)
         {
                 case("information"):
               {
                  
                    
                          
                          
                           DAOINST dao=new DAOINST();
                    
                        try {
                         Joueur jj =dao.getdaojoueur().find(j);
                         if(jj.getNbrPartieJouer()==null) jj.setNbrPartieJouer(0);
                         if(jj.getNbrVictoire()==null) jj.setNbrVictoire(0);
                        
                                    texte = "{\"tab\":\""+"<tr><th>Informations</th><th>Valeur</th></tr>"; 
                                      texte=texte+"<tr>"+"<td>"+"Mot de passe"+"</td><td>"+jj.getPassword() +"</td><td>"+"</tr>"+
                                      "<tr>"+"<td>"+"Age"+"</td><td>"+jj.getAge() +"</td><td>"+"</tr>"+
                                      "<tr>"+"<td>"+"Ville"+"</td><td>"+jj.getVille()+"</td><td>"+"</tr>"+
                                       "<tr>"+"<td>"+"Nombre parties jouées"+"</td><td>"+jj.getNbrPartieJouer()+"</td><td>"+"</tr>"+
                                       "<tr>"+"<td>"+"Nombre victoires"+"</td><td>"+jj.getNbrVictoire()+"</td><td>"+"</tr>";
                                   
                                 
                                      
                               
                      } catch (DAOException ex) {
                          Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
                      }
                          
                        
                        texte = texte + "\"}";
                        response.setContentType("text/plain");
                        response.getWriter().write(texte);
              
               break;
               }
               case("notification"):
               {
                   
                     int a=listI.taille();
                    
                     if(a==0)
                     response.getWriter().write("0");
                     else
                     {
                      if(invite.equals(j) || listI.TestRefuse(j) ||listI.TestAccept(j) ||!listI.list.contains(j) )
                         response.getWriter().write("0");
                      else
                      {
                          response.getWriter().write(jre.getPseudo());   
                      }
                      
                     }
                    
                      
               }
               break;
         } 
      
    }

}
  