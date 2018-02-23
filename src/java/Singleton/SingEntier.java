/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import servlet.*;
import Donnes.Joueur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author utilisateur
 */
public class SingEntier {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  
  private static SingEntier singleton = new SingEntier( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int tour=0;
   
   private SingEntier() { }

   /* Static 'instance' method */
   public static SingEntier getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      tour++;
      return tour;
  }
  public void init(int x)
  {
      tour=x;
  }
}
