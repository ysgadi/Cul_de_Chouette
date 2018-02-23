package DAOJPA;

/**
 * Factory renvoyant une factory de DAO en fonction du support de persistance choisi
 * @author Eric
 */
public class AbstractDAOFactory {

    public static CulDeChouetteDAOFactory getDAOFactory() {
      
              return new CulDeChouette_JPA_DAOFactory();
        }
    }

        

