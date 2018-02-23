
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class servletModification extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session =req.getSession();
        session.getAttribute("joueur");
        req.getRequestDispatcher("jsp/modification.jsp").forward(req, resp);
      
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
               resp.setContentType("text/html;charset=UTF-8");
               PrintWriter out=resp.getWriter();

            
                String pswd=req.getParameter("pswd");
                int age=Integer.parseInt(req.getParameter("age"));
                String ville=req.getParameter("ville");      
                HttpSession session = req.getSession();
               Joueur j1= (Joueur)session.getAttribute("joueur");
            
               Joueur j =new Joueur();
               j.setPseudo(j1.getPseudo());
               j.setPassword(pswd);
               j.setAge(age);
               j.setVille(ville);
              DAOINST dao=new DAOINST();        
        
        try {
            dao.getdaojoueur().update(j);
            out.print("Modification effectuée");
            j1=dao.getdaojoueur().find(j);
        } catch (DAOException ex) {
            Logger.getLogger(servletModification.class.getName()).log(Level.SEVERE, null, ex);
        }
       session.setAttribute("joueur",j1);
            
             
       
        
    }
    
   
    
}
