
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import DAOJPA.idpartie;
import Donnes.Joueur;
import Donnes.Partie;
import Singleton.Checked;
import Singleton.ChouetteVelute;
import Singleton.ListeJoueurPartie;
import Singleton.NombreChouettes;
import Singleton.NombreSuites;
import Singleton.SingEntier;
import Singleton.SingEntierServ;
import Singleton.SuiteInteger;
import Singleton.gagnant;
import Singleton.testChouette;
import Singleton.testSuite;
import Singleton.tourGame;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jeux.gestionDes.DesGame;
import static jeux.gestionDes.DesGame.*;


@WebServlet(name = "servletGameDes", urlPatterns = {"/servletGameDes"})
public class servletGameDes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
          HttpSession session =req.getSession();
          int k=0;
          Joueur j=(Joueur)session.getAttribute("joueur");
         //  ListeInvite listI=ListeInvite.getInstance();
             ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
            SingEntierServ indice=SingEntierServ.getInstance();
            SuiteInteger nb=SuiteInteger.getInstance();
            ChouetteVelute Chv=ChouetteVelute.getInstance();
            String dmd = req.getParameter("reqo").trim();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
           PrintWriter out = resp.getWriter();
            boolean a = false;
            String texte="";
           switch(dmd){
              case("tourJoueur"):
              {
                  resp.setContentType("text/plain");
                  tourGame tourJoueur=tourGame.getInstance();
                  if(listePartie.taille()==1)
                         {
                          tourJoueur.init(1); 
                         }
                  else
                  {
                  if(tourJoueur.tour == j.getTour())
                  resp.getWriter().write("tour1");
                  else
                  resp.getWriter().write("C'est le tour du joueur "+listePartie.TourJoueur(tourJoueur.tour));
                  }
                  }//fin if req
              break;
               case("LancerDes"):
                  {
                       Checked ini=Checked.getInstance();
                       ini.inc();
                       if(ini.chk==listePartie.taille()+1)
                         {
                           for(int i=0;i<listePartie.taille();i++)
                            {
                             listePartie.list.get(i).des[0]=0;
                             listePartie.list.get(i).des[1]=0;
                             listePartie.list.get(i).des[2]=0;
                            }
                             ini.chk=ini.chk-listePartie.taille();
                           }
                       
                       j.des=DesGame.lancerDes();
                       if (DesGame.velute(j.des[0],j.des[1],j.des[2]))
                         {
                          j.setScore(j.getScore()+DesGame.ScoreVelute(j.des));             
                         }
                          else
                          {
                           if(DesGame.culDeChouette(j.des[0],j.des[1],j.des[2]))
                           j.setScore(j.getScore()+DesGame.ScoreCulDeChouette(j.des));
                           else
                           {
                           if(DesGame.chouette(j.des[0],j.des[1]))
                           j.setScore(j.getScore()+DesGame.ScoreChouette(j.des)); 
                           }
                          }//fin else
                         tourGame tourJoueur=tourGame.getInstance();
                         tourJoueur.inc();
                         
                         
                         if(tourJoueur.tour-1==listePartie.getInstance().list.size())
                         {
                          tourJoueur.init(1);  
                         }
                         
                          if(DesGame.chouetteVelute(j.des[0], j.des[1],j.des[2]) && (j.des[0]!=0 && j.des[1]!=0&&j.des[2]!=0))
                          {
                               testChouette.getInstance().val=true;
                               testChouette.getInstance().D[0]=j.des[0];
                               testChouette.getInstance().D[1]=j.des[1];
                               testChouette.getInstance().D[2]=j.des[2];
                              
                          }
                          else
                              testChouette.getInstance().init();
                          
                           if(DesGame.suite(j.des[0], j.des[1],j.des[2]))
                           {
                               testSuite.getInstance().val=true;
                           }
                           else
                               testSuite.getInstance().val=false;
                         
                    }//fin if Lancer Des
                  break;
               case("AfficheDes"):
               {
                  texte = "{\"tab\":\""+"<tr><th>Pseudo </th><th> Tour </th><th>Fin Partie</th><th> 1 Dés </th><th> 2 Dés </th><th> 3 Dés </th><th> Score </th><th> Nombre suites Gagnées </th><th> Nombre chouettes perdues </th></tr>";  
                  String img1="";
                  String img2="";
                  String img3="";
                  for(Joueur e:listePartie.list)
                  {
                          if(e.getNbrchouettesperdues()==null) e.setNbrchouettesperdues(0);
                          if(e.getNbrsuitesgagnes()==null) e.setNbrsuitesgagnes(0); 
                          switch(e.des[0])
                          {
                              case(0):img1="<img src=\\\"images/notyet.png\\\" class=\\\"image\\\"/>";;break;
                              case(1):
                                        
                                   img1= "<img src=\\\"images/1.PNG\\\" class=\\\"image\\\"/>";
                                   break;
                                    case(2):
                                    
                                       img1= "<img src=\\\"images/2.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                     case(3):
                                    
                                       img1= "<img src=\\\"images/3.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(4):
                                     
                                      img1= "<img src=\\\"images/4.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(5):
                                    
                                      img1= "<img src=\\\"images/5.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                    case(6):
                                    
                                    img1= "<img src=\\\"images/6.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;  
                          }
                           switch(e.des[1])
                          {
                              case(0):img2="<img src=\\\"images/notyet.png\\\" class=\\\"image\\\"/>";;break;
                               case(1):      
                                   img2= "<img src=\\\"images/1.PNG\\\" class=\\\"image\\\"/>";
                                   break;
                                    case(2):
                                    
                                       img2= "<img src=\\\"images/2.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                     case(3):
                                    
                                       img2= "<img src=\\\"images/3.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(4):
                                     
                                      img2= "<img src=\\\"images/4.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(5):
                                    
                                      img2= "<img src=\\\"images/5.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                    case(6):
                                    
                                    img2= "<img src=\\\"images/6.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;  
                          }
                          switch(e.des[2])
                          {
                               case(0):img3="<img src=\\\"images/notyet.png\\\" class=\\\"image\\\"/>";;break;
                              case(1):
                                        
                                   img3= "<img src=\\\"images/1.PNG\\\" class=\\\"image\\\"/>";
                                   break;
                                    case(2):
                                    
                                       img3= "<img src=\\\"images/2.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                     case(3):
                                    
                                       img3= "<img src=\\\"images/3.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(4):
                                     
                                      img3= "<img src=\\\"images/4.PNG\\\" class=\\\"image\\\"/>";
                                     
                                        break;
                                    case(5):
                                    
                                      img3= "<img src=\\\"images/5.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;
                                    case(6):
                                    
                                    img3= "<img src=\\\"images/6.PNG\\\" class=\\\"image\\\"/>";
                                    
                                        break;  
                          }
                           idpartie id=idpartie.getInstance();
                           DAOINST dao=new DAOINST();
                           Partie p=new Partie();
                            p.setIdPartie(id.id);
                      try {
                          p=dao.getdaopartie().find(p);
                      } catch (DAOException ex) {
                          Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
                      }
                          texte=texte+"<tr>"+"<td>"+e.getPseudo()+"</td><td>"+e.getTour()+"</td><td>"
                                 + p.getLimitscore()+"</td><td>"+img1+" "+"</td><td>"+img2+" "+"</td><td>"+img3+" "+"</td><td>"+e.getScore()+"</td><td>"+e.getNbrsuitesgagnes()+"</td><td>"+e.getNbrchouettesperdues()+"</td></tr>";
                         // "</td></tr>"
                        
                       }
                        texte = texte + "\"}";
                        resp.setContentType("text/plain");
                        resp.getWriter().write(texte);
               }//fin affiche resultat des
               break;
                case("GrelotteCapicote"):
                {
                     
                    if(testSuite.getInstance().val==true)
                    {
                       nb.inc();
                       if(nb.tour==listePartie.list.size())
                        {
                         testSuite.getInstance().val=false;
                         j.setScore(j.getScore()-10);    
                         NombreSuites nbsuites=NombreSuites.getInstance();
                         nbsuites.inc();
                          for(k=0;k<listePartie.list.size();k++)
                          {
                            if(!(listePartie.list.get(k)).equals(j))
                              {
                            if(listePartie.list.get(k).getNbrsuitesgagnes()==null)
                            listePartie.list.get(k).setNbrsuitesgagnes(1);
                            else
                            listePartie.list.get(k).setNbrsuitesgagnes(listePartie.list.get(k).getNbrsuitesgagnes()+1);
                            }
                            }
                        nb.init(0);
                       }//fin if
                    }
                }//fin GrelotteCapicote
                break;
                
                 case("PasMouLeCaillou"):
                 {
                    
                     if(testChouette.getInstance().val==true)
                     {
                   
                       j.setScore(j.getScore()+DesGame.ScoreVelute(testChouette.getInstance().D));
                        NombreChouettes nbchouettes=NombreChouettes.getInstance();
                        nbchouettes.inc(); 
                        testChouette.getInstance().init();
                        for(Joueur l:listePartie.list)
                        {
                            if(!l.equals(j))
                              l.setNbrchouettesperdues(l.getNbrchouettesperdues()+1);
                        }
                     }//fin IF
                 }//fin PasMouLeCaillou
                 break;
                         
           case("Quitter"):
           {
            resp.setContentType("text/plain");
            //out.print(j.getPseudo());
            int bool=0;
    
               if(j.getTour()==ListeJoueurPartie.getInstance().list.size())
               {
                  listePartie.list.remove(j); 
                  tourGame tourJoueur=tourGame.getInstance();
                  tourJoueur.dec();
                  
               }
               else
               {
                    if(j.getTour()==1) bool=1;
                    
                     j.setTour(0);
                     j.setScore(0);
                     j.setNbrchouettesperdues(0);
                     j.setNbrsuitesgagnes(0);
                     j.des[0]=0;
                     j.des[1]=0;
                     j.des[2]=0;
                    listePartie.list.remove(j);
                    
                  
                    //n'est pas le dernier joueur     
                   if(bool==1)
                   {
                  for(Joueur e :ListeJoueurPartie.getInstance().list)
                  {
                    e.setTour(e.getTour()-1);
                   
                  }
                  bool=0;
                   }
                   else
                   {
                       for(Joueur e :ListeJoueurPartie.getInstance().list)
                       {
                           if(e.getTour()!=1)
                           e.setTour(e.getTour()-1);
                       }
                   }
                 
               }
               break;
           }
           //
          case("NbrJoueur"):
           {
             
               if(listePartie.list.size()==1 && listePartie.list.get(0).equals(j))
               {
               j.setTour(0);
               j.setScore(0);
               j.setNbrchouettesperdues(0);
               j.setNbrsuitesgagnes(0);
               j.des[0]=0;
               j.des[1]=0;
               j.des[2]=0;
               listePartie.list.remove(j);
                DAOINST dao=new DAOINST();
                idpartie id=idpartie.getInstance();
                Partie p=new Partie();
                p.setIdPartie(id.id);
                
             
             
                   try {
                       dao.getdaopartie().delete(p);
                   } catch (DAOException ex) {
                       Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
                   }
                id.dec();
               }
               if(listePartie.list.size()==0)
                        {

                             Checked ch=Checked.getInstance();
                             ChouetteVelute chv=ChouetteVelute.getInstance();
                              SingEntier tour=SingEntier.getInstance();
                             SingEntierServ indice1=SingEntierServ.getInstance();
                             SuiteInteger sti=SuiteInteger.getInstance();
                             gagnant gn=gagnant.getInstance();     
                             tourGame tourJoueur=tourGame.getInstance();
                             NombreChouettes.getInstance().init(0);
                             NombreSuites.getInstance().init(0);
                             ch.init(0);
                             chv.init(0);
                             //nn
                             tour.init(0);
                             //nn
                             indice1.init(0);
                             sti.init(0);
                             gn.init(0);
                             tourJoueur.init(1); 
                             j.des[0]=0;
                             j.des[1]=0;
                             j.des[2]=0;
                        }
        
               out.print(listePartie.list.size());
              
             break;        
           }
            case("Gagnant"):
           {
              idpartie id=idpartie.getInstance();
              DAOINST dao=new DAOINST();
              Partie p=new Partie();
              p.setIdPartie(id.id);
              gagnant gng=gagnant.getInstance();
              try {
                  p=dao.getdaopartie().find(p);
              } catch (DAOException ex) {
                  Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
              }
              int nbj=0;
              if(p.getLimitscore()==null) p.setLimitscore(0);
              
              for(Joueur e:listePartie.list)
              {
                  if(e.getScore()<p.getLimitscore())
                      nbj++;
              }
             if(nbj==listePartie.list.size())
             {
             out.print("1");
             }
             else
             {
              
               if(j.getScore()>=p.getLimitscore())
              {
                  //out.print("Bravo vous  avez gagner"); 
                  gng.inc();
                   texte = "{\"data\":\""+"<img src=\\\"images/winner.jpg\\\" class=\\\"image\\\"/>";
                    texte = texte + "\"}";
                    resp.setContentType("text/plain");
                   resp.getWriter().write(texte);
                   p.setWinner(j);
                   p.setScoretotale(j.getScore());
                   int nbsuites=0;
                   int nbchouettes=0;
                  p.setNbrchouettes(NombreChouettes.getInstance().chouette);
                  p.setNbrsuite(NombreSuites.getInstance().suite);
                  try {
                      dao.getdaopartie().update(p);
                      
                  } catch (DAOException ex) {
                      Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
                  }
             
                  break;
              }
               
                   
              if(gng.bool!=0)
              {
                  for(Joueur e:listePartie.list)
                  {
                      if(e.getScore()<p.getLimitscore() && e.equals(j))
                      {
                         texte = "{\"data\":\""+"<img src=\\\"images/loser.PNG\\\" class=\\\"image\\\"/>";
                         texte = texte + "\"}";
                         resp.setContentType("text/plain");
                         resp.getWriter().write(texte); 
                        
                        break; 
                      }
                
                  }
                        
      
                  
              }
          }
          break;
           }//fin else au moin un joueur a gagner
           }//fin switch
               
    }//fin doGet

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int score=Integer.parseInt(req.getParameter("scr"));
       idpartie id=idpartie.getInstance();
                           DAOINST dao=new DAOINST();
                           Partie p=new Partie();
                            p.setIdPartie(id.id);
                            p.setLimitscore(score);
        try {
            dao.getdaopartie().update(p);
        } catch (DAOException ex) {
            Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
                  

}
             
    