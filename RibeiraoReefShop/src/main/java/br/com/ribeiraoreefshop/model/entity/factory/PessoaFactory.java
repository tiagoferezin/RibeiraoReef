/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Pessoa;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class PessoaFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public String getNomeCompleto(Pessoa pessoa) {
		String result = "";

		List<String> listaNomeCompleto = new ArrayList<String>();
		listaNomeCompleto.add(pessoa.getPrimeiroNome());
		listaNomeCompleto.add(pessoa.getNomeDoMeio());
		listaNomeCompleto.add(pessoa.getSobrenome());

		String nomeCompleto = "";

		for (String nomeDaLista : listaNomeCompleto) {

			if (nomeDaLista != null) {
				nomeCompleto = nomeCompleto + " " + nomeDaLista;
			}
		}

		nomeCompleto = Normalizacao.capitalizarTexto(nomeCompleto);
		nomeCompleto = nomeCompleto.trim();
		result = nomeCompleto;

		return result;
	}

}
