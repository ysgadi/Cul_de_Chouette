/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAOJPA.*;
import Donnes.*;
import org.json.JSONObject;


/**
 *
 * @author utilisateur
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        // TODO code application logic here
         CulDeChouetteDAOFactory factory = AbstractDAOFactory.getDAOFactory();
         DAO<Joueur> daojoueur=factory.getDAOJoueur();
         DAO<Partie> daopartie=factory.getDAOPartie();
         DAO<Historique> daohistorique=factory.getDAOHistorique();
         
         
         Joueur j=new Joueur();
         j.setPseudo("youcef");
         Joueur j1=daojoueur.find(j);

  
      //   daojoueur.update(j2);
      System.out.println(j1.toString());
         
    JSONObject obj = new JSONObject(j1);
      System.out.print(obj);
 
    }}
