
package servlet;

import Donnes.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet(name = "OnlinePP", urlPatterns = {"/OnlinePP"})
public class OnlinePP extends HttpServlet {

   
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session =request.getSession();
            
           sessionList list=sessionList.getInstance();
            String texte="";
           
              Joueur jr=(Joueur)session.getAttribute("joueur");
              String req = request.getParameter("reqo").trim();
              response.setContentType("application/json");
               response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();
                texte = "";
               
              if(list.list.size()==1)
              {
              response.setContentType("text/plain");
              response.getWriter().write("1");
              }
          
              else
                  
              {
              if (req.equals("listJoueur"))
               {
                  texte = "{\"joueurs\":\""+"<tr><th>Pseudo</th><th>Ville</th><th>Age</th></tr>";  
                  for(Joueur e:list.list)
                      {
                         if(!jr.equals(e))
                          texte=texte+"<tr>"+"<td>"+e.getPseudo()+"</td><td>"+e.getVille()+"</td><td>"+e.getAge()+"</td></tr>";
                        
                       }
                 }
                        
                        texte = texte + "\"}";
                        response.setContentType("text/plain");
                        response.getWriter().write(texte);
                        
  
            }
     }
     }
     
     
        



