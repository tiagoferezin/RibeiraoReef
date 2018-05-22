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
public class FreteCarrinho extends AEntity<FreteCarrinho> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFreteCarrinho;

	@OneToOne
	@JoinColumn(name = "idFrete")
	private Frete frete;

	@OneToOne
	@JoinColumn(name = "idCarrinho")
	private Carrinho carrinho;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public FreteCarrinho() {

	}

	/**
	 * @return the idFreteCarrinho
	 */
	public Long getIdFreteCarrinho() {
		return idFreteCarrinho;
	}

	/**
	 * @param idFreteCarrinho
	 *            the idFreteCarrinho to set
	 */
	public void setIdFreteCarrinho(Long idFreteCarrinho) {
		this.idFreteCarrinho = idFreteCarrinho;
	}

	/**
	 * @return the frete
	 */
	public Frete getFrete() {
		return frete;
	}

	/**
	 * @param frete
	 *            the frete to set
	 */
	public void setFrete(Frete frete) {
		this.frete = frete;
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
		return idFreteCarrinho;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idFreteCarrinho = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
