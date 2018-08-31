/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.InfoAdicional;
import br.com.ribeiraoreefshop.model.entity.InfoAdicionalProduto;
import br.com.ribeiraoreefshop.model.entity.Produto;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Repository
public interface InfoAdicionalProdutoRepositorio extends
		CrudRepository<InfoAdicionalProduto, Long> {

	@Query("SELECT infoAdicional FROM InfoAdicionalProduto t WHERE t.produto = ?")
	List<InfoAdicional> informacoesDoProduto(Produto produto);

}
