/**
 * 
 */
package br.com.rreefstore.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.rreefstore.model.entity.AEntity;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class ClienteMasterHelpReef extends AEntity<ClienteMasterHelpReef> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idClienteMasterHelpReef;

	@Column(nullable = false)
	private Long codigoMasterHelpReef;

	@Column(nullable = false)
	private String cpf;

	private String rg;

	@Column(nullable = false)
	private String nomeCompleto;

	@Column(nullable = false)
	private Calendar dataCriacao;

	private Calendar dataDesativacao;

	public ClienteMasterHelpReef() {

	}

	/**
	 * @return the idClienteMasterHelpReef
	 */
	public Long getIdClienteMasterHelpReef() {
		return idClienteMasterHelpReef;
	}

	/**
	 * @param idClienteMasterHelpReef
	 *            the idClienteMasterHelpReef to set
	 */
	public void setIdClienteMasterHelpReef(Long idClienteMasterHelpReef) {
		this.idClienteMasterHelpReef = idClienteMasterHelpReef;
	}

	/**
	 * @return the codigoMasterHelpReef
	 */
	public Long getCodigoMasterHelpReef() {
		return codigoMasterHelpReef;
	}

	/**
	 * @param codigoMasterHelpReef
	 *            the codigoMasterHelpReef to set
	 */
	public void setCodigoMasterHelpReef(Long codigoMasterHelpReef) {
		this.codigoMasterHelpReef = codigoMasterHelpReef;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg
	 *            the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto
	 *            the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idClienteMasterHelpReef;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idClienteMasterHelpReef = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calendar getDataDesativacao() {
		// TODO Auto-generated method stub
		return dataDesativacao;
	}

	@Override
	public void setDataDesativacao(Calendar dataDesativacao) {
		// TODO Auto-generated method stub
		this.dataDesativacao = dataDesativacao;
	}

}
