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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Pontos extends AEntity<Pontos> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPontos;

	@Column(nullable = false)
	private Integer pontos;

	@Column(nullable = false)
	private Double valor;

	@Column(nullable = false)
	private Integer pontosResgate;

	@Column(nullable = false)
	private Double valorResgate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Pontos() {

	}

	/**
	 * @return the pontosResgate
	 */
	public Integer getPontosResgate() {
		return pontosResgate;
	}

	/**
	 * @param pontosResgate
	 *            the pontosResgate to set
	 */
	public void setPontosResgate(Integer pontosResgate) {
		this.pontosResgate = pontosResgate;
	}

	/**
	 * @return the valorResgate
	 */
	public Double getValorResgate() {
		return valorResgate;
	}

	/**
	 * @param valorResgate
	 *            the valorResgate to set
	 */
	public void setValorResgate(Double valorResgate) {
		this.valorResgate = valorResgate;
	}

	/**
	 * @return the idPontos
	 */
	public Long getIdPontos() {
		return idPontos;
	}

	/**
	 * @param idPontos
	 *            the idPontos to set
	 */
	public void setIdPontos(Long idPontos) {
		this.idPontos = idPontos;
	}

	/**
	 * @return the pontos
	 */
	public Integer getPontos() {
		return pontos;
	}

	/**
	 * @param pontos
	 *            the pontos to set
	 */
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
		return idPontos;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPontos = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
