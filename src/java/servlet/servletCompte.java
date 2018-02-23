
package servlet;
import Donnes.*;
import DAOJPA.*;
import com.sun.org.apache.xml.internal.security.Init;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletCompte extends HttpServlet{

   
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       
      
        HttpSession session =req.getSession();
        session.getAttribute("joueur");
    
         if((Joueur) session.getAttribute("joueur_invit")!=null)
          {
          session.setAttribute("joueur_invit",(Joueur) session.getAttribute("joueur_invit"));
          }
          else
          {
            session.setAttribute("joueur_invit",new Joueur());     
          }
         
        req.getRequestDispatcher("jsp/compte.jsp").forward(req, resp);
       

    } 
}
