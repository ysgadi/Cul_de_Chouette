/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import DAOJPA.IdHistorique;
import DAOJPA.idpartie;
import Donnes.Historique;
import Donnes.HistoriquePK;
import static Donnes.Historique_.historiquePK;
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

/**
 *
 * @author utilisateur
 */
@WebServlet(name = "FinPartie", urlPatterns = {"/FinPartie"})
public class FinPartie extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
         
         idpartie id=idpartie.getInstance();
          IdHistorique idl = IdHistorique.getInstance();
         DAOINST dao=new DAOINST();
         Partie p=new Partie();
        p.setIdPartie(id.id);
        HttpSession session =req.getSession();
        Joueur j=(Joueur)session.getAttribute("joueur");
        
        
         try {
                        p=dao.getdaopartie().find(p);
              }
        catch (DAOException ex) {
                  Logger.getLogger(servletGameDes.class.getName()).log(Level.SEVERE, null, ex);
        
            }
                          idl.inc();
                         HistoriquePK pk=new HistoriquePK();
                          Historique h=new Historique();
                         pk.setIdPartie(p.getIdPartie());
                         pk.setPseudo(j.getPseudo());
                         h.setHistoriquePK(pk);
                         h.setNbrSuiteGanger(j.getNbrsuitesgagnes());
                         h.setNbrChouPerdue(j.getNbrchouettesperdues());
                         h.setScoreJoueur(j.getScore());
        try {
            
             
            dao.getdaohistorique().create(h);
            
            
           
        } catch (DAOException ex) {
            Logger.getLogger(FinPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
                         
                         Joueur l=new Joueur();
                         l.setPseudo(j.getPseudo());
                         l.setNbrPartieJouer(1);
                         if(j.getScore()>=p.getLimitscore())
                         l.setNbrVictoire(1);
                         else
                         l.setNbrVictoire(0);
                         l.setNbrsuitesgagnes(j.getNbrsuitesgagnes());
                         l.setNbrchouettesperdues(j.getNbrchouettesperdues());             
                        try {                
                            dao.getdaojoueur().update(l);
                        } catch (DAOException ex) {
                            Logger.getLogger(FinPartie.class.getName()).log(Level.SEVERE, null, ex);
                        }                   
                         
        j.des[0]=0;
        j.des[1]=0;
        j.des[2]=0;               
        j.setTour(0);
        j.setScore(0);
        j.setNbrchouettesperdues(0);
        j.setNbrsuitesgagnes(0);
        ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
        listePartie.list.remove(j);
        if(listePartie.list.size()==0)
        {
             
             Checked ch=Checked.getInstance();
             ChouetteVelute chv=ChouetteVelute.getInstance();
              SingEntier tour=SingEntier.getInstance();
             SingEntierServ indice=SingEntierServ.getInstance();
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
             indice.init(0);
             sti.init(0);
             gn.init(0);
             tourJoueur.init(1); 
        }
        
        
    }

   

}
