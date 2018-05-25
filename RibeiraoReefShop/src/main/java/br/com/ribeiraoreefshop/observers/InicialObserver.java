/**
 * 
 */
package br.com.ribeiraoreefshop.observers;

import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.events.VRaptorInitialized;
import br.com.ribeiraoreefshop.utils.JPAUtil;

/**
 * @author Tiago Ferezin
 *
 */
public class InicialObserver {
	
	public void iniciarApp(@Observes VRaptorInitialized evento){
		
		EntityManager entityManager = JPAUtil.criarEntityManager();
		
	}

}
