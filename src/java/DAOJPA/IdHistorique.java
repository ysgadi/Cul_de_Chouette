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
public class IdHistorique {
    
      private static IdHistorique singleton = new IdHistorique( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int id=0;
 
   private IdHistorique() { }

   /* Static 'instance' method */
   public static IdHistorique getInstance( ) {
      return singleton;
   }
   
   /* Other methods protected by singleton-ness */
  public int inc()
  {
      id++;
      return id;
  }
 
}
