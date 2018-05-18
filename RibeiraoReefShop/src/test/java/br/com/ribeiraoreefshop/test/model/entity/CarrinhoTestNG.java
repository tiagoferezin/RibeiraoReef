/**
 * 
 */
package br.com.ribeiraoreefshop.test.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.model.entity.factory.CarrinhoFactory;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoCarrinhoFactory;
import br.com.ribeiraoreefshop.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class CarrinhoTestNG extends ATestDAO<Carrinho> {
	Carrinho carrinho = new Carrinho();

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

	@Test(priority = 10)
	@Override
	public void criacao() {
		// TODO Auto-generated method stub
		String erro = "";
		Double comprimento = 0D;
		Double altura = 0D;
		Double largura = 0D;
		Double valor = 0D;
		Double valorSemFrete = 0D;

		try {
			CarrinhoFactory cf = new CarrinhoFactory();
			List<ProdutoCarrinho> lista = new ArrayList<ProdutoCarrinho>();
			ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();
			if ((carrinho.getIdCarrinho() != null)
					&& (carrinho.getIdCarrinho() > 0L)) {
				lista = pcf.getProdutosDoCarrinho(carrinho, this.entityManager);

				
				comprimento = cf.calcularComprimento(lista);
				altura = cf.calcularAlturaPacote(lista);
				largura = cf.calcularLargura(lista);
				valor = cf.valorTotalSemFrete(lista);
			}
			valorSemFrete = cf.valorTotalSemFrete(lista);

			carrinho = new Carrinho();
			carrinho.setTotalSemFrete(valorSemFrete);
			carrinho.setAlturaTotal(altura);
			carrinho.setComprimentoTotal(comprimento);
			carrinho.setLarguraTotal(largura);
			carrinho.setDiametroTotal(0D);
			carrinho.setTotal(valor);

			genericDAOFactory.create(carrinho, this.entityManager);

			Assert.assertNotNull(carrinho.getIdCarrinho());
			Assert.assertNotEquals(carrinho.getIdCarrinho(), 0L);

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
