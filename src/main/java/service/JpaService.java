package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class JpaService {

    private static JpaService instance;

    private final EntityManagerFactory entityManagerFactory;

    private JpaService(){
        entityManagerFactory = Persistence.createEntityManagerFactory("WeatherAppV2");
    }
    public static synchronized JpaService getInstance(){
        return instance == null ? instance = new JpaService() : instance;
    }

    public void shutdown(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }

    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public <T> T runInTransaction(Function<EntityManager,T>function){
        EntityManagerFactory entityManagerFactory = getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean transactionCheck = false;
        transaction.begin();
        try{
           T returnValue = function.apply(entityManager);
            transactionCheck = true;
            return returnValue;
        }finally {
            if(transactionCheck){
                transaction.commit();
            }else{
                transaction.rollback();
            }
        }
    }



}
