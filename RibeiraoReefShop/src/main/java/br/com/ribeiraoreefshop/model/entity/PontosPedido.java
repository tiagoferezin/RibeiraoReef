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
public class PontosPedido extends AEntity<PontosPedido> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPontosPedido;

	@OneToOne
	@JoinColumn(name = "idPontos", nullable = false)
	private Pontos pontos;

	@OneToOne
	@JoinColumn(name = "idPedido", nullable = false)
	private Pedido pedido;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public PontosPedido() {

	}

	/**
	 * @return the idPontosPedido
	 */
	public Long getIdPontosPedido() {
		return idPontosPedido;
	}

	/**
	 * @param idPontosPedido
	 *            the idPontosPedido to set
	 */
	public void setIdPontosPedido(Long idPontosPedido) {
		this.idPontosPedido = idPontosPedido;
	}

	/**
	 * @return the pontos
	 */
	public Pontos getPontos() {
		return pontos;
	}

	/**
	 * @param pontos
	 *            the pontos to set
	 */
	public void setPontos(Pontos pontos) {
		this.pontos = pontos;
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
		return idPontosPedido;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPontosPedido = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}
}
