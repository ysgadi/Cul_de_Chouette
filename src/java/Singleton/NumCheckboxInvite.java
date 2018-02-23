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
public class NumCheckboxInvite {
    private static NumCheckboxInvite singleton = new NumCheckboxInvite( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int chkInvite=0;
   
   private NumCheckboxInvite() { }

   /* Static 'instance' method */
   public static NumCheckboxInvite getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  public int inc()
  {
      chkInvite++;
      return chkInvite;
  }
  public void init(int x)
  {
      chkInvite=x;
  } 
}
