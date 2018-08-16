/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ribeiraoreefshop.model.enumerador.ETipoEndereco;

/**
 * @author Tiago Ferezin Data: 13/08/2018
 */
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String numero;

	private String complemento;

	private String bairro;

	private String anotacao;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ETipoEndereco tipoEndereco;

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
	 * @return the anotacao
	 */
	public String getAnotacao() {
		return anotacao;
	}

	/**
	 * @param anotacao
	 *            the anotacao to set
	 */
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
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

}
