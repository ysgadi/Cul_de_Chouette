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
public class NombreChouettes {
   private static NombreChouettes singleton = new NombreChouettes( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int chouette=0;
   
   private NombreChouettes() { }

   /* Static 'instance' method */
   public static NombreChouettes getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      chouette++;
      return chouette;
  }
  public void init(int x)
  {
      chouette=x;
  }    
}

