/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author utilisateur
 */
public class ChouetteVelute {
   
     private static ChouetteVelute singleton = new ChouetteVelute( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int nb=0;
   
   private ChouetteVelute() { }

   /* Static 'instance' method */
   public static ChouetteVelute getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      nb++;
      return nb;
  }
  public void init(int x)
  {
      nb=x;
  }  
}
