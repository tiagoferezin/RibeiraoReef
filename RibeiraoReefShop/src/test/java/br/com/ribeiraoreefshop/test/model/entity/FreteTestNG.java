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
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.entity.factory.CarrinhoFactory;
import br.com.ribeiraoreefshop.model.entity.factory.FreteFactory;
import br.com.ribeiraoreefshop.model.enumerador.EAvisoRecebimento;
import br.com.ribeiraoreefshop.model.enumerador.EMaoPropria;
import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;
import br.com.ribeiraoreefshop.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class FreteTestNG extends ATestDAO<Frete> {

	Frete frete = new Frete();
	FreteFactory ff = new FreteFactory();
	String cep = "14.056-742";
	Double peso = 0D;

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
		Double valor = 0D;
		

		try {
			Carrinho carrinho = new Carrinho();
			CarrinhoFactory cf = new CarrinhoFactory();
			List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
			
			listaCarrinho = cf.listarCarrinhosAtivos(this.entityManager);
			if (listaCarrinho.size() > 0) {
				carrinho = listaCarrinho.get(0);
			} else {
				CarrinhoTestNG carrinhoTeste = new CarrinhoTestNG();
				carrinhoTeste.criacao();
				listaCarrinho = cf.listarCarrinhosAtivos(this.entityManager);
				carrinho = listaCarrinho.get(0);
			}

			peso = ff.getPesoDoFrete(carrinho, this.entityManager);
			frete.setCep(cep);
			frete.setPeso(peso);
			frete.setTipoFrete(ETipoFrete.SEDEX);
			valor = ff.getValorDoFreteComSeguro(frete, "14170-570", cep, carrinho, EMaoPropria.NAO, EAvisoRecebimento.NAO);

			
			genericDAOFactory.create(frete, this.entityManager);

			Assert.assertNotNull(frete.getIdFrete());
			Assert.assertNotEquals(frete.getIdFrete(), 0L);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			erro = e.getMessage();
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
