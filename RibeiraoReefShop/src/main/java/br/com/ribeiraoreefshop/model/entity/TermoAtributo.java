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
public class TermoAtributo extends AEntity<TermoAtributo> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTermoAtributo;

	@OneToOne
	@JoinColumn(name = "idAtributo", nullable = false)
	private Atributo atributo;

	@OneToOne
	@JoinColumn(name = "idTermo", nullable = false)
	private Termo termo;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public TermoAtributo() {

	}

	/**
	 * @return the idTermoAtributo
	 */
	public Long getIdTermoAtributo() {
		return idTermoAtributo;
	}

	/**
	 * @param idTermoAtributo
	 *            the idTermoAtributo to set
	 */
	public void setIdTermoAtributo(Long idTermoAtributo) {
		this.idTermoAtributo = idTermoAtributo;
	}

	/**
	 * @return the atributo
	 */
	public Atributo getAtributo() {
		return atributo;
	}

	/**
	 * @param atributo
	 *            the atributo to set
	 */
	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	/**
	 * @return the termo
	 */
	public Termo getTermo() {
		return termo;
	}

	/**
	 * @param termo
	 *            the termo to set
	 */
	public void setTermo(Termo termo) {
		this.termo = termo;
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
		return idTermoAtributo;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idTermoAtributo = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
