/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class ProdutoPedido extends AEntity<ProdutoPedido> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutoPedido;

	@OneToOne
	@JoinColumn(name = "idProduto", nullable = false)
	private Produto produto;

	@OneToOne
	@JoinColumn(name = "idPedido", nullable = false)
	private Pedido pedido;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public ProdutoPedido() {

	}

	/**
	 * @return the idProdutoPedido
	 */
	public Long getIdProdutoPedido() {
		return idProdutoPedido;
	}

	/**
	 * @param idProdutoPedido
	 *            the idProdutoPedido to set
	 */
	public void setIdProdutoPedido(Long idProdutoPedido) {
		this.idProdutoPedido = idProdutoPedido;
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
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the dataCriacao
	 */
	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the dataDesativacao
	 */
	public Calendar getDataDesativacao() {
		return dataDesativacao;
	}

	/**
	 * @param dataDesativacao
	 *            the dataDesativacao to set
	 */
	public void setDataDesativacao(Calendar dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idProdutoPedido;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idProdutoPedido = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
