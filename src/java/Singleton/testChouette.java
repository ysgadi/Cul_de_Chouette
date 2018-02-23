
package Singleton;

public class testChouette {


   private static testChouette singleton = new testChouette( );
   public boolean val=false;
   public int[] D=new int[3];
   
   private testChouette() { }

   /* Static 'instance' method */
   public static testChouette getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
 
  public void init()
  {
      val=false;
      D[0]=0;
      D[1]=0;
      D[2]=0;
  }  


    
}