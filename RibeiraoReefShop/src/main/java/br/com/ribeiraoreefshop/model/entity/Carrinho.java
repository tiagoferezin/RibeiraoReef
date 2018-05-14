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
public class Carrinho extends AEntity<Carrinho> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinho;

	@Column(nullable = false)
	private Double total;

	@OneToOne
	@JoinColumn(name = "idFrete")
	private Frete frete;

	@Column(nullable = false)
	private Double larguraTotal;

	@Column(nullable = false)
	private Double alturaTotal;

	@Column(nullable = false)
	private Double comprimentoTotal;

	@Column(nullable = false)
	private Double diametroTotal;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Carrinho() {

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
	 * @return the larguraTotal
	 */
	public Double getLarguraTotal() {
		return larguraTotal;
	}

	/**
	 * @param larguraTotal
	 *            the larguraTotal to set
	 */
	public void setLarguraTotal(Double larguraTotal) {
		this.larguraTotal = larguraTotal;
	}

	/**
	 * @return the alturaTotal
	 */
	public Double getAlturaTotal() {
		return alturaTotal;
	}

	/**
	 * @param alturaTotal
	 *            the alturaTotal to set
	 */
	public void setAlturaTotal(Double alturaTotal) {
		this.alturaTotal = alturaTotal;
	}

	/**
	 * @return the comprimentoTotal
	 */
	public Double getComprimentoTotal() {
		return comprimentoTotal;
	}

	/**
	 * @param comprimentoTotal
	 *            the comprimentoTotal to set
	 */
	public void setComprimentoTotal(Double comprimentoTotal) {
		this.comprimentoTotal = comprimentoTotal;
	}

	/**
	 * @return the diametroTotal
	 */
	public Double getDiametroTotal() {
		return diametroTotal;
	}

	/**
	 * @param diametroTotal
	 *            the diametroTotal to set
	 */
	public void setDiametroTotal(Double diametroTotal) {
		this.diametroTotal = diametroTotal;
	}

	/**
	 * @return the idCarrinho
	 */
	public Long getIdCarrinho() {
		return idCarrinho;
	}

	/**
	 * @param idCarrinho
	 *            the idCarrinho to set
	 */
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
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
		return idCarrinho;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idCarrinho = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
