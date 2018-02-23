/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;
/**
 *
 * @author utilisateur
 */
public class idpartie {
    
     private static idpartie singleton = new idpartie( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int id=0;
 
   private idpartie() { }

   /* Static 'instance' method */
   public static idpartie getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      id++;
      return id;
  }
   public int dec()
  {
      id--;
      return id;
  }
  
 
}
