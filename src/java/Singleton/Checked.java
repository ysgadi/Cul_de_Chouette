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
public class Checked {
    
     private static Checked singleton = new Checked( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int chk=0;
   
   private Checked() { }

   /* Static 'instance' method */
   public static Checked getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      chk++;
      return chk;
  }
  public void init(int x)
  {
      chk=x;
  }
}
