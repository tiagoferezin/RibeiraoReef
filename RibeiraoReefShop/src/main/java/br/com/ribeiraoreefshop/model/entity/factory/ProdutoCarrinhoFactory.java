/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 *
 */
public class ProdutoCarrinhoFactory {

	public Double getValorTotalComQuantidade(Integer quantidade,
			Double valorUnitario) {

		Double result = 0D;

		result = valorUnitario * quantidade;

		return result;

	}

	public void adicionarItemAoCarrinho(Long idProduto,
			EntityManager entityManager, Carrinho carrinho, Integer quantidade) {

		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

		Produto produto = new Produto();

		GenericDAOFactory daoFactory = new GenericDAOFactory();

		try {

			produto = (Produto) daoFactory.readPorId(produto, entityManager,
					idProduto);

			Double valorTotal = 0D;
			valorTotal = getValorTotalComQuantidade(quantidade,
					produto.getValor());
			produtoCarrinho.setCarrinho(carrinho);
			produtoCarrinho.setProduto(produto);
			produtoCarrinho.setValorUnitario(produto.getValor());
			produtoCarrinho.setQuantidade(quantidade);
			produtoCarrinho.setValorTotal(valorTotal);
			daoFactory.create(produtoCarrinho, entityManager);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluirProdutoDoCarrinho(Long idProdutoCarrinho,
			EntityManager entityManager) {

		GenericDAOFactory daoFactory = new GenericDAOFactory();

		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

		produtoCarrinho = getProdutoCarrinho(idProdutoCarrinho, entityManager);

		try {
			daoFactory.delete(produtoCarrinho, entityManager);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ProdutoCarrinho getProdutoCarrinho(Long idProdutoCarrinho,
			EntityManager entityManager) {
		ProdutoCarrinho result = new ProdutoCarrinho();
		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

		GenericDAOFactory daoFactory = new GenericDAOFactory();
		try {
			result = (ProdutoCarrinho) daoFactory.readPorId(produtoCarrinho,
					entityManager, idProdutoCarrinho);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<ProdutoCarrinho> getProdutosDoCarrinho(Carrinho carrinho,
			EntityManager entityManager) {
		List<ProdutoCarrinho> result = new ArrayList<ProdutoCarrinho>();
		GenericDAOFactory daoFactory = new GenericDAOFactory();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = getListaDeProdutosDoCarrinho(carrinho, entityManager);
		List<ProdutoCarrinho> listaProdutoCarrinho = new ArrayList<ProdutoCarrinho>();
		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

		String where = "(t.idCarrinho = :idCarrinho)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		NameValuePair nameValuePair = new NameValuePair("idCarrinho",
				carrinho.getIdCarrinho());
		whereParameters.add(nameValuePair);

		try {

			List<AEntity> listaEntity = new ArrayList<AEntity>();
			listaEntity = daoFactory.read(produtoCarrinho, entityManager,
					where, whereParameters, true);

			for (AEntity aEntity : listaEntity) {
				result.add((ProdutoCarrinho) aEntity);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

	public List<Produto> getListaDeProdutosDoCarrinho(Carrinho carrinho,
			EntityManager entityManager) {

		List<Produto> result = new ArrayList<Produto>();
		Produto produto = new Produto();
		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

		String where = "(t.idCarrinho = :idCarrinho)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		NameValuePair nameValuePair = new NameValuePair("idCarrinho",
				carrinho.getIdCarrinho());
		whereParameters.add(nameValuePair);
		GenericDAOFactory daoFactory = new GenericDAOFactory();
		List<AEntity> lista = new ArrayList<AEntity>();

		List<ProdutoCarrinho> listaProdutoCarrinho = new ArrayList<ProdutoCarrinho>();
		try {

			lista = daoFactory.read(produtoCarrinho, entityManager, where,
					whereParameters);

			for (AEntity aEntity : lista) {
				listaProdutoCarrinho.add((ProdutoCarrinho) aEntity);

			}

			for (ProdutoCarrinho pc : listaProdutoCarrinho) {
				Long idProduto = pc.getProduto().getId();
				produto = (Produto) daoFactory.readPorId(produto,
						entityManager, idProduto);
				result.add(produto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
