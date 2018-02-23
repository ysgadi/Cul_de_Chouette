/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;
import Donnes.*;
/**
 *
 * @author utilisateur
 */
    
public class CulDeChouette_JPA_DAOFactory extends CulDeChouetteDAOFactory{
   private DAO_JPA_Joueur daojoueur = null;   
    private DAO_JPA_Partie daopartie = null;
    private DAO_JPA_Historique daohistorique =null;
    @Override
    public DAO<Joueur> getDAOJoueur() throws DAOException {
          if (daojoueur == null) 
           daojoueur = new DAO_JPA_Joueur();
	   return daojoueur;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DAO<Partie> getDAOPartie() throws DAOException {
        if (daopartie == null) 
           daopartie = new DAO_JPA_Partie();
	   return daopartie;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DAO<Historique> getDAOHistorique() throws DAOException {
       if (daohistorique == null) 
           daohistorique = new DAO_JPA_Historique();
	   return daohistorique;

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
