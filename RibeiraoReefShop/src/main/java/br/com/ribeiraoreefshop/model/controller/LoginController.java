/**
 * 
 */
package br.com.ribeiraoreefshop.model.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.ribeiraoreefshop.anotacao.AcessoPublico;

/**
 * @author Tiago Ferezin
 *
 */
@Controller
@Path("/login")
public class LoginController {

	@Inject
	private Result result;
	@Inject
	private Validator validator;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LoginController() {
		this(null);
	}

	@Inject
	public LoginController(Result result) {
		// TODO Auto-generated constructor stub
		this.result = result;
	}

	@AcessoPublico
	@Get("/login")
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("# Olá Vraptor Controller!");

	}

	@Path("/index")
	@AcessoPublico
	public void index() {

	}
}
