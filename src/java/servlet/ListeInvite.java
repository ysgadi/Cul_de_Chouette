
package servlet;
import Donnes.Joueur;
import java.util.ArrayList;
import java.util.List;


public class ListeInvite {
  public List<Joueur> list=new ArrayList<Joueur>();
  
  private static ListeInvite singleton = new ListeInvite( );


   private ListeInvite() { }


   public static ListeInvite getInstance( ) {
      return singleton;
   }

   
  
  protected void addJoueur(Joueur j)
{
    list.add(j);
}
public  void removeJoueurs()
{
    for(Joueur e:list)
    {
    if(e.getEtat()==2)
    {
    list.remove(e);
    }
    }
}

    protected List<Joueur> getList() {
        return this.list;
    }
    protected int taille()
    {
        return list.size();
    }

    @Override
    public String toString() {
        return "sessionList{" + "list=" + list + '}';
    }
     
    public void AfficheConnect(Joueur j)
    {
         for (Joueur e : list) {
         if(!e.equals(j))
         {
           System.out.print(e.getPseudo());
          
         }
       
        }
    }
    public boolean AllRefuse()
    {
        
        int nb=0;
        for( Joueur e: list)
        {
            if(e.getEtat()==2)
                nb++;
        }
        if(nb==list.size())
            return true;
        else return false;
        
    }
    public void Accept(Joueur j)
    {
        for(Joueur e:this.list)
        {
            if(e.equals(j))
            {
              j.setEtat(1);
             break;
            }
           
        }
    }
    
    public void Refuse(Joueur j)
    {
        for(Joueur e:this.list)
        {
            if(e.equals(j))
            {
              j.setEtat(2);
              break;
            }
        }
    }
    
     public boolean TestRefuse(Joueur j)
    {
        for(Joueur e:this.list)
        {
            if(e.equals(j))
            {
              if(e.getEtat()==2)
                return true;
            }
        }
        return false;
    }
     
       public boolean TestAccept(Joueur j)
    {
        for(Joueur e:this.list)
        {
            if(e.equals(j))
            {
              if(e.getEtat()==1)
                return true;
            }
        }
        return false;
    }
    public boolean EnAtt()
    {
        
        for(Joueur e:this.list)
        {
            if(e.getEtat()==0)
            {
                return true;        
            }
        }
       return false;         
    }
    
    public void videList()
    {
       for(Joueur e:list)
        list.remove(e);
    }
    public void initList()
    {
        list.clear();
    }
    
    public void AfficheList()
    {
        for(Joueur e:list)
       System.out.println(e.getPseudo());
    }
   
    
}
