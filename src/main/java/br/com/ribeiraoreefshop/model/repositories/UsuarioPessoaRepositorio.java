/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Pessoa;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.UsuarioPessoa;

/**
 * @author Tiago Ferezin Data: 17/08/2018
 */
@Repository
public interface UsuarioPessoaRepositorio extends
		CrudRepository<UsuarioPessoa, Long> {

//	@Query("SELECT Pessoa FROM UsuarioPessoa t WHERE t.idUsuario = ?")
//	public Long pessoaDoUsuario(Long idUsuario);
//	
//	@Query("SELECT Usuario FROM UsuarioPessoa t1 WHERE t1.idPessoa = ?")
//	public Usuario usuarioDaPessoa(Long idPessoa);

}
