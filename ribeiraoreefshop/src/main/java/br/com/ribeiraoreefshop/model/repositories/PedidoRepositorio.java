/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Pedido;

/**
 * @author Tiago Ferezin Data: 22/08/2018
 */
@Repository
public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {

}
