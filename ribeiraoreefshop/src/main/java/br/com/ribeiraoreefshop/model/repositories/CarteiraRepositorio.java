/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import br.com.ribeiraoreefshop.model.entity.Carteira;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Ferezin
 * Data: 14/08/2018
 */
@Repository
public interface CarteiraRepositorio extends CrudRepository<Carteira, Long> {

}
