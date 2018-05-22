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
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.model.entity.factory.CarrinhoFactory;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoCarrinhoFactory;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoFactory;
import br.com.ribeiraoreefshop.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class ProdutoCarrinhoTestNG extends ATestDAO<ProdutoCarrinho> {

	ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
	Carrinho carrinho = new Carrinho();
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

	@Test(priority = 10)
	@Override
	public void criacao() {
		// TODO Auto-generated method stub

		String erro = "";

		List<Produto> listaProduto = new ArrayList<Produto>();
		List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
		CarrinhoFactory cf = new CarrinhoFactory();
		ProdutoFactory pf = new ProdutoFactory();
		ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();
		Double qtdValor = 0D;
		Double valorUnitario = 0D;
		Frete frete = new Frete();

		try {
			listaCarrinho = cf.listarCarrinhosAtivos(this.entityManager);
			if (listaCarrinho.size() > 0) {
				carrinho = listaCarrinho.get(0);
			} else {
				CarrinhoTestNG carrinhoTeste = new CarrinhoTestNG();
				carrinhoTeste.criacao();
				listaCarrinho = cf.listarCarrinhosAtivos(this.entityManager);
				carrinho = listaCarrinho.get(0);
			}

			listaProduto = pf.listarProdutosAtivos(entityManager);
			if (listaProduto.size() > 0) {
				produto = listaProduto.get(0);
			} else {
				ProdutoTestNG teste = new ProdutoTestNG();
				teste.criacao();
				listaProduto = pf.listarProdutosAtivos(this.entityManager);
				produto = listaProduto.get(0);
			}

			produtoCarrinho.setCarrinho(carrinho);
			produtoCarrinho.setProduto(produto);
			produtoCarrinho.setQuantidade(2);
			qtdValor = pcf.getValorTotalComQuantidade(2, produto.getValor());
			produtoCarrinho.setValorTotal(qtdValor);
			valorUnitario = pcf.getValorUnitarioDoProdutoNoCarrinho(produto);
			produtoCarrinho.setValorUnitario(valorUnitario);

			genericDAOFactory.create(produtoCarrinho, this.entityManager);

			pcf.adicionarItemAoCarrinho(produto.getIdProduto(),
					this.entityManager, carrinho, 2, frete);

			Assert.assertNotNull(produtoCarrinho.getIdProdutoCarrinho());
			Assert.assertNotEquals(produtoCarrinho.getIdProdutoCarrinho(), 0L);

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
