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
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 *
 */
public class ProdutoCarrinhoFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();
	ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();
	ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();

	public Double getValorTotalComQuantidade(Integer quantidade,
			Double valorUnitario) {

		Double result = 0D;

		result = valorUnitario * quantidade;

		return result;

	}

	public Double getValorUnitarioDoProdutoNoCarrinho(Produto produto) {
		return produto.getValor();
	}

	public void alterarQuantidadeProdutoDoCarrinho(Long idProdutoCarrinho,
			Integer novaQuantidade, EntityManager entityManager)
			throws Exception {

		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
		produtoCarrinho = (ProdutoCarrinho) daoFactory.readPorId(
				produtoCarrinho, entityManager, idProdutoCarrinho);

		produtoCarrinho.setQuantidade(novaQuantidade);
		daoFactory.update(produtoCarrinho, entityManager);

	}

	public Integer produtoExistenteNoCarrinho(Produto produto,
			Carrinho carrinho, EntityManager entityManager) throws Exception {

		Integer result = 0;
		Produto p = new Produto();
		produtoCarrinho = new ProdutoCarrinho();
		List<AEntity> lista = new ArrayList<AEntity>();
		String where = "(t.produto = :produto)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		whereParameters.add(new NameValuePair("produto", produto));
		lista = daoFactory.read(produtoCarrinho, entityManager, where,
				whereParameters);

		for (AEntity entity : lista) {
			p = (Produto) entity;
			if (p.getIdProduto() == produtoCarrinho.getProduto().getIdProduto()) {
				result = 1;
			}
		}

		return result;
	}

	public ProdutoCarrinho getProdutoCarrinhoDoCarrinho(Produto produto,
			Carrinho carrinho, EntityManager entityManager) throws Exception {
		ProdutoCarrinho result = new ProdutoCarrinho();

		String where = "";
		where = "(t.produto = :produto) and (t.carrinho = :carrinho)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		whereParameters.add(new NameValuePair("produto", produto));
		whereParameters.add(new NameValuePair("carrinho", carrinho));
		result = (ProdutoCarrinho) daoFactory.read(produtoCarrinho,
				entityManager, where, whereParameters, true);

		return result;
	}

	public Carrinho retornaCarrinhoVazio(EntityManager entityManager)
			throws ConstraintViolationException, Exception {
		Carrinho result = new Carrinho();
		Double v = 0D;
		result.setAlturaTotal(v);
		result.setComprimentoTotal(v);
		result.setLarguraTotal(v);
		result.setDiametroTotal(v);
		result.setTotal(v);
		result.setTotalSemFrete(v);
		daoFactory.create(result, entityManager);
		return result;
	}

	public void adicionarItemAoCarrinho(Long idProduto,
			EntityManager entityManager, Carrinho carrinho, Integer quantidade,
			Frete frete) {

		Long idCarrinho = carrinho.getIdCarrinho();
		if ((idCarrinho == null) || (idCarrinho == 0L)) {

			try {
				carrinho = retornaCarrinhoVazio(entityManager);
			} catch (ConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		produtoCarrinho = new ProdutoCarrinho();

		Produto produto = new Produto();
		Integer count = 0;

		try {

			produto = (Produto) daoFactory.readPorId(produto, entityManager,
					idProduto);

			count = produtoExistenteNoCarrinho(produto, carrinho, entityManager);

			if (count == 0) {

				Double valorTotal = 0D;
				valorTotal = getValorTotalComQuantidade(quantidade,
						produto.getValor());
				produtoCarrinho.setCarrinho(carrinho);
				produtoCarrinho.setProduto(produto);
				produtoCarrinho.setValorUnitario(produto.getValor());
				produtoCarrinho.setQuantidade(quantidade);
				produtoCarrinho.setValorTotal(valorTotal);

				daoFactory.create(produtoCarrinho, entityManager);

			} else {

				Long idProdutoCarrinho = 0L;
				produtoCarrinho = getProdutoCarrinhoDoCarrinho(produto,
						carrinho, entityManager);
				idProdutoCarrinho = produtoCarrinho.getIdProdutoCarrinho();
				alterarQuantidadeProdutoDoCarrinho(idProdutoCarrinho,
						quantidade, entityManager);
			}

			CarrinhoFactory cf = new CarrinhoFactory();
			List<ProdutoCarrinho> listaProdutoCarrinho = new ArrayList<ProdutoCarrinho>();

			listaProdutoCarrinho = pcf.getProdutosDoCarrinho(carrinho,
					entityManager);

			Double pesoCarrinho = cf.calcularPesoTotal(listaProdutoCarrinho);
			Double altura = cf.calcularAlturaPacote(listaProdutoCarrinho);
			Double comp = cf.calcularComprimento(listaProdutoCarrinho);
			Double largura = cf.calcularLargura(listaProdutoCarrinho);
			Double totalSemFrete = cf.valorTotalSemFrete(listaProdutoCarrinho);
			Double valorTotalCarrinho = cf.getValorTotalDoCarrinho(frete,
					listaProdutoCarrinho);

			carrinho.setAlturaTotal(altura);
			carrinho.setComprimentoTotal(comp);
			carrinho.setTotalSemFrete(totalSemFrete);
			carrinho.setTotal(valorTotalCarrinho);

			daoFactory.update(carrinho, entityManager);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluirProdutoDoCarrinho(Long idProdutoCarrinho,
			EntityManager entityManager) {

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

		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = getListaDeProdutosDoCarrinho(carrinho, entityManager);
		List<ProdutoCarrinho> listaProdutoCarrinho = new ArrayList<ProdutoCarrinho>();
		produtoCarrinho = new ProdutoCarrinho();

		String where = "(t.carrinho = :carrinho)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		NameValuePair nameValuePair = new NameValuePair("carrinho", carrinho);
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
		Long idCarrinho = carrinho.getIdCarrinho();
		if ((idCarrinho != null) && (idCarrinho > 0L)) {
			Produto produto = new Produto();
			produtoCarrinho = new ProdutoCarrinho();

			String where = "(t.carrinho = :carrinho)";
			List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
			NameValuePair nameValuePair = new NameValuePair("carrinho",
					carrinho);
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

		}

		return result;

	}
}
