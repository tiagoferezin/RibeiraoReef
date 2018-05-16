/**
 * 
 */
package br.com.ribeiraoreefshop.test.model.entity;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.enumerador.EPermissaoEncomenda;
import br.com.ribeiraoreefshop.model.enumerador.EStatus;
import br.com.ribeiraoreefshop.test.dao.ATestDAO;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class ProdutoTestNG extends ATestDAO<Produto> {

	Produto produto = new Produto();

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

	@Test
	@Override
	public void criacao() {
		// TODO Auto-generated method stub

		String erro = "";
		Double valor = 92.5;

		
		try {

			produto = new Produto();
			produto.setNomeProduto("AF Calanus");
			produto.setEstoque(5);
			produto.setAltura(2D);
			produto.setComprimento(10D);
			produto.setDiametro(5D);
			produto.setLargura(10D);
			produto.setValor(valor);
			produto.setPeso(0.03);
			produto.setPermitirEncomenda(EPermissaoEncomenda.NAOPERMITIR);
			produto.setVenderInidividual(0);
			produto.setStatus(EStatus.PUBLICO);
			
			genericDAOFactory.create(produto, this.entityManager);
			
			Assert.assertNotNull(produto.getIdProduto());
			Assert.assertNotEquals(produto.getIdProduto(), 0L);

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
