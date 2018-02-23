
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Donnes.Joueur;
import Donnes.Partie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Singleton.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servletTestInvite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        HttpSession session =req.getSession();
         Joueur j=(Joueur)session.getAttribute("joueur");
         String message = null;
         Joueur invite=(Joueur)session.getAttribute("joueur_invit");      
         ListeInvite listI=ListeInvite.getInstance();
         if(listI.EnAtt()==true)
          message="0";
        else
         {
          if(listI.AllRefuse())
          {
              session.setAttribute("joueur_invit", null);
              session.setAttribute("joueur_qui_invite",null); 
              SingInvite.getInstance(j).initJoueur();
              listI.initList();
              message="1";
          }
          
          else
          {
               
              listI.removeJoueurs();
          }
         }
          out.print(message);
                  }
    
    
    
}
