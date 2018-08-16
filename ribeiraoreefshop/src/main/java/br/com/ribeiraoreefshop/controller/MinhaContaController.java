/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin
 * Data: 16/08/2018
 */
@Controller
@RequestMapping("/minhaConta")
public class MinhaContaController {
	
	@Autowired UsuarioRepositorio usuarioRepositorio;
	
	@RequestMapping(method = RequestMethod.GET, value = "{idUsuario}")
	public String minhaConta(@PathVariable Long idUsuario, Model model) {

		Usuario usuario = new Usuario();

		usuario = usuarioRepositorio.findOne(idUsuario);

		model.addAttribute("usuario", usuario);

		return "minhaConta/paginaMinhaConta";

	}

}
