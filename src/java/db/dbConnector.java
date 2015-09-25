package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class dbConnector {
    private static dbConnector instance;
    
    private EntityManagerFactory emf;
    
    private dbConnector(){
        emf = Persistence.createEntityManagerFactory("Exam_Preparation_REST_APIPU");
    }
    
    public static dbConnector Instance(){
        if(instance == null)
            instance = new dbConnector();
        return instance;
    }
    
    public EntityManager getEm(){
        return emf.createEntityManager();
    }
}
