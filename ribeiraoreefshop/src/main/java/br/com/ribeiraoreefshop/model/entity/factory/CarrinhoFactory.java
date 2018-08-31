/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.List;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Produto;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
public class CarrinhoFactory {

	public Carrinho dadosParaFreteDoCarrinho(
			List<Produto> listaDeProdutosCarrinho) {
		Carrinho retorno = new Carrinho();
		retorno.setPesoTotal(0D);
		retorno.setAlturaTotal(0D);
		retorno.setComprimentoTotal(0D);
		retorno.setLarguraTotal(0D);
		retorno.setTotal(0D);

		for (Produto produto : listaDeProdutosCarrinho) {
			Double peso = produto.getPeso();
			Double pesoTotal = retorno.getPesoTotal();
			retorno.setPesoTotal(pesoTotal + peso);
			Double alturaTotal = retorno.getAlturaTotal();
			Double altura = produto.getAltura();
			Double larguraTotal = retorno.getLarguraTotal();
			Double largura = produto.getLargura();
			Double comprimentoTotal = retorno.getComprimentoTotal();
			Double comprimento = produto.getComprimento();
			Double valor = produto.getValor();
			Double valorTotal = retorno.getTotal();

			retorno.setComprimentoTotal(comprimentoTotal + comprimento + 2D);
			retorno.setLarguraTotal(larguraTotal + largura);

			if (altura > alturaTotal) {
				retorno.setAlturaTotal(alturaTotal + altura + 4D);
			} else {
				retorno.setAlturaTotal(alturaTotal + 4D);
			}

			retorno.setTotal(valorTotal + valor);
		}

		return retorno;
	}

}
