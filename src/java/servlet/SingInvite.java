
package servlet;

import Singleton.*;
import servlet.*;
import Donnes.Joueur;
import java.util.ArrayList;
import java.util.List;


public class SingInvite {
    
 private static SingInvite singleton = null;  
    public Joueur j=null;

    private SingInvite(Joueur j) {
        this.j = j;
    }

    public synchronized static SingInvite getInstance(Joueur j) {
        if(singleton == null) singleton = new SingInvite(j);
        return singleton;
    }

 
public  Joueur get_joueur_invit()
{
return j;
}
protected void initJoueur()
{
    singleton=null;
}
}




  

