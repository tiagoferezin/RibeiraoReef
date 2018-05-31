/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

/**
 * @author Tiago Ferezin
 *
 */
@Controller
@Path("/imagem")
public class ImagemController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;
	
	@Get("/home")
    public void home() {
        result.include("message", "Hello, VRaptor 4!");
    }

}
