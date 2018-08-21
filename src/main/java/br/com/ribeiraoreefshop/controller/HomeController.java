/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.repositories.ProdutoRepositorio;

/**
 * @author Tiago Ferezin
 * Data: 17/08/2018
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired ProdutoRepositorio produtoRepositorio;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model){
		
		Iterable<Produto> listaProdutos = produtoRepositorio.findAll();
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		listaProduto = (List<Produto>) listaProdutos;
		
		model.addAttribute("listaProduto", listaProduto);
		
		return "home/home";
	}
	
}
