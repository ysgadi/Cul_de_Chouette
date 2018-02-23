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
public class SuiteInteger {
    
    private static SuiteInteger singleton = new SuiteInteger( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int tour=0;
   
   private SuiteInteger() { }

   /* Static 'instance' method */
   public static SuiteInteger getInstance( ) {
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
