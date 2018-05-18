/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.CarrinhoUsuario;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 *
 */
public class CarrinhoUsuarioFactory {

	public Carrinho carrinhoDoUsuario(Usuario usuario,
			EntityManager entityManager) {

		Carrinho result = new Carrinho();

		String where = "";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();

		try {
			CarrinhoUsuario carrinhoUsuario = new CarrinhoUsuario();
			GenericDAOFactory daoFactory = new GenericDAOFactory();
			
			where="(t.idUsuario = :idUsuario)";
			whereParameters.add(new NameValuePair("idUsuario", usuario.getIdUsuario()));

			List<AEntity> listaCarrinhoUsuario = new ArrayList<AEntity>();
			listaCarrinhoUsuario = daoFactory.read(carrinhoUsuario,
					entityManager, where, whereParameters);
			if (listaCarrinhoUsuario.size() > 0) {
				carrinhoUsuario = (CarrinhoUsuario) listaCarrinhoUsuario.get(0);
			}
			
			Long idCarrinho = carrinhoUsuario.getCarrinho().getIdCarrinho();
			Carrinho carrinho = new Carrinho();
			result  = (Carrinho) daoFactory.readPorId(carrinho, entityManager, idCarrinho);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;

	}

}
