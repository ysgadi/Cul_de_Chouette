/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;
import Donnes.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author utilisateur
 */
public class DAO_JPA_Joueur extends DAO<Joueur>{

    @Override
    public Joueur find(Joueur data) throws DAOException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         Joueur j=em.find(Joueur.class,data.getPseudo());
         em.close();
       if(j==null)
       {
           return null;
         // throw new DAOException("Le joueur "+data.getPseudo()+" n'existe pas");
       }
        return j;
      

//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Joueur data) throws DAOException {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
        Joueur j=em.find(Joueur.class,data.getPseudo());
          if(j!=null)
       {
           
           throw new DAOException("le joueur "+data.getPseudo()+" existe déja");
       }
          else
          {
           em.persist(data);
         }
          
        transac.commit();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    @Override
    public void update(Joueur data) throws DAOException {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Joueur j=em.find(Joueur.class,data.getPseudo());
         if(j==null)
           throw new DAOException("le joueur "+data.getPseudo()+" n'exist pas");
         else
             //j.setPseudo("f45");
         {
             
             if(data.getPassword()==null)
               data.setPassword(j.getPassword());
             if(data.getAge()==null)
               data.setAge(j.getAge());
              if(data.getSexe()==null)
               data.setSexe(j.getSexe());
               if(data.getVille()==null)
               data.setVille(j.getVille());
             
              /********************************************/
                if(j.getNbrPartieJouer()==null &&data.getNbrPartieJouer()!=null )
               data.setNbrPartieJouer(data.getNbrPartieJouer());
                else
                {
                   if(j.getNbrPartieJouer()!=null &&data.getNbrPartieJouer()!=null )
                data.setNbrPartieJouer(j.getNbrPartieJouer()+data.getNbrPartieJouer());
                   else
                       data.setNbrPartieJouer(j.getNbrPartieJouer());
                }
                  if(j.getNbrVictoire()==null && data.getNbrVictoire()!=null)
                  data.setNbrVictoire(data.getNbrVictoire());
                 else
                  {  if(j.getNbrVictoire()!=null && data.getNbrVictoire()!=null)
                     data.setNbrVictoire(j.getNbrVictoire()+data.getNbrVictoire()); 
                     else
                       data.setNbrVictoire(j.getNbrVictoire());
                  }
                   if(data.getNbrchouettesperdues()==null && j.getNbrchouettesperdues()!=null)
                       data.setNbrchouettesperdues(j.getNbrchouettesperdues());
                    if(data.getNbrsuitesgagnes()==null && j.getNbrsuitesgagnes()!=null)
                       data.setNbrsuitesgagnes(j.getNbrsuitesgagnes());
               
             
             /***********************************************/  
             if(data.getNbrVectMoyen()==null && j.getNbrVectMoyen()!=null) 
             data.setNbrVectMoyen(j.getNbrVectMoyen());
             if(data.getScoreMoy()==null && j.getNbrVectMoyen()!=null)
             data.setScoreMoy(j.getScoreMoy());
              if(data.getMoyNbrSuiteGagner()==null && j.getMoyNbrSuiteGagner()!=null)
              data.setMoyNbrSuiteGagner(j.getMoyNbrSuiteGagner());
              if(data.getMoyNbrChouPerdue()==null && j.getMoyNbrChouPerdue()!=null)
              data.setMoyNbrChouPerdue(j.getMoyNbrChouPerdue());
               
             em.merge(data);
         }
         transac.commit();    
         

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Joueur data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Joueur j=em.find(Joueur.class,data.getPseudo());
         if(j==null)
           throw new DAOException("le joueur "+data.getPseudo()+" n'exist pas");
         else
             em.remove(em.merge(data));
         transac.commit();
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
