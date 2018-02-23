
package servlet;
import Donnes.Joueur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;



public class sessionList {
    
  public List<Joueur> list=new ArrayList<Joueur>();
  
  private static sessionList singleton = new sessionList( );

  
   private sessionList() { }

  
   public static sessionList getInstance( ) {
      return singleton;
   }

  
  
  protected void addJoueur(Joueur j)
{
    list.add(j);
}
protected  void removeJoueur(Joueur j)
{
    list.remove(j);
}

    protected List<Joueur> getList() {
        return this.list;
    }
    protected int taille()
    {
        return this.list.size();
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
}
