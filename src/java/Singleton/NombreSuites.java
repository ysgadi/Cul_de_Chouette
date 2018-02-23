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
public class NombreSuites {
  private static NombreSuites singleton = new NombreSuites( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int suite=0;
   
   private NombreSuites() { }

   /* Static 'instance' method */
   public static NombreSuites getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      suite++;
      return suite;
  }
  public void init(int x)
  {
      suite=x;
  }   
}
