
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import DAOJPA.idpartie;
import Donnes.Joueur;
import Donnes.Partie;
import Singleton.ListeJoueurPartie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "scoreLimit", urlPatterns = {"/scoreLimit"})
public class scoreLimit extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("jsp/Limitscore.jsp").forward(req, resp);
       
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        int scoreLimit=Integer.parseInt(req.getParameter("score"));
         resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
         ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
         ListeInvite listI=ListeInvite.getInstance();
         for(Joueur e:listI.list)
         listePartie.list.add(e);
         listI.initList();
          for(Joueur e:listePartie.list)
              {
                  e.setNbrchouettesperdues(0);
                  e.setNbrsuitesgagnes(0);
                  e.setScore(0);
              }
          
        if(scoreLimit>=50 && scoreLimit<=343)
        {
          idpartie id=idpartie.getInstance();
              DAOINST dao=new DAOINST();
              Partie p=new Partie();
              p.setIdPartie(id.id);
              p.setLimitscore(scoreLimit);
             try {
                 dao.getdaopartie().create(p);
                } catch (DAOException ex) {
                 Logger.getLogger(scoreLimit.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
}
