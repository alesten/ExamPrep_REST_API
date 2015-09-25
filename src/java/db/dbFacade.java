package db;

import entity.Country;
import java.util.List;
import javax.persistence.EntityManager;

public class dbFacade {
    
    private dbConnector connector = dbConnector.Instance();
    
    public List<Country> getCountries(){
        EntityManager em = connector.getEm();
        
        List<Country> countries;
        
        try{
            em.getTransaction().begin();
            
            countries = em.createQuery("SELECT c FROM Country c").getResultList();
            
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return countries;
    }
    
    public List<Country> getCountriesWithPopGreaterThen(int pop){
        EntityManager em = connector.getEm();
        
        List<Country> countries;
        
        try{
            em.getTransaction().begin();
            
            countries = em.createQuery("SELECT c FROM Country c WHERE c.population > :pop").setParameter("pop", pop).getResultList();
            
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return countries;
    }
    
}
