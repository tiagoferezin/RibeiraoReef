/**
 * 
 */
package br.com.ribeiraoreefshop.model.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

/**
 * @author Tiago Ferezin
 *
 */
@Controller
@Path("/imagem")
public class ImagemController {
	
	@Inject
	private EntityManager entityManager;
	
	

}
