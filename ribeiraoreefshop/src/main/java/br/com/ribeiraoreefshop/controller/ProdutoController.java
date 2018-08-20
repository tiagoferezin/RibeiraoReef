/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ribeiraoreefshop.exceptions.ProdutoInvalidException;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.factory.ImagemFactory;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoFactory;
import br.com.ribeiraoreefshop.model.repositories.ProdutoRepositorio;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin Data: 18/08/2018
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	ServletContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String listaProdutos(Model model) {
		Iterable<Produto> listaProdutos = produtoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de Produtos");
		model.addAttribute("listaProdutos", listaProdutos);

		return "produto/listaProduto";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarProduto(@Valid @ModelAttribute Produto produto,
			BindingResult bindingResult, Model model, FileItem item) {

		ImagemFactory imagemFactory = new ImagemFactory();

		try {
			imagemFactory.salvarImagem(item, context, "produtos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProdutoFactory pf = new ProdutoFactory();

		Double total = 0D;

		total = produto.getValor();

		if (produto.getValor() == null) {
			produto.setValor(0D);
		}

		String slug = "";

		slug = produto.getUrlSlug();

		if ((slug == "") || (slug == null)) {

			slug = pf.gerarUrlSlug(produto);
			produto.setUrlSlug(slug);

		}

		Produto produtoPesquisa = new Produto();

		produtoPesquisa = produtoRepositorio.produtoPeloSlug(slug);

		Integer estoque = 0;

		estoque = produto.getEstoque();

		if ((estoque == 0) || (estoque == null)) {

			produto.setEstoque(0);

		}

		String valorString = "";

		valorString = Normalizacao.formatandoCasasDecimais(total);

		produto.setValorDemonstrado(valorString);

		if (bindingResult.hasErrors()) {

			throw new ProdutoInvalidException();

		} else {

			produtoRepositorio.save(produto);
		}

		Iterable<Produto> listaProdutos = produtoRepositorio.findAll();
		model.addAttribute("listaProdutos", listaProdutos);

		return "produto/tabelaProduto";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{idProduto}")
	@ResponseBody
	public Produto buscarProduto(@PathVariable Long idProduto) {
		Produto produto = new Produto();

		produto = produtoRepositorio.findOne(idProduto);

		return produto;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{idProduto}")
	public ResponseEntity<String> deletarProduto(@PathVariable Long idProduto) {

		try {
			produtoRepositorio.delete(idProduto);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
