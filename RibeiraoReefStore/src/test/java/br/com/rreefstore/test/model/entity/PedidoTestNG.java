/**
 * 
 */
package br.com.rreefstore.test.model.entity;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rreefstore.model.entity.Pedido;
import br.com.rreefstore.model.entity.Pessoa;
import br.com.rreefstore.model.entity.factory.PedidoFactory;
import br.com.rreefstore.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class PedidoTestNG extends ATestDAO<Pedido> {

	Pedido pedido = new Pedido();

	@BeforeTest
	@Override
	public void beforeTest() throws Exception {
		// TODO Auto-generated method stub
		super.beforeTest();
	}

	@AfterTest
	@Override
	public void afterTest() {
		// TODO Auto-generated method stub
		super.afterTest();
	}

	@Test(priority = 15)
	public void testeGeracaoCodigo() {
		PedidoFactory pf = new PedidoFactory();
		Long id = pedido.getId();
		String codigoGerado = "";
		codigoGerado = pf.getCodigo(id);
	}

	@Test(priority = 10)
	@Override
	public void criacao() {
		// TODO Auto-generated method stub
		String erro = "";
		try {

			pedido = new Pedido();
			pedido.setDataCriacao(Calendar.getInstance());
			pedido.setQuantidade(10);
			genericDAOFactory.create(pedido, this.entityManager);

			Assert.assertNotNull(pedido.getIdPedido());
			Assert.assertNotEquals(pedido.getIdPedido(), 0L);

		} catch (Exception e) {
			// TODO: handle exception
			erro = e.getMessage();
			e.printStackTrace();
		}
		Assert.assertEquals(erro, "");
	}

	@Override
	public void consulta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delecao() {
		// TODO Auto-generated method stub

	}

}
