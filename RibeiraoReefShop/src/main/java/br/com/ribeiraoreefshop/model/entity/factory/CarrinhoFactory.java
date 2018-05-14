/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;

/**
 * @author Tiago Ferezin
 *
 */
public class CarrinhoFactory {

	public Double valorTotalSemFrete(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		Double resultado = 0D;

		for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {

			resultado = resultado + produtoCarrinho.getValorTotal();

		}

		result = resultado;

		return result;

	}

	public Double getValorTotalDoCarrinho(Frete frete,
			List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		Double valorSemFrete = this.valorTotalSemFrete(listaProdutoCarrinho);
		Double valorDoFrete = frete.getValorFrete();

		result = valorSemFrete + valorDoFrete;

		return result;

	}

	public Double calcularPesoTotal(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		Double peso = 0D;

		for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
			peso = peso + produtoCarrinho.getProduto().getPeso();
		}

		result = peso;

		return result;

	}

	public Double calcularAlturaPacote(
			List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		Double altura = 0D;
		for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
			Double alturaDoProduto = produtoCarrinho.getProduto().getAltura();
			if (alturaDoProduto > altura) {
				altura = alturaDoProduto;
			}

		}

		result = altura + 5D;
		return result;
	}

	public Double calcularLargura(List<ProdutoCarrinho> listaProdutoCarrinho) {

		Double result = 0D;
		Double largura = 0D;
		for (ProdutoCarrinho produtoCarrinho : listaProdutoCarrinho) {
			Double larguraDoProduto = produtoCarrinho.getProduto().getLargura();
			if (larguraDoProduto > largura) {
				largura = larguraDoProduto;
			}
		}

		if (largura <= 11D) {
			largura = 12D;
		}

		if(largura>104D){
			result = 0D;
		}
		
		return result;

	}

}
