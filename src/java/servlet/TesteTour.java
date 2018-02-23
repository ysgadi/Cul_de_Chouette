
package servlet;

import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TesteTour", urlPatterns = {"/TesteTour"})
public class TesteTour extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        HttpSession session =req.getSession();
        Joueur j=(Joueur)session.getAttribute("joueur");
        ListeInvite listI=ListeInvite.getInstance();
        
        for(Joueur e:listI.list)     
        {       
        if(j.equals(e))
        {
         if(e.getTour()==0)
         {
          message="0"; 
          break;
         }
         else
         {
             
             message=Integer.toString(e.getTour());
             break;
         }
       
        }//fin if
        }//fin for
      out.print(message);
    }

    
}
