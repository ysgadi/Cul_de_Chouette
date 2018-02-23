
package servlet;

import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Singleton.*;

/**
 *
 * @author utilisateur
 */
public class AffectTourJoueurs extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         
                HttpSession session =request.getSession();
                Joueur j=(Joueur) session.getAttribute("joueur");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                
              
                 ListeInvite listI=ListeInvite.getInstance();
                SingEntierServ indice=SingEntierServ.getInstance();             
                String tour1=request.getParameter(Integer.toString(indice.tour));
                //Affecter le tour au joueur invité
                listI.list.get(indice.tour).setTour(Integer.parseInt(tour1));
                indice.inc();
                if(listI.list.size()==indice.tour)
                {
                  j.setTour(1);
                  listI.list.add(j);
                 out.print("1");
                }
               
               
         
     
     }
    
    
}
