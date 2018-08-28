/**
 * 
 */
package br.com.ribeiraoreefshop.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;

/**
 * @author Tiago Ferezin Data: 27/08/2018
 */
@Repository
public interface ProdutoCarrinhoRepositorio extends
		CrudRepository<ProdutoCarrinho, Long> {
	
	@Query("SELECT produto FROM ProdutoCarrinho t WHERE t.carrinho = ?")
	public List<Produto> produtosCarrinho(Carrinho carrinho);

}
