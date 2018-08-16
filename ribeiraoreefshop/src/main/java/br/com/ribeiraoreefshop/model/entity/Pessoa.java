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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.ribeiraoreefshop.model.enumerador.ETipoDocumento;
import br.com.ribeiraoreefshop.model.enumerador.ETipoPessoa;

/**
 * @author Tiago Ferezin Data: 13/08/2018
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "documento", name = "uk_documento") })
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	@Column(nullable = false)
	private String primeiroNome;

	private String nomeDoMeio;

	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false)
	private String nomeCompleto;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ETipoDocumento tipoDocumento;

	@Column(nullable = false)
	private String documento;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ETipoPessoa tipoPessoa;

	private Double pontosFidelidade;

	public Pessoa() {

	}

	/**
	 * @return the idPessoa
	 */
	public Long getIdPessoa() {
		return idPessoa;
	}

	/**
	 * @param idPessoa
	 *            the idPessoa to set
	 */
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * @return the primeiroNome
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * @param primeiroNome
	 *            the primeiroNome to set
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	/**
	 * @return the nomeDoMeio
	 */
	public String getNomeDoMeio() {
		return nomeDoMeio;
	}

	/**
	 * @param nomeDoMeio
	 *            the nomeDoMeio to set
	 */
	public void setNomeDoMeio(String nomeDoMeio) {
		this.nomeDoMeio = nomeDoMeio;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome
	 *            the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	 * @return the tipoDocumento
	 */
	public ETipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento
	 *            the tipoDocumento to set
	 */
	public void setTipoDocumento(ETipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the tipoPessoa
	 */
	public ETipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa
	 *            the tipoPessoa to set
	 */
	public void setTipoPessoa(ETipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	/**
	 * @return the pontosFidelidade
	 */
	public Double getPontosFidelidade() {
		return pontosFidelidade;
	}

	/**
	 * @param pontosFidelidade
	 *            the pontosFidelidade to set
	 */
	public void setPontosFidelidade(Double pontosFidelidade) {
		this.pontosFidelidade = pontosFidelidade;
	}

}
