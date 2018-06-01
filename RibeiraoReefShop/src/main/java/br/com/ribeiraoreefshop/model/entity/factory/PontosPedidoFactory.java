/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.Pontos;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class PontosPedidoFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public Integer pontosDoPedido(Pedido pedido, EntityManager entityManager)
			throws Exception {

		Integer result = 0;

		daoFactory = new GenericDAOFactory();
		Pontos pontosConfig = new Pontos();
		pontosConfig = (Pontos) daoFactory.readAllActives(pontosConfig,
				entityManager);
		Double valorDoPedido = 0D;
		Double valorPonto = 0D;

		valorDoPedido = pedido.getValorSemFrete();
		valorPonto = pontosConfig.getValor();
		double resultado = valorDoPedido * valorPonto;
		resultado = Normalizacao.arredondar(resultado, 0, 1);
		result = (int) resultado;

		return result;

	}

}
