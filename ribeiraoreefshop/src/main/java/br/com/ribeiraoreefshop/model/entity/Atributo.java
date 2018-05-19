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
public class Atributo extends AEntity<Atributo> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtributo;

	@Column(nullable = false)
	private String nomeAtributo;

	private String url;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Atributo() {

	}

	/**
	 * @return the idAtributo
	 */
	public Long getIdAtributo() {
		return idAtributo;
	}

	/**
	 * @param idAtributo
	 *            the idAtributo to set
	 */
	public void setIdAtributo(Long idAtributo) {
		this.idAtributo = idAtributo;
	}

	/**
	 * @return the nomeAtributo
	 */
	public String getNomeAtributo() {
		return nomeAtributo;
	}

	/**
	 * @param nomeAtributo
	 *            the nomeAtributo to set
	 */
	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
		return idAtributo;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idAtributo = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
