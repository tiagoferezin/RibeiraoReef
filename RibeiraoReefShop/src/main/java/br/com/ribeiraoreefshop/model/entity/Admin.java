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
public class Admin extends AEntity<Admin> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;

	@Column(nullable = false)
	private Integer config;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Admin() {

	}

	/**
	 * @return the idAdmin
	 */
	public Long getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin
	 *            the idAdmin to set
	 */
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * @return the config
	 */
	public Integer getConfig() {
		return config;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public void setConfig(Integer config) {
		this.config = config;
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
		return idAdmin;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idAdmin = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
