/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

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

}
