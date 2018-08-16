/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Endereco;
import br.com.ribeiraoreefshop.model.entity.EnderecoMunicipio;

/**
 * @author Tiago Ferezin Data: 14/08/2018
 */
@Repository
public interface EnderecoMunicipioRepositorio extends
		CrudRepository<EnderecoMunicipio, Long> {

	@Query("SELECT t FROM EnderecoMunicipio t WHERE t.municipio = ?")
	public List<Endereco> listarEnderecosDoMunicipio(Long idMunicipio);

}
