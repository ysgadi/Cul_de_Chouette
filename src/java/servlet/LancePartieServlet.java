
package servlet;

import Donnes.Joueur;
import Singleton.ListeJoueurPartie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LancePartieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             
              ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
              for(Joueur e:listePartie.list)
              {
                  e.des[0]=0;
                  e.des[1]=0;
                  e.des[2]=0;
                  e.setNbrchouettesperdues(0);
                  e.setNbrsuitesgagnes(0);
              }
             req.getRequestDispatcher("jsp/LancerPartie.jsp").forward(req, resp);
          
            }
    
}
