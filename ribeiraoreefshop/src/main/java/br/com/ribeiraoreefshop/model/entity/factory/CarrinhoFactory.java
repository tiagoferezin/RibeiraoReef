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
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;

/**
 * @author Tiago Ferezin
 *
 */
public class CarrinhoFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public Carrinho getCarrinho(Long idCarrinho, EntityManager entityManager)
			throws Exception {

		Carrinho carrinho = new Carrinho();

		carrinho = (Carrinho) daoFactory.readPorId(carrinho, entityManager,
				idCarrinho);

		return carrinho;

	}

	public List<Carrinho> listarCarrinhosAtivos(EntityManager entityManager)
			throws Exception {

		List<Carrinho> listaProduto = new ArrayList<Carrinho>();

		Carrinho carrinho = new Carrinho();
		List<AEntity> lista = new ArrayList<AEntity>();

		lista = daoFactory.readAllActives(carrinho, entityManager);

		for (AEntity aEntity : lista) {
			carrinho = (Carrinho) aEntity;
			listaProduto.add(carrinho);
		}
		return listaProduto;

	}

	public Double valorTotalSemFrete(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double resultado = 0D;

			for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {

				resultado = resultado + produtoCarrinho.getValorTotal();

			}

			result = resultado;
		}
		return result;

	}

	public Double getValorTotalDoCarrinho(Frete frete,
			List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double valorSemFrete = this
					.valorTotalSemFrete(listaProdutoCarrinho);
			Double valorDoFrete = 0D;
			Long idFrete = frete.getIdFrete();
			if ((idFrete != null) && (idFrete > 0L)) {
				valorDoFrete = frete.getValorFrete();
			}
			result = valorSemFrete + valorDoFrete;
		}
		return result;

	}

	public Double calcularPesoTotal(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double peso = 0D;

			for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
				peso = peso + produtoCarrinho.getProduto().getPeso();
			}

			result = peso;
		}

		return result;

	}

	public Double calcularAlturaPacote(
			List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double altura = 0D;
			for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
				Double alturaDoProduto = produtoCarrinho.getProduto()
						.getAltura();
				if (alturaDoProduto > altura) {
					altura = alturaDoProduto;
				}

			}

			result = altura + 5D;
		}
		return result;
	}

	public Double calcularLargura(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double largura = 0D;
			for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
				Double larguraDoProduto = produtoCarrinho.getProduto()
						.getLargura();
				if (larguraDoProduto > largura) {
					largura = larguraDoProduto;
				}
			}

			if (largura <= 11D) {
				largura = 12D;
			}

			if (largura > 104D) {
				result = 0D;
			}
		}

		return result;

	}

	public Double calcularComprimento(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		if (listaProdutoCarrinho.size() > 0) {
			Double comprimento = 0D;
			for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
				Double comprimentoDoProduto = produtoCarrinho.getProduto()
						.getComprimento();
				comprimento = comprimento + comprimentoDoProduto;
			}

			if (comprimento < 16D) {
				comprimento = 17D;
			}
			if (comprimento > 104D) {
				comprimento = 0D;
			}
		}
		return result;
	}

}
