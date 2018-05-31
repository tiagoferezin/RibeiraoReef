/**
 * 
 */
package br.com.ribeiraoreefshop.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
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

	public static String normalizarData(Calendar data) {
		String retorno = "";

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		retorno = df.format(data.getTime());

		return retorno;
	}

	public static String formatandoCasasDecimais(Double numero) {
		String result = "";

		result = String.format("%.2f", numero);
		// resultado = resultado.replaceAll( "," , "." );

		return result;
	}

	public static Double converterStringValorToDouble(String valor) {
		Double result = 0D;

		valor = valor.replaceAll(",", ".");

		result = Double.parseDouble(valor);

		return result;
	}
	
	
	/**
	 *  1 - Valor a arredondar.
	 *  2 - Quantidade de casas depois da vírgula.
	 *  3 - Arredondar para cima ou para baixo?
	 *          Para cima = 0 (ceil)
	 *          Para baixo = 1 ou qualquer outro inteiro (floor)
	 **/
	public static Double arredondar(double valor, int casas, int cimaOuBaixo) {
	    double arredondado = valor;
	    arredondado *= (Math.pow(10, casas));
	    if (cimaOuBaixo == 0) {
	        arredondado = Math.ceil(arredondado);           
	    } else {
	        arredondado = Math.floor(arredondado);
	    }
	    arredondado /= (Math.pow(10, casas));
	    return arredondado;
	}
	
	public static Long retornaNumerosDaString(String palavra){
		Long result = 0L;
		
		String c = palavra.replaceAll("[^0-9]", "");
		
		result = Long.parseLong(c);
		
		return result;
	}

}
