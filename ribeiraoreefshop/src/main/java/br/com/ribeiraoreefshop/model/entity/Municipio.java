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

import br.com.ribeiraoreefshop.model.enumerador.EPais;
import br.com.ribeiraoreefshop.model.enumerador.EUnidadeFederativa;

/**
 * @author Tiago Ferezin Data: 13/08/2018
 */
@Entity
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMunicipio;

	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EUnidadeFederativa uf;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EPais pais;

	public Municipio() {

	}

	/**
	 * @return the idMunicipio
	 */
	public Long getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio
	 *            the idMunicipio to set
	 */
	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the uf
	 */
	public EUnidadeFederativa getUf() {
		return uf;
	}

	/**
	 * @param uf
	 *            the uf to set
	 */
	public void setUf(EUnidadeFederativa uf) {
		this.uf = uf;
	}

	/**
	 * @return the pais
	 */
	public EPais getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(EPais pais) {
		this.pais = pais;
	}

}
