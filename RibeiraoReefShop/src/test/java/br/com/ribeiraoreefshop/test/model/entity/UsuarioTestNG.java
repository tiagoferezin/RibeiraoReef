/**
 * 
 */
package br.com.ribeiraoreefshop.test.model.entity;

import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.factory.UsuarioFactory;
import br.com.ribeiraoreefshop.test.dao.ATestDAO;

/**
 * @author Tiago Ferezin
 *
 */
public class UsuarioTestNG extends ATestDAO<Usuario> {

	Usuario usuario = new Usuario();
	String cpf = "320.557.748-59";
	String primeiroNome = "Tiago";
	String sobrenome = "Ferezin";
	String email = "tiagoferezin@gmail.com";
	String username = "tiagoferezin";
	String senha = "152535";
	String salt = "minha@casa";

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
		UsuarioFactory uf = new UsuarioFactory();

		try {
			usuario = new Usuario();
			usuario.setCarteira(0D);
			// usuario.setCpf(cpf);
			usuario.setEmail(email);
			// usuario.setPrimeiroNome(primeiroNome);
			// usuario.setSobrenome(sobrenome);
			// String nomeCompleto = uf.getNomeCompleto(usuario);
			// usuario.setNomeCompleto(nomeCompleto);

			usuario.setSalt(salt);
			String senhaCripto = uf.senhaCriptografada(salt, senha);
			usuario.setSenha(senhaCripto);
			usuario.setDataCriacao(Calendar.getInstance());
			if ((username == null) || (username == "")) {
				usuario.setUsername(uf.gerarUsername(usuario));
			} else {
				usuario.setUsername(username);
			}
			genericDAOFactory.create(usuario, this.entityManager);

			Assert.assertNotNull(usuario.getIdUsuario());
			Assert.assertNotEquals(usuario.getIdUsuario(), 0L);

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
