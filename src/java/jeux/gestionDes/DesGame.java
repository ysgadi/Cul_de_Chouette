/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux.gestionDes;

/**
 *
 * @author utilisateur
 */
public class DesGame {
    
     public static int[] lancerDes() {
      int table[] = {0, 0, 0};
     table[0] = (int) (1 + (Math.random() * 6));
     table[1] = (int) (1 + (Math.random() * 6));
     table[2] = (int) (1 + (Math.random() * 6));
     // table[0]=  2;
     // table[1]=  3;
     //table[2]=  4;
     return table;
    }
     
    public static boolean velute(int ch1, int ch2, int cul) {
        return (ch1 + ch2) == cul;
    }

    public static boolean chouette(int ch1, int ch2) {
        return ch1 == ch2;
    }

    public static boolean culDeChouette(int ch1, int ch2, int cul) {
        return (ch1 == ch2) && (ch1 == cul);
    }

    public static boolean suite(int ch1, int ch2, int cul) {
       
        return(ch1+1==ch2 && ch2+1==cul);
    }

    public static boolean chouetteVelute(int ch1, int ch2, int cul) {
        if (chouette(ch1,ch2))
            return velute(ch1,ch2,cul);
        else
            return false;
    }

    public static int ScoreVelute(int tab[])
    
    {
      
           return tab[2]*tab[2];
    }
    public static int ScoreChouette(int tab[])
    {
        
            return tab[0]*tab[0];
            
    }
    
    public static int ScoreCulDeChouette(int tab[])
    {      
            switch(tab[0])
            {
              case(1):return 50;
               case(2):return 60;
               case(3):return 70;
               case(4):return 80;
               case(5):return 90;
               case(6):return 100;
            }//fin switch
        return 0;
    }
    
     public static int ScoreSuite()
     {
         return -10;
     }
    
}
