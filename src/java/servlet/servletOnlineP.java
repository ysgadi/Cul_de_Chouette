
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletOnlineP  extends HttpServlet{
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      

        HttpSession session =req.getSession();
       
         req.getRequestDispatcher("jsp/onlinePlay.jsp").forward(req, resp);
        
     }
    
    
    
}
