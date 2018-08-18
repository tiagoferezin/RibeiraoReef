/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ribeiraoreefshop.model.entity.Pessoa;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.UsuarioPessoa;
import br.com.ribeiraoreefshop.model.repositories.PessoaRepositorio;
import br.com.ribeiraoreefshop.model.repositories.UsuarioPessoaRepositorio;
import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin Data: 16/08/2018
 */
@Controller
@RequestMapping("/minhaConta")
public class MinhaContaController {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	PessoaRepositorio pessoaRepositorio;
	@Autowired
	UsuarioPessoaRepositorio usuarioPessoaRepositorio;

	@RequestMapping(method = RequestMethod.GET, value = "{idUsuario}")
	public String minhaConta(@PathVariable Long idUsuario, Model model) {

		Usuario usuario = new Usuario();

		UsuarioPessoa usuarioPessoa = new UsuarioPessoa();

		Pessoa pessoa = new Pessoa();

		pessoa = pessoaRepositorio.findOne(idUsuario);
		usuario = usuarioRepositorio.findOne(idUsuario);

		model.addAttribute("usuario", usuario);
		model.addAttribute("pessoa", pessoa);

		return "minhaConta/paginaMinhaConta";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPessoa(@Valid @ModelAttribute Pessoa pessoa, Model model) {

		Usuario usuario = new Usuario();

		model.containsAttribute("usuario");
		Map<String, Object> mapModel = model.asMap();

		Object o = mapModel.get("usuario");
		//Usuario usuario = usuarioRepositorio.findOne(idUsuario);

		Pessoa p = new Pessoa();
		//p = usuarioPessoaRepositorio.pessoaDoUsuario(usuario);

		if (p.getIdPessoa() == pessoa.getIdPessoa()) {

		}

		pessoaRepositorio.save(pessoa);

		return null;
	}

}
