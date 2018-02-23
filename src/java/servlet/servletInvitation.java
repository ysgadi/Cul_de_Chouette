
package servlet;

import Donnes.Joueur;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletInvitation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
          
           HttpSession session =req.getSession();
           session.setAttribute("joueur",(Joueur) session.getAttribute("joueur"));
            req.getRequestDispatcher("jsp/invitation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
               HttpSession session =req.getSession();
               Joueur j=(Joueur)session.getAttribute("joueur");
               resp.setContentType("text/html;charset=UTF-8");
               PrintWriter out=resp.getWriter();
               //etat = 0 (pas de reponse)
               //etat=1 (invitation accepter)
              // etat = 2 (invitation refuser)
               ListeInvite listI=ListeInvite.getInstance();
               String choix=req.getParameter("reponse");
               if("Accepter".equals(choix))
               {
               j.setEtat(1);
                out.print("1");
               }
                else
               {
                listI.Refuse(j);
                session.setAttribute("joueur_invit", null);
                session.setAttribute("joueur_qui_invite",null); 
                Joueur jre=SingInvite.getInstance(j).get_joueur_invit();
                SingInvite.getInstance(j).initJoueur();
                out.print("0");    
               }         
         
    }
    
    
    
}
