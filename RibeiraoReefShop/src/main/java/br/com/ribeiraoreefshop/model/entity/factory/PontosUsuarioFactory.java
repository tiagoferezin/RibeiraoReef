/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.PedidoUsuario;
import br.com.ribeiraoreefshop.model.entity.Pontos;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.Normalizacao;

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

			PedidoUsuarioFactory puf = new PedidoUsuarioFactory();
			usuario = puf.getUsuarioDoPedido(pedido, entityManager);
			// String where = "(t.pedido = :pedido)";
			// List<NameValuePair> whereParameters = new
			// ArrayList<NameValuePair>();
			// whereParameters.add(new NameValuePair("pedido", pedido));
			// pedidoUsuario = (PedidoUsuario) genericDAOFactory.read(
			// pedidoUsuario, entityManager, where, whereParameters);
			//
			// Long idUsuario = pedidoUsuario.getUsuario().getIdUsuario();
			// usuario = (Usuario) genericDAOFactory.readPorId(usuario,
			// entityManager, idUsuario);

			pontosDoUsuario = usuario.getPontos();

			Integer pontosTotal = pontosDoUsuario + pontos;
			usuario.setPontos(pontosTotal);
			genericDAOFactory.update(usuario, entityManager);

		}

	}

	public void removerPontosDoUsuario(Pedido pedido, Integer pontosUsados,
			EntityManager entityManager) throws Exception {

		GenericDAOFactory genericDAOFactory = new GenericDAOFactory();
		Usuario usuario = new Usuario();
		PedidoUsuarioFactory puf = new PedidoUsuarioFactory();
		usuario = puf.getUsuarioDoPedido(pedido, entityManager);
		Integer pontosUsuario = 0;
		pontosUsuario = usuario.getPontos();

		if (pontosUsuario > pontosUsados) {

			Integer pontosRestantes = 0;
			pontosRestantes = pontosUsuario - pontosUsados;
			usuario.setPontos(pontosRestantes);
			genericDAOFactory.update(usuario, entityManager);

		}

	}

	public Double descontoPelaPontuacao(Usuario usuario, Integer pontos,
			EntityManager entityManager) throws Exception {
		Double result = 0D;
		GenericDAOFactory genericDAOFactory = new GenericDAOFactory();
		Integer pontosDoUsuario = 0;
		pontosDoUsuario = usuario.getPontos();
		Pontos pontosConfig = new Pontos();
		pontosConfig = (Pontos) genericDAOFactory.readAllActives(pontosConfig,
				entityManager);
		PontosFactory pf = new PontosFactory();

		Double valorDoPonto = pf.valorDoPonto(pontosConfig);
		result = pontos * valorDoPonto;
		result = Normalizacao.arredondar(result, 2, 0);

		return result;

	}

}
