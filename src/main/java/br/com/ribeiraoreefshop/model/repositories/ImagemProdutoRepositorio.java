/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.ImagemProduto;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Repository
public interface ImagemProdutoRepositorio extends
		CrudRepository<ImagemProduto, Long> {

}
