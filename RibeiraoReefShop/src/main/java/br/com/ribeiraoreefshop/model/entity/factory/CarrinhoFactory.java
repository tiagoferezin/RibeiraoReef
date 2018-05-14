/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;

/**
 * @author Tiago Ferezin
 *
 */
public class CarrinhoFactory {

	public Double valorTotalSemFrete(Carrinho carrinho,
			List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;

		List<Double> listaTotais = new ArrayList<Double>();

		for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {

			listaTotais.add(produtoCarrinho.getValorTotal());

		}

		Double resultado = 0D;
		for (Double total : listaTotais) {
			resultado = resultado + total;
		}

		result = resultado;

		return result;

	}

}