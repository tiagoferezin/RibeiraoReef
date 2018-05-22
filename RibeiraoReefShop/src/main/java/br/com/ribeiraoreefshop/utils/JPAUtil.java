/**
 * 
 */
package br.com.ribeiraoreefshop.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Tiago Ferezin
 *
 */
@ApplicationScoped
public class JPAUtil {
	
	private EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("postgreSQL");
	
	
	public JPAUtil() {
		// TODO Auto-generated constructor stub
	}
	
	@Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        em.close();
    }

}
