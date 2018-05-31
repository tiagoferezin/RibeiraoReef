/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.utils.Normalizacao;
import br.com.ribeiraoreefshop.utils.VerificacaoData;

/**
 * @author Tiago Ferezin
 *
 */
public class PedidoFactory {

	private static final String ZERO_FILL = "#" + "%08d";

	public String getCodigo(Long id) {
		return id == null ? null : String.format(ZERO_FILL, id);
	}

	public String geraCodigo(Pedido pedido, EntityManager entityManager)
			throws Exception {
		String result = "";
		List<AEntity> lista = new ArrayList<AEntity>();
		GenericDAOFactory genericDaoFactory = new GenericDAOFactory();
		Boolean mesmoMes = false;
		String numeralPedido = "";

		lista = genericDaoFactory.readAllActives(pedido, entityManager);
		Pedido pedidoAnterior = new Pedido();
		if (lista.size() > 0) {
			pedidoAnterior = (Pedido) lista.get(lista.size() - 1);
		}

		Calendar dataDoPedido = pedido.getDataCriacao();

		if ((pedidoAnterior.getIdPedido() != null)
				&& (pedidoAnterior.getIdPedido() > 0L)) {
			Calendar dataPedidoAnterior = pedidoAnterior.getDataCriacao();

			mesmoMes = VerificacaoData.isMesmoMes(dataPedidoAnterior,
					dataDoPedido);
			numeralPedido = pedidoAnterior.getNumeroPedido();
		}

		Long numero = 0L;
		if ((numeralPedido != "") && (mesmoMes)) {
			numero = Normalizacao.retornaNumerosDaString(numeralPedido);
			numero = numero + 1;
			result = "#" + numero + "RR";

		} else {
			String ano = String.valueOf(dataDoPedido.get(Calendar.YEAR));
			String mes = String.valueOf(dataDoPedido.get(Calendar.MONTH));
			numero = 1L;
			result = "#" + ano + mes + String.format("%08d", numero) + "RR";
		}

		return result;
	}
}
