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
public class DAO_JPA_Partie extends DAO<Partie>{

    @Override
    public Partie find(Partie data) throws DAOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         Partie p=em.find(Partie.class,data.getIdPartie());
         em.close();
       if(p==null)
       {
           throw new DAOException("La partie"+data.getIdPartie()+" n'existe pas");
       }
        return p;
      

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Partie data) throws DAOException {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
          idpartie id=idpartie.getInstance();
          int idd=id.inc();
          data.setIdPartie(idd);
           em.persist(data);  
           transac.commit();
       
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Partie data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Partie p=em.find(Partie.class,data.getIdPartie());
         if(p==null)
           throw new DAOException("la partie"+data.getIdPartie()+" n'exist pas");
         else
             //j.setPseudo("f45");
         {
            if(data.getScoretotale()==null)
               data.setScoretotale(p.getScoretotale());
             if(data.getWinner()==null)
               data.setWinner(p.getWinner());
              if(data.getNbrsuite()==null)
               data.setNbrsuite(p.getNbrsuite());
               if(data.getNbrchouettes()==null)
               data.setNbrchouettes(p.getNbrchouettes());
              
               if(data.getLimitscore()==null)
                  data.setLimitscore(p.getLimitscore());  
         em.merge(data);
         /*
           if(p.getNbrsuite()==null && data.getNbrsuite()!=null)
                  data.setNbrsuite(1);
                 else
                  {  if(p.getNbrsuite()!=null && data.getNbrsuite()!=null)
                     data.setNbrsuite(p.getNbrsuite()+1); 
                     else
                       data.setNbrsuite(p.getNbrsuite());
                  }
             
                  if(p.getNbrchouettes()==null && data.getNbrchouettes()!=null)
                  data.setNbrchouettes(1);
                 else
                  {  if(p.getNbrchouettes()!=null && data.getNbrchouettes()!=null)
                     data.setNbrchouettes(p.getNbrchouettes()+1); 
                     else
                       data.setNbrchouettes(p.getNbrchouettes());
                  }
              
         */
         }
         transac.commit();    

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Partie data) throws DAOException {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Partie j=em.find(Partie.class,data.getIdPartie());
         if(j==null)
           throw new DAOException("la partie"+data.getIdPartie()+" n'existe pas");
         else
        em.remove(em.merge(data));
         transac.commit();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
