/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.PedidoUsuario;
import br.com.ribeiraoreefshop.model.entity.Pontos;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin Data: 01/06/2018
 */
public class PontosUsuarioFactory {

	public Double getDescontoPorPontos(Usuario usuario,
			EntityManager entityManager) throws Exception {
		Double result = 0D;

		Integer pontosUsuario = usuario.getPontos();

		if (pontosUsuario > 0) {
			GenericDAOFactory genericDAOFactory = new GenericDAOFactory();

			Pontos configPonto = new Pontos();
			configPonto = (Pontos) genericDAOFactory.readAllActives(
					configPonto, entityManager);

			Double valorDoPonto = 0D;
			valorDoPonto = configPonto.getValorResgate();
			result = valorDoPonto * pontosUsuario;

		}

		return result;

	}

	public void adicionarPontosUsuario(Pedido pedido,
			EntityManager entityManager) throws Exception {
		GenericDAOFactory genericDAOFactory = new GenericDAOFactory();
		Usuario usuario = new Usuario();
		PedidoUsuario pedidoUsuario = new PedidoUsuario();

		Integer pontos = 0;
		Integer pontosDoUsuario = 0;

		pontos = pedido.getPontos();

		if (pontos > 0) {
			String where = "(t.pedido = :pedido)";
			List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
			whereParameters.add(new NameValuePair("pedido", pedido));
			pedidoUsuario = (PedidoUsuario) genericDAOFactory.read(
					pedidoUsuario, entityManager, where, whereParameters);

			Long idUsuario = pedidoUsuario.getUsuario().getIdUsuario();
			usuario = (Usuario) genericDAOFactory.readPorId(usuario,
					entityManager, idUsuario);

			pontosDoUsuario = usuario.getPontos();

			Integer pontosTotal = pontosDoUsuario + pontos;
			usuario.setPontos(pontosTotal);
			genericDAOFactory.update(usuario, entityManager);

		}

	}
}
