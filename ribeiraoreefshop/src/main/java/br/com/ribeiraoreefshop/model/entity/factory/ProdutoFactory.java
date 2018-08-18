/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 * Data: 18/08/2018
 */
public class ProdutoFactory {
	
	public String gerarUrlSlug(Produto produto){
		
		String retorno = "";
		
		String nome = "";
		
		nome = produto.getNomeProduto();
		nome = nome.toLowerCase();
		nome = Normalizacao.removerAcentos(nome);
		nome = nome.trim();
		retorno = nome.replaceAll(" ", "-");
		
		return retorno;
		
	}

}
