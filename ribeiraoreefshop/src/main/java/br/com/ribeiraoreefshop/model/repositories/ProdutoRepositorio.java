/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Produto;

/**
 * @author Tiago Ferezin Data: 18/08/2018
 */
@Repository
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
	
	@Query("SELECT t FROM Produto t WHERE t.urlSlug = ?")
	public Produto produtoPeloSlug(String urlSlug);

}
