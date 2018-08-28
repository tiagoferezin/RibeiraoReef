/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;

/**
 * @author Tiago Ferezin Data: 27/08/2018
 */
public class ProdutoCarrinhoFactory {

	public Double valorTotalDoProdutoPelaQuantidade(ProdutoCarrinho produtoCarrinho) {
		Double retorno = 0D;

		Double valorUnitario = produtoCarrinho.getProduto().getValor();
		Integer quantidade = produtoCarrinho.getQuantidade();

		retorno = valorUnitario * quantidade;

		return retorno;
	}

}
