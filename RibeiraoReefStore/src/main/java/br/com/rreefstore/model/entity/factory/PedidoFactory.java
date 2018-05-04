/**
 * 
 */
package br.com.rreefstore.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.rreefstore.dao.factory.GenericDAOFactory;
import br.com.rreefstore.model.entity.AEntity;
import br.com.rreefstore.model.entity.Pedido;
import br.com.rreefstore.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 *
 */
public class PedidoFactory {

	private static final String ZERO_FILL = "#" + "%08d";

	public String getCodigo(Long id) {
		return id == null ? null : String.format(ZERO_FILL, id);
	}
}
