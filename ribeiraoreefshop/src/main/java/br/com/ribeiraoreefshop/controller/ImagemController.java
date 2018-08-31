/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.factory.ImagemFactory;
import br.com.ribeiraoreefshop.model.repositories.ImagemProdutoRepositorio;
import br.com.ribeiraoreefshop.model.repositories.ImagemRepositorio;
import br.com.ribeiraoreefshop.model.repositories.ProdutoRepositorio;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Controller
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	ServletContext context;
	@Autowired
	ImagemRepositorio imagemRepositorio;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ProdutoRepositorio produtoRepositorio;
	@Autowired
	ImagemProdutoRepositorio imagemProdutoRepositorio;

	@RequestMapping(value = "/upload/{idProduto}", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes, @PathVariable Long idProduto) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message",
					"Please select a file to upload");
			return "redirect:uploadStatus";
		}

		ImagemFactory imagemFactory = new ImagemFactory();

		Produto produto = new Produto();
		produto = produtoRepositorio.findOne(idProduto);

		try {
			imagemFactory.salvarImagem(file, request, "produto", 0,
					imagemRepositorio, imagemProdutoRepositorio, produto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:../produto";

	}

}
