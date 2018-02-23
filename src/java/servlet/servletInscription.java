
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

public class servletInscription extends HttpServlet{

  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



          req.getRequestDispatcher("jsp/inscription.jsp").forward(req, resp);
       
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
               response.setContentType("text/html;charset=UTF-8");
               PrintWriter out=response.getWriter();
               String psd=request.getParameter("psd");
		       String pswd=request.getParameter("pswd");
		       int age=Integer.parseInt(request.getParameter("age"));
                String ville=request.getParameter("ville");
                String choix=request.getParameter("sex");

	  Joueur j1=new Joueur();

        try {
            DAOINST dao=new DAOINST();
            Joueur j =new Joueur();
	    j.setPseudo(psd);
            j=dao.getdaojoueur().find(j);

           if(j==null)
           {
                j1.setPseudo(psd);
                j1.setPassword(pswd);
                j1.setAge(age);
                j1.setVille(ville);
                if("H".equals(choix))
                 j1.setSexe('H');
                else
                     j1.setSexe('F');
                   dao.getdaojoueur().create(j1);
                   String cree="Joueur crée";
                   request.setAttribute("cree", cree);

                }
                else
                {
                String msg=new String("Pseudo exist déja");
                out.print(0);
                request.setAttribute("msg", msg);
                request.setAttribute("pseudo",psd);
                request.setAttribute("password",pswd);
                String agee=request.getParameter("age");
                request.setAttribute("age",agee);
                request.setAttribute("ville",ville);
                }
           
        } catch (DAOException ex) {
            Logger.getLogger(servletInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
           
	}




}
