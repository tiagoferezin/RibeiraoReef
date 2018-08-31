/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Categoria;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCategoria;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Repository
public interface ProdutoCategoriaRepositorio extends
		CrudRepository<ProdutoCategoria, Long> {

	@Query("SELECT categoria FROM ProdutoCategoria t WHERE t.produto = ?")
	public List<Categoria> categoriasDoProduto(Produto produto);

	@Query("SELECT produto FROM ProdutoCategoria t WHERE t.categoria = ?")
	public List<Produto> produtosDaCategoria(Categoria categoria);

}
