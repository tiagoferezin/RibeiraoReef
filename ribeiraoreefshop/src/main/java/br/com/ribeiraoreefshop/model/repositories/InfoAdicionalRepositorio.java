/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.InfoAdicional;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Repository
public interface InfoAdicionalRepositorio extends
		CrudRepository<InfoAdicional, Long> {

}
