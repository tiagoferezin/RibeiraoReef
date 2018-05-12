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
public class Termo extends AEntity<Termo> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTermo;

	@Column(nullable = false)
	private String nomeTermo;

	private String url;

	private String descricao;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Termo() {

	}

	/**
	 * @return the idTermo
	 */
	public Long getIdTermo() {
		return idTermo;
	}

	/**
	 * @param idTermo
	 *            the idTermo to set
	 */
	public void setIdTermo(Long idTermo) {
		this.idTermo = idTermo;
	}

	/**
	 * @return the nomeTermo
	 */
	public String getNomeTermo() {
		return nomeTermo;
	}

	/**
	 * @param nomeTermo
	 *            the nomeTermo to set
	 */
	public void setNomeTermo(String nomeTermo) {
		this.nomeTermo = nomeTermo;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return idTermo;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idTermo = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
