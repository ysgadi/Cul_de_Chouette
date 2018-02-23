
package servlet;


import Donnes.Joueur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletLogout extends HttpServlet{
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
          
           HttpSession session=req.getSession();
           sessionList list=sessionList.getInstance();
             list.removeJoueur((Joueur) session.getAttribute("joueur"));
             session.removeAttribute("joueur");
             session.invalidate();       
              resp.sendRedirect("Login");
          
        
    }

    
    
    
}

    

