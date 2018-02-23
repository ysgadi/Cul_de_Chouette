package DAOJPA;
import Donnes.*;

public abstract class CulDeChouetteDAOFactory {
   
    public abstract DAO<Joueur> getDAOJoueur() throws DAOException;
    public abstract DAO<Partie> getDAOPartie() throws DAOException;
    public abstract DAO<Historique> getDAOHistorique() throws DAOException;
  
}
