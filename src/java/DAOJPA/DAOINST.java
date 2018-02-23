/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;

import Donnes.Historique;
import Donnes.Joueur;
import Donnes.Partie;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */

public class DAOINST {
     
         CulDeChouetteDAOFactory factory = AbstractDAOFactory.getDAOFactory();

      
         public  DAO<Joueur> getdaojoueur()
         {
             try {
                 return factory.getDAOJoueur();
             } catch (DAOException ex) {
                 Logger.getLogger(DAOINST.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
     
         }
        
          public  DAO<Partie> getdaopartie()
         {
             try {
                 return factory.getDAOPartie();
             } catch (DAOException ex) {
                 Logger.getLogger(DAOINST.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
         
         }
        
         public  DAO<Historique> getdaohistorique()
         {
             try {
                 return factory.getDAOHistorique();
             } catch (DAOException ex) {
                 Logger.getLogger(DAOINST.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
         
         }
         
    
}
