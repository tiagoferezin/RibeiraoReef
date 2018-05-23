/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Endereco;
import br.com.ribeiraoreefshop.model.entity.Pessoa;
import br.com.ribeiraoreefshop.model.entity.PessoaEndereco;
import br.com.ribeiraoreefshop.utils.NameValuePair;

/**
 * @author Tiago Ferezin
 *
 */
public class PessoaEnderecoFactory {

	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public List<Endereco> listarEnderecoDaPessoa(Pessoa pessoa,
			EntityManager entityManager) {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		List<AEntity> listaPessoaEndereco = new ArrayList<AEntity>();

		String where = "(t.pessoa = :pessoa)";
		List<NameValuePair> whereParameters = new ArrayList<NameValuePair>();
		whereParameters.add(new NameValuePair("pessoa", pessoa));
		PessoaEndereco pessoaEndereco = new PessoaEndereco();
		try {
			listaPessoaEndereco = daoFactory.read(pessoaEndereco,
					entityManager, where, whereParameters);

			for (AEntity aEntity : listaPessoaEndereco) {

				pessoaEndereco = (PessoaEndereco) aEntity;
				Endereco endereco = new Endereco();
				endereco = pessoaEndereco.getEndereco();
				listaEndereco.add(endereco);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEndereco;

	}

}
