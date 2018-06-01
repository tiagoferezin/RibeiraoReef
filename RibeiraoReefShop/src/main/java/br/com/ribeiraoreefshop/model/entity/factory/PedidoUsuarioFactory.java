/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.CarrinhoUsuario;
import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.PedidoUsuario;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 * @data 31/05/2018
 */
public class PedidoUsuarioFactory {

	GenericDAOFactory genericDAOFactory = new GenericDAOFactory();

	public void gerarPedidoUsuario(Usuario usuario,
			CarrinhoUsuario carrinhoUsuario, EntityManager entityManager)
			throws Exception {

		genericDAOFactory = new GenericDAOFactory();
		Pedido pedido = new Pedido();
		Carrinho carrinho = new Carrinho();
		CarrinhoFactory cf = new CarrinhoFactory();
		Long idCarrinho = carrinhoUsuario.getCarrinho().getIdCarrinho();
		carrinho = cf.getCarrinho(idCarrinho, entityManager);
		PedidoUsuario pedidoUsuario = new PedidoUsuario();

		ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = pcf.getListaDeProdutosDoCarrinho(carrinho,
				entityManager);
		pedido.setValorComFrete(carrinho.getTotal());
		pedido.setValorSemFrete(carrinho.getTotalSemFrete());
		Integer pontosGeradoPedido = 0;
		PontosPedidoFactory pontosPedidoFactory = new PontosPedidoFactory();
		pontosGeradoPedido = pontosPedidoFactory.pontosDoPedido(pedido,
				entityManager);
		pedido.setPontos(pontosGeradoPedido);

	}

	public Usuario getUsuarioDoPedido(Pedido pedido, EntityManager entityManager)
			throws Exception {
		Usuario result = new Usuario();
		Usuario usuario = new Usuario();
		genericDAOFactory = new GenericDAOFactory();

		String where = "(t.pedido = :pedido)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		whereParameters.add(new NameValuePair("pedido", pedido));

		PedidoUsuario pedidoUsuario = new PedidoUsuario();
		pedidoUsuario = (PedidoUsuario) genericDAOFactory.read(pedidoUsuario,
				entityManager, where, whereParameters);

		Long idUsuario = 0L;
		if ((pedidoUsuario.getIdPedidoUsuario() != null)
				&& (pedidoUsuario.getIdPedidoUsuario() > 0L)) {
			idUsuario = pedidoUsuario.getUsuario().getIdUsuario();
			if ((idUsuario != null) && (idUsuario > 0L)) {
				result = (Usuario) genericDAOFactory.readPorId(usuario,
						entityManager, idUsuario);
			}
		}
		return result;

	}

}
