/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ribeiraoreefshop.model.entity.Pessoa;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.repositories.PessoaRepositorio;
import br.com.ribeiraoreefshop.model.repositories.UsuarioPessoaRepositorio;

/**
 * @author Tiago Ferezin
 * Data: 17/08/2018
 */
public class UsuarioPessoaFactory {
	
	@Autowired UsuarioPessoaRepositorio usuarioPessoaRepositorio;
	@Autowired PessoaRepositorio pessoaRepositorio;
	
	public Pessoa pessoaDoUsuario(Usuario usuario){
		Long idUsuario = 0L;
		idUsuario=usuario.getIdUsuario();
		
		Pessoa pessoa = new Pessoa();
		
		Long idPessoa = 0L;
		//idPessoa = usuarioPessoaRepositorio.pessoaDoUsuario(idUsuario);
		
		pessoa = pessoaRepositorio.findOne(idPessoa);
		
		return pessoa;
	}

}
