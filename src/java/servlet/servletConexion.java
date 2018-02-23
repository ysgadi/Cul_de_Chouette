
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


public class servletConexion  extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out=response.getWriter();
          String username = request.getParameter("login");
          String password = request.getParameter("password");
        
         
            DAOINST dao=new DAOINST();
            Joueur j =new Joueur();
	    j.setPseudo(username);
        try {
            j=dao.getdaojoueur().find(j);
             if(j==null)
           {  
            out.print(0);
           }
             else
          {
              if(!j.getPassword().equals(password))
              {
                out.print(1);
                 
              } 
              else
              {
                    HttpSession session=request.getSession();
                    session.setAttribute("joueur", j);
                    sessionList list=sessionList.getInstance();
                    list.addJoueur(j);
                    session.setAttribute("listj",list.getList());
                   response.sendRedirect("Compte");    
              }
           
              
           }
        } catch (DAOException ex) {
            Logger.getLogger(servletConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                
           
    }
        
    }

