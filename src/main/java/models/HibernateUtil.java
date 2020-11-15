package models;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManager em = null;

    public static EntityManager getEM() {
        if (em == null) {
             EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodiedb");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
}