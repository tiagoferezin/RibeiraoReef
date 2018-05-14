/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Frete extends AEntity<Frete> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFrete;

	@Column(nullable = false)
	private Double valorFrete;

	@Column(nullable = false)
	private String cep;

	@Enumerated(EnumType.STRING)
	private ETipoFrete tipoFrete;

	@Column(nullable = false)
	private Double peso;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Frete() {

	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
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

	/**
	 * @return the idFrete
	 */
	public Long getIdFrete() {
		return idFrete;
	}

	/**
	 * @param idFrete
	 *            the idFrete to set
	 */
	public void setIdFrete(Long idFrete) {
		this.idFrete = idFrete;
	}

	/**
	 * @return the valorFrete
	 */
	public Double getValorFrete() {
		return valorFrete;
	}

	/**
	 * @param valorFrete
	 *            the valorFrete to set
	 */
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the tipoFrete
	 */
	public ETipoFrete getTipoFrete() {
		return tipoFrete;
	}

	/**
	 * @param tipoFrete
	 *            the tipoFrete to set
	 */
	public void setTipoFrete(ETipoFrete tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idFrete;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idFrete = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
