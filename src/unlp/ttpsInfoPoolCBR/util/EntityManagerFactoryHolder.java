package unlp.ttpsInfoPoolCBR.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Axel on 22/11/2014.
 */
public class EntityManagerFactoryHolder {

    private Logger _logger = LoggerFactory
            .getLogger(EntityManagerFactoryHolder.class);

    private static EntityManagerFactory emf;

    public void init() {

        try {
            _logger.info("Starting EMF Component Initter");

            emf = Persistence.createEntityManagerFactory("pulpoPaul");
            emf.createEntityManager();

            _logger.info("EMF init method executed correctly");

        } catch (Exception ex) {
            _logger.error("Error creating EMF", ex);
        }
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void beginTransaction(EntityManager em){
        EntityTransaction tx = em.getTransaction();
        if (tx != null && !tx.isActive()) {
            tx.begin();
        }
    }

    public void commitTransaction(EntityManager em){
        EntityTransaction tx = em.getTransaction();
        tx.commit();
        em.close();
    }

    public void rollbackTransaction(EntityManager em){
        EntityTransaction tx = em.getTransaction();
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        em.close();
    }
}
