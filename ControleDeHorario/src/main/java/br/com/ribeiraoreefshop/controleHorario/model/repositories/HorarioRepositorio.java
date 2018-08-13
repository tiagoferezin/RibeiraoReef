/**
 * 
 */
package br.com.ribeiraoreefshop.controleHorario.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ribeiraoreefshop.controleHorario.model.entity.Horario;

/**
 * @author Tiago Ferezin Data: 09/08/2018
 */
public interface HorarioRepositorio extends CrudRepository<Horario, Long> {

	@Query("SELECT t FROM ProdutoOrcamento t WHERE t.mes = ?")
	public List<Horario> listarHorarios(Integer mes);
	
}
