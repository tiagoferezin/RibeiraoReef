/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Pessoa;

/**
 * @author Tiago Ferezin
 * Data: 14/08/2018
 */
@Repository
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long> {

}
