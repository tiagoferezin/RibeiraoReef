/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Tiago Ferezin Data: 13/08/2018
 */
@Entity
public class EnderecoMunicipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnderecoMunicipio;

	@OneToOne
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;

	@OneToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio municipio;

	public EnderecoMunicipio() {

	}

	/**
	 * @return the idEnderecoMunicipio
	 */
	public Long getIdEnderecoMunicipio() {
		return idEnderecoMunicipio;
	}

	/**
	 * @param idEnderecoMunicipio
	 *            the idEnderecoMunicipio to set
	 */
	public void setIdEnderecoMunicipio(Long idEnderecoMunicipio) {
		this.idEnderecoMunicipio = idEnderecoMunicipio;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio
	 *            the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

}
