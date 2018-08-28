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
 * @author Tiago Ferezin Data: 27/08/2018
 */
@Entity
public class ProdutoCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutoCarrinho;

	@OneToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;

	@OneToOne
	@JoinColumn(name = "idCarrinho")
	private Carrinho carrinho;

	private Integer quantidade;

	private Double total;

	public ProdutoCarrinho() {

	}

	/**
	 * @return the idProdutoCarrinho
	 */
	public Long getIdProdutoCarrinho() {
		return idProdutoCarrinho;
	}

	/**
	 * @param idProdutoCarrinho
	 *            the idProdutoCarrinho to set
	 */
	public void setIdProdutoCarrinho(Long idProdutoCarrinho) {
		this.idProdutoCarrinho = idProdutoCarrinho;
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

	/**
	 * @return the carrinho
	 */
	public Carrinho getCarrinho() {
		return carrinho;
	}

	/**
	 * @param carrinho
	 *            the carrinho to set
	 */
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

}
