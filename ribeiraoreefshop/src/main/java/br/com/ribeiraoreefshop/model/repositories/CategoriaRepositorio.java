/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Categoria;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Repository
public interface CategoriaRepositorio extends CrudRepository<Categoria, Long> {

}
