
package servlet;

import Donnes.Joueur;
import Singleton.ListeJoueurPartie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class servletInvite extends HttpServlet{
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      

        HttpSession session =req.getSession();
        Joueur j=(Joueur) session.getAttribute("joueur");
         session.setAttribute("joueur",(Joueur) session.getAttribute("joueur"));
          if((String) session.getAttribute("joueur_qui_invite")!=null)
          {
          session.setAttribute("joueur_qui_invite",(String) session.getAttribute("joueur_qui_invite"));
          }
          else
          {
            session.setAttribute("joueur_qui_invite",null);  
            session.setAttribute("invite",null);
            SingInvite.getInstance(j).initJoueur();
            
          }
          if((String) session.getAttribute("invite")!=null)
          session.setAttribute("invite",(String) session.getAttribute("invite"));
          
         if(session.getAttribute("joueur_invit")!=null)
          {
           Joueur jinvite=(Joueur)session.getAttribute("joueur_invit");
            session.setAttribute("invite",(String) session.getAttribute("invite"));
            SingInvite.getInstance(j);
         
           }
       else
       {
          session.setAttribute("joueur_invit", new Joueur());
          
       }
        session.setAttribute("listj",(List<Joueur>)session.getAttribute("listj"));
            
       req.getRequestDispatcher("jsp/invite.jsp").forward(req, resp);
           }
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         
                HttpSession session =request.getSession();
                Joueur j=(Joueur) session.getAttribute("joueur");
                String message="joueur_qui_invite";
                session.setAttribute("joueur_qui_invite",message);
                Joueur inv=(Joueur)session.getAttribute("joueur_invit");
                 List<Joueur> listco=(List<Joueur>)session.getAttribute("listj");
                 
                    sessionList list2=sessionList.getInstance();
                    ListeInvite listI=ListeInvite.getInstance(); 
                    String res[];
                    int nbinvite=0;
                    PrintWriter out=response.getWriter();
                    response.setContentType("text/plain");

                    if(listI.list.contains(j))
                    {
                        out.print("3");
                    }
                    else
                    {
                    if(!listI.list.isEmpty())
                     out.print("4");
                    else
                    {
                    {
                    for(Joueur e:listco)
                    {
                        if(!e.equals(j))
                      {
                          //joueur invité
                                if((String)request.getParameter(e.getPseudo())!=null)
                                {
    
                                    nbinvite++;
                               }
                      }
                     }
                    if(nbinvite==0)
                    {
                        out.print("0");
                    }
                    else
                    {
                                if(nbinvite>5)
                                {
                                     response.getWriter().write("1");   
                                }
                                else
                                {
                                       for(Joueur e:listco)
                                {
                                    if(!e.equals(j))
                                  {
                                      //joueur invité
                                            if((String)request.getParameter(e.getPseudo())!=null)
                                            {
                                               
                                                e.setEtat(0);
                                                listI.addJoueur(e);
                                            }
                                  }
                                }
                                }
                    }
                    }
                    }
                    }
                    
                      session.setAttribute("listdesinvites",listI.getList());
                   
                 
                 
                 if((Joueur)session.getAttribute("joueur_invit")==null)
                {
                    Joueur joueur_invit=SingInvite.getInstance(j).get_joueur_invit();
                    String message1="Vous etes invitez par le joueur "+j.getPseudo();
                    session.setAttribute("invite", message1);
                    session.setAttribute("joueur_invit",joueur_invit);
                    session.setAttribute("listj",(List<Joueur>)session.getAttribute("listj")); 
                } 

                 
                Joueur joueur_invit=SingInvite.getInstance(j).get_joueur_invit();
                
                session.setAttribute("joueur", j); 
                session.setAttribute("joueur_invit", joueur_invit);   
                session.setAttribute("listj",(List<Joueur>)session.getAttribute("listj"));

     }
    
}
