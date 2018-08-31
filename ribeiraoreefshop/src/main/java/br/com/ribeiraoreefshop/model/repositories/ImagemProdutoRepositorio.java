/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Imagem;
import br.com.ribeiraoreefshop.model.entity.ImagemProduto;
import br.com.ribeiraoreefshop.model.entity.Produto;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Repository
public interface ImagemProdutoRepositorio extends
		CrudRepository<ImagemProduto, Long> {

	@Query("SELECT imagem FROM ImagemProduto t WHERE t.produto = ?")
	public List<Imagem> imagensDoProduto(Produto produto);

}
