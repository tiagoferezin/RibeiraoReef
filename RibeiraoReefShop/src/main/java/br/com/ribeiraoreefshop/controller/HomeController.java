/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.ribeiraoreefshop.anotacao.AcessoPublico;

/**
 * @author Tiago Ferezin
 *
 */
@Controller
public class HomeController {

	@AcessoPublico
	@Path("/")
	public void home(){
		
	}
	
}
