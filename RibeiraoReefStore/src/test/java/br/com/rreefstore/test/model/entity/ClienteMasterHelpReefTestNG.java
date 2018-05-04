/**
 * 
 */
package br.com.rreefstore.test.model.entity;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rreefstore.model.entity.ClienteMasterHelpReef;
import br.com.rreefstore.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class ClienteMasterHelpReefTestNG extends
		ATestDAO<ClienteMasterHelpReef> {

	private ClienteMasterHelpReef clienteMaster;

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

		try {
			clienteMaster = new ClienteMasterHelpReef();

			clienteMaster.setCodigoMasterHelpReef(123L);
			clienteMaster.setCpf("32055774859");
			clienteMaster.setDataCriacao(Calendar.getInstance());
			clienteMaster.setNomeCompleto("Tiago Ferezin");
			genericDAOFactory.create(clienteMaster, this.entityManager);

			Assert.assertNotNull(clienteMaster.getIdClienteMasterHelpReef());
			Assert.assertNotEquals(clienteMaster.getIdClienteMasterHelpReef(),
					0L);
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
