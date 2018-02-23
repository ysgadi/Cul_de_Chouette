
package servlet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletLogin  extends HttpServlet{
   
     
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
           }
   
}
