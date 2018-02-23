
import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Donnes.Historique;
import Donnes.HistoriquePK;
import static Donnes.Historique_.historiquePK;
import Donnes.Joueur;
import Donnes.Partie;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Formatter;
import java.util.List;
import static javafx.beans.binding.Bindings.select;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static sun.misc.MessageUtils.where;
import java.math.BigDecimal;
import java.math.RoundingMode;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utilisateur
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        // TODO code application logic here
        
         DAOINST dao=new DAOINST();
         Joueur j=new Joueur();
         j.setPseudo("youcef");
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         //historique du joueur (liste)
         javax.persistence.Query querhHist = em.createQuery("select h from Historique h where h.joueur=:param");
         querhHist.setParameter("param",j);
      
        List<Historique> listJoueurHist =querhHist.getResultList();
        int totaleScoreJoueur=0;
        int totaleSuiteJoueur=0;
        int totaleChouettesJoueur=0;
        int totaleChouettesPartie=0;
        int totaleSuitesPartie=0;
      if(!listJoueurHist.isEmpty()) 
      {
      for(Historique h:listJoueurHist)
      {
      totaleScoreJoueur=totaleScoreJoueur+h.getScoreJoueur();
      totaleSuiteJoueur=totaleSuiteJoueur+h.getNbrSuiteGanger();
      totaleChouettesJoueur=totaleChouettesJoueur+h.getNbrChouPerdue();
      javax.persistence.Query queryChouettePartieTotale = em.createQuery("select p.nbrchouettes from Partie p where p.idPartie=:param");
      queryChouettePartieTotale.setParameter("param",h.getPartie().getIdPartie());
      totaleChouettesPartie=totaleChouettesPartie+(int)queryChouettePartieTotale.getSingleResult();
      javax.persistence.Query querySuitePartieTotale = em.createQuery("select p.nbrsuite from Partie p where p.idPartie=:param");
      querySuitePartieTotale.setParameter("param",h.getPartie().getIdPartie());
      totaleSuitesPartie=totaleSuitesPartie+(int)querySuitePartieTotale.getSingleResult();
      }
      //listJoueurHist.size()=nombre de partie jouer
      double moyScore= (double)totaleScoreJoueur / listJoueurHist.size();
      double moySuite=0;
      double moyChouette=0;
      if(totaleSuitesPartie!=0)
      moySuite= (double)totaleSuiteJoueur/totaleSuitesPartie;
    
      if(totaleChouettesPartie!=0) 
      moyChouette= (double)totaleChouettesJoueur/totaleChouettesPartie;

  
     double moyScorej = new BigDecimal(moyScore).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
      double moySuitej = new BigDecimal(moySuite).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
      double moyChouettej = new BigDecimal(moyChouette).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
      j.setScoreMoy(moyScorej);
      j.setMoyNbrSuiteGagner(moySuitej);
      j.setMoyNbrChouPerdue(moyChouettej);
      //mettre a jour le nombre de suite et chouettes perdues dans la table joueur
     j.setNbrchouettesperdues(totaleChouettesJoueur);
     j.setNbrsuitesgagnes(totaleSuiteJoueur);
     //calculer la MoyVect
      javax.persistence.Query querhPartie = em.createQuery("select p from Partie p where p.winner=:param");
      querhPartie.setParameter("param",j);
      List<Joueur> listJoueurPartie =querhPartie.getResultList();
      double VictMoy=(double)listJoueurPartie.size()/listJoueurHist.size();
       double VictMoy1 = new BigDecimal(VictMoy).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
      j.setNbrVectMoyen(VictMoy1);
      //mettre A jour la table joueur
      }
      Joueur k=dao.getdaojoueur().find(j);
      
     System.out.print(k.getNbrVectMoyen());
    //  dao.getdaojoueur().update(j);
     
    }
     
    
}
