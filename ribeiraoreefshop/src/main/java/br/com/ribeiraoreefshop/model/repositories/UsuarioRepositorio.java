/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Usuario;

/**
 * @author Tiago Ferezin
 * Data: 14/08/2018
 */
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT t FROM Usuario t WHERE t.username = ?")
	public Usuario pegarUsuarioPeloUsername(String username);

	@Query("SELECT t1 FROM Usuario t1 WHERE t1.username = ?")
	public UserDetails findOneByLogin(String login);
	

}
