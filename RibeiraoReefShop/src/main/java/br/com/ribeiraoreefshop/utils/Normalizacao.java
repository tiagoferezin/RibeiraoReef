/**
 * 
 */
package br.com.ribeiraoreefshop.utils;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Tiago Ferezin
 *
 */
public class Normalizacao {

	public static String removerAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll(
				"[^\\p{ASCII}]", "");
	}

	public static String removerEspacos(String texto) {
		return texto.replaceAll(" ", "");
	}

	public static String getTextoPesquisa(String textoPesquisa) {
		String result = "";

		textoPesquisa = textoPesquisa.toUpperCase().trim();
		textoPesquisa = removerAcentos(textoPesquisa);
		textoPesquisa = removerEspacos(textoPesquisa);
		result = textoPesquisa.toUpperCase().trim();

		return result;
	}

	public static String capitalizarTexto(String texto) {

		int posicao = 1;

		while (posicao > 0) {
			texto = texto.replace("  ", " ");
			posicao = texto.indexOf("  ");
		}
		texto = texto.trim();

		String retorno = "";

		String[] palavras = texto.split(" ");

		for (int i = 0; i < palavras.length; i++) {
			palavras[i] = palavras[i].substring(0, 1).toUpperCase()
					+ palavras[i].substring(1, palavras[i].length())
							.toLowerCase();

			retorno = retorno + " " + palavras[i];

		}

		return retorno;

	}

	public static String capitalizarPalavra(String palavra) {
		String retorno = "";

		palavra = palavra.trim();

		if ((palavra.contains(" ")) || (palavra.contains("  "))) {
			retorno = capitalizarTexto(palavra);
		} else {
			retorno = palavra.substring(0, 1).toUpperCase()
					+ palavra.substring(1, palavra.length()).toLowerCase();
		}
		retorno = retorno.trim();

		return retorno;
	}
	
	public static String normalizarData(Calendar data){
		String retorno =  "";
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		retorno = df.format(data.getTime());
		
		return retorno;
	}

}
