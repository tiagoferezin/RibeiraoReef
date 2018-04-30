/**
 * 
 */
package br.com.rreefstore.test.model.entity;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rreefstore.model.entity.Pessoa;
import br.com.rreefstore.test.dao.ATestDAO;
import br.com.rreefstore.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class PessoaTestNG extends ATestDAO<Pessoa> {

	private Pessoa pessoa;

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

		String nome = "Alberto dos sANtos";
		try {
			pessoa = new Pessoa();
			Calendar cal = Calendar.getInstance();
			pessoa.setDataCriacao(cal);
			pessoa.setIdade(30);
			nome = Normalizacao.capitalizarPalavra(nome);
			pessoa.setNomePessoa(nome);
			genericDAOFactory.create(pessoa, this.entityManager);

			Assert.assertNotNull(pessoa.getIdPessoa());
			Assert.assertNotEquals(pessoa.getIdPessoa(), 0L);

		} catch (Exception e) {
			// TODO: handle exception
			erro = e.getMessage();
			e.printStackTrace();
		}
		Assert.assertEquals(erro, "");
	}

	@Test(priority = 20)
	@Override
	public void consulta() {
		// TODO Auto-generated method stub
		String erro = "";

		try {

			Long id = pessoa.getIdPessoa();

			Pessoa consulta = (Pessoa) genericDAOFactory.readPorId(pessoa,
					this.entityManager, id);
			Calendar cal = consulta.getDataCriacao();
			String data = Normalizacao.normalizarData(cal);
			System.out.println("Dia: " + data);
			Assert.assertNotNull(consulta);

		} catch (Exception e) {
			// TODO: handle exception
			erro = e.getMessage();
			e.printStackTrace();
		}
		Assert.assertEquals(erro, "");

	}

	@Override
	public void atualizacao() {
		// TODO Auto-generated method stub

	}

	@Test(priority = 40)
	@Override
	public void delecao() {
		// TODO Auto-generated method stub
		String erro = "";

		try {
			genericDAOFactory.delete(pessoa, this.entityManager);
			Assert.assertNotNull(pessoa.getDataDesativacao());
		} catch (Exception e) {
			// TODO: handle exception
			erro = e.getMessage();
			e.printStackTrace();
		}
		Assert.assertEquals(erro, "");
	}

}
