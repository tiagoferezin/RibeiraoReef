/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import br.com.ribeiraoreefshop.model.entity.Imagem;
import br.com.ribeiraoreefshop.model.repositories.ImagemRepositorio;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
public class ImagemFactory {

	public void salvarImagem(MultipartFile item, HttpServletRequest context,
			String nomePasta, Integer principal,
			ImagemRepositorio imagemRepositorio) throws IOException {

		String path = context.getRealPath("/resources/uploads");
		Imagem imagem = new Imagem();
		final String PATH_ARQUIVOS = path;
		final String DIR_ATUAL = nomePasta;
		final String PATH_ABSOLUTO = (PATH_ARQUIVOS + "/" + DIR_ATUAL);

		File diretorio = new File(PATH_ABSOLUTO);

		if (!diretorio.exists()) {
			diretorio.mkdir();
		}

		String nomeArquivo = "";

		nomeArquivo = item.getOriginalFilename();

		String[] arq = nomeArquivo.split("\\\\");

		for (int i = 0; i < arq.length; i++) {
			nomeArquivo = arq[i];
		}

		File file = new File(diretorio, nomeArquivo);
		FileOutputStream out = new FileOutputStream(file);
		InputStream in = item.getInputStream();

		byte[] buffer = new byte[1024 * 6];
		int nLidos = 0;

		while ((nLidos = in.read(buffer)) >= 0) {
			out.write(buffer, 0, nLidos);
		}

		out.flush();
		out.close();

		String diretorioSalvo = "";

		String nomeImagem = "";
		nomeImagem = item.getOriginalFilename();

		diretorioSalvo = "/" + DIR_ATUAL + "/" + nomeImagem;

		imagem.setCaminhoImagem(diretorioSalvo);
		imagem.setNomeImagem(nomeImagem);
		imagem.setPrincipal(principal);
		try {
			imagemRepositorio.save(imagem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
