/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Admin;
import br.com.ribeiraoreefshop.model.entity.Usuario;

/**
 * @author Tiago Ferezin
 *
 */
public class AdminFactory {

	public void configuracoesIniciais(Admin admin, Usuario usuario,
			EntityManager entityManager) throws ConstraintViolationException,
			Exception {

		Long idAdmin = admin.getIdAdmin();

		if ((idAdmin != null) && (idAdmin > 0L)) {

			Integer config = admin.getConfig();

			if (config == 0) {
				rodaConfiguracao(admin, usuario, entityManager);
			}

		} else {
			rodaConfiguracao(admin, usuario, entityManager);
		}

	}

	public void rodaConfiguracao(Admin admin, Usuario usuario,
			EntityManager entityManager) throws ConstraintViolationException,
			Exception {
		// TODO Auto-generated method stub
		usuario = new Usuario();
		UsuarioFactory usuarioFactory = new UsuarioFactory();
		GenericDAOFactory genericDaoFactory = new GenericDAOFactory();

		genericDaoFactory.create(usuario, entityManager);

	}

}
