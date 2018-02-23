
package servlet;

import Donnes.Joueur;
import Singleton.ListeJoueurPartie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TourServlet", urlPatterns = {"/TourServlet"})
public class TourServlet extends HttpServlet {

    
    
   
   
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
          ListeInvite listI=ListeInvite.getInstance();
          HttpSession session =req.getSession();
          Joueur j=(Joueur)session.getAttribute("joueur");
          //supprimer toutes les joueurs qui ont réfuser l'invitation
           session.setAttribute("joueur_invit", null);
           session.setAttribute("joueur_qui_invite",null);
           session.setAttribute("invite",null);
          req.getRequestDispatcher("jsp/tour.jsp").forward(req, resp);
          
    }  
    
}
    

    


