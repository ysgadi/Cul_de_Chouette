/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux.gestionDes;

import Donnes.Joueur;
import java.util.List;

/**
 *
 * @author utilisateur
 */
public class ChercherJoueur {
    
     public static Joueur find(int score,List<Joueur> l)
     {
         for(Joueur e:l)
         {
            if(e.getScore()==score) 
            {
               // l.remove(e);
                return e;
            }
         }
         return null;
     }
    
}

