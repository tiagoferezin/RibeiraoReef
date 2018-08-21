/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ribeiraoreefshop.model.entity.factory.ImagemFactory;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Controller
@RequestMapping("/imagem")
public class ImagemController {

	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message",
					"Please select a file to upload");
			return "redirect:uploadStatus";
		}

	
		ImagemFactory imagemFactory = new ImagemFactory();
		
		try {
			imagemFactory.salvarImagem(file, context, "produto");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:produto";

	}

}
