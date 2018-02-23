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
public class DAO_JPA_Historique extends DAO<Historique>{

    @Override
    public Historique find(Historique data) throws DAOException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         Historique h=em.find(Historique.class,data.getHistoriquePK());
         em.close();
       if(h==null)
       {
           throw new DAOException("L'historique"+data.getHistoriquePK()+" n'existe pas");
       }
        return h;
   
/// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Historique data) throws DAOException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
        Historique h=em.find(Historique.class,data.getHistoriquePK());
          if(h!=null)
       {
           throw new DAOException("L'historique "+data.getHistoriquePK()+"exist déja");
       }
          else
          {
           em.persist(data);
         }
          
        transac.commit();
       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Historique data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Historique h=em.find(Historique.class,data.getHistoriquePK());
         if(h==null)
           throw new DAOException("l'historique "+data.getHistoriquePK()+" n'exist pas");
         else
             em.merge(data);
         transac.commit();    

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Historique data) throws DAOException {
       
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplicationCulDeChouettePU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac=em.getTransaction();
         transac.begin();
         Historique h=em.find(Historique.class,data.getHistoriquePK());
         if(h==null)
           throw new DAOException("l'historique"+data.getHistoriquePK()+" n'existe pas");
         else
        em.remove(em.merge(data));
         transac.commit();
         // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
