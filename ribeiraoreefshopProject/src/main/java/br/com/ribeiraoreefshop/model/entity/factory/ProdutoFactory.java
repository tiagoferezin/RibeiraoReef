/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Produto;

/**
 * @author Tiago Ferezin
 *
 */
public class ProdutoFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public Produto getProduto(Long idProduto, EntityManager entityManager)
			throws Exception {

		Produto produto = new Produto();

		produto = (Produto) daoFactory.readPorId(produto, entityManager,
				idProduto);

		return produto;

	}

	public List<Produto> listarProdutosAtivos(EntityManager entityManager)
			throws Exception {

		List<Produto> listaProduto = new ArrayList<Produto>();

		Produto produto = new Produto();
		List<AEntity> lista = new ArrayList<AEntity>();

		lista = daoFactory.readAllActives(produto, entityManager);

		for (AEntity aEntity : lista) {
			produto = (Produto) aEntity;
			listaProduto.add(produto);
		}
		return listaProduto;

	}

}
