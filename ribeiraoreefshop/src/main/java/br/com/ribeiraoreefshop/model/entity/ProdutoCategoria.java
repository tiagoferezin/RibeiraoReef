/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Entity
public class ProdutoCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutoCategoria;

	@OneToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;

	public ProdutoCategoria() {

	}

	/**
	 * @return the idProdutoCategoria
	 */
	public Long getIdProdutoCategoria() {
		return idProdutoCategoria;
	}

	/**
	 * @param idProdutoCategoria
	 *            the idProdutoCategoria to set
	 */
	public void setIdProdutoCategoria(Long idProdutoCategoria) {
		this.idProdutoCategoria = idProdutoCategoria;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
