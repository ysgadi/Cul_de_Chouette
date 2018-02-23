
package servlet;

import Donnes.Joueur;
import java.util.ArrayList;
import java.util.List;


public class listePlayerOn {
   
    
  public List<Joueur> list=new ArrayList<Joueur>();
  public int i=0;
  
  private static listePlayerOn singleton = new listePlayerOn( );

  
   private listePlayerOn() { }


   public static listePlayerOn getInstance( ) {
      return singleton;
   }


  
  protected void addJoueur(Joueur j)
{
    list.add(j);
    i++;
}
protected  void removeJoueur(Joueur j)
{
    list.remove(j);
}

    protected List<Joueur> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "sessionList{" + "list=" + list + '}';
    }
     
    public void AfficheConnect(List<Joueur> list,Joueur j)
    {
         for (Joueur e : list) {
         if(!e.equals(j))
         {
           System.out.print(e.getPseudo());
         }
       
        }
    }

    public int getI() {
        return i;
    }
    
}

