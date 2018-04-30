/**
 * 
 */
package br.com.rreefstore.model.entity;

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

import br.com.rreefstore.model.enumerador.EEstado;
import br.com.rreefstore.model.enumerador.ETipoEndereco;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Endereco extends AEntity<Endereco> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idEndereco;

	@Enumerated(EnumType.STRING)
	private ETipoEndereco tipoEndereco;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private String complemento;

	@Column(nullable = false)
	private String municipio;

	@Column(nullable = false)
	private String bairro;

	@Enumerated(EnumType.STRING)
	private EEstado uf;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Endereco() {

	}

	/**
	 * @return the idEndereco
	 */
	public Long getIdEndereco() {
		return idEndereco;
	}

	/**
	 * @param idEndereco
	 *            the idEndereco to set
	 */
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	/**
	 * @return the tipoEndereco
	 */
	public ETipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * @param tipoEndereco
	 *            the tipoEndereco to set
	 */
	public void setTipoEndereco(ETipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro
	 *            the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento
	 *            the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio
	 *            the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the uf
	 */
	public EEstado getUf() {
		return uf;
	}

	/**
	 * @param uf
	 *            the uf to set
	 */
	public void setUf(EEstado uf) {
		this.uf = uf;
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
		return idEndereco;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idEndereco = id;
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
