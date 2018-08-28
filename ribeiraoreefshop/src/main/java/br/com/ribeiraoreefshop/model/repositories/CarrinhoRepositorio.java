/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Carrinho;

/**
 * @author Tiago Ferezin
 * Data: 27/08/2018
 */
@Repository
public interface CarrinhoRepositorio extends CrudRepository<Carrinho, Long> {
	
	@Query("SELECT t FROM Carrinho t WHERE t.emailUsuario = ?")
	public Carrinho carrinhoDoUsuario(String emailUsuario);

}
