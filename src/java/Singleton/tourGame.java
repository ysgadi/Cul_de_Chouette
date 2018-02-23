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
public class tourGame {
    
     private static tourGame singleton = new tourGame( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int tour=1;
   
   private tourGame() { }

   /* Static 'instance' method */
   public static tourGame getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      tour++;
      return tour;
  }
  public void dec()
  {
      tour--;
  }
  public void init(int x)
  {
      tour=x;
  }
}
