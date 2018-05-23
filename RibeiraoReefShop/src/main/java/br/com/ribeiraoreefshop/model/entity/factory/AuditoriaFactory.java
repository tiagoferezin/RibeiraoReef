/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.model.entity.Auditoria;
import br.com.ribeiraoreefshop.model.enumerador.ETipoAuditoria;

/**
 * @author Tiago Ferezin
 *
 */
public class AuditoriaFactory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Auditoria getAuditoria(EntityManager entityManager) {

		Auditoria auditoria = new Auditoria();
		auditoria.setEntityManager(entityManager);
		auditoria.setDataOcorrencia(Calendar.getInstance());
		auditoria.setTipoAuditoria(ETipoAuditoria.Processo);
		return auditoria;

	}

}
