
package Singleton;

/**
 *
 * @author utilisateur
 */
public class gagnant {
       private static gagnant singleton = new gagnant( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   public int bool=0;
   
   private gagnant() { }

   /* Static 'instance' method */
   public static gagnant getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
 public void inc()
 {
     bool++;
 }
  public void init(int x)
  {
      bool=x;
  }
    
}

