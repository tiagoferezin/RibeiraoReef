/**
 * 
 */
package br.com.ribeiraoreefshop.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Tiago Ferezin
 *
 */
public class JPAUtil {
		private EntityManagerFactory entityManagerFactory;
//	
//	
//	public JPAUtil() {
//		// TODO Auto-generated constructor stub
//	}
	
	public static EntityManager criarEntityManager(){
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("postgreSQL");
	      
	      return entityManagerFactory.createEntityManager();
	}
	
////	@Produces
////  @RequestScoped
//    public EntityManager getEntityManager() {
//        return entityManagerFactory.createEntityManager();
//    }
//
//    public void close(@Disposes EntityManager em) {
//        em.close();
//    }
    
//    public void close(EntityManager em) {
//        em.close();
//    }

}
