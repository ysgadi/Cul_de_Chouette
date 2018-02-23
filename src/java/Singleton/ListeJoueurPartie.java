/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Donnes.Joueur;
import java.util.ArrayList;
import java.util.List;
import servlet.ListeInvite;

/**
 *
 * @author utilisateur
 */
public class ListeJoueurPartie {
   public List<Joueur> list=new ArrayList<Joueur>();
  
  private static ListeJoueurPartie singleton = new ListeJoueurPartie( );

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private ListeJoueurPartie() { }

   /* Static 'instance' method */
   public static ListeJoueurPartie getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
  
  protected void addJoueur(Joueur j)
{
    list.add(j);
}
public  void removeJoueurs(Joueur j)
{
    for(Joueur e:list)
    {
    if(e.equals(j))
    list.remove(e);
    break;
    }
    }


    public int taille()
    {
        return list.size();
    }

    @Override
    public String toString() {
        return "sessionList{" + "list=" + list + '}';
    }

    public void initList()
    {
        list.clear();
    }
 public String TourJoueur(int t)
    {
        for(Joueur e:list)
        {
            if(e.getTour()==t)
            return e.getPseudo();
          
        }
        return null;
    }
    public void initDes()
    {
        for(Joueur e:list)
        {
            e.des[0]=0;
            e.des[1]=0;
            e.des[2]=0;
        }
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
       
}
