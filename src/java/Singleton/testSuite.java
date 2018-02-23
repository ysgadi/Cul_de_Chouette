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
public class testSuite {
 
     private static testSuite singleton = new testSuite( );

  
   public boolean val=false;
 
   
   private testSuite() { }

   /* Static 'instance' method */
   public static testSuite getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
 
  public void init()
  {
      val=false;
    
  }  

   
}
