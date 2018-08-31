/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Entity
public class InfoAdicional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfoAdicional;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String slug;

	@Column(nullable = false)
	private String termo;

	public InfoAdicional() {

	}

	/**
	 * @return the idInfoAdicional
	 */
	public Long getIdInfoAdicional() {
		return idInfoAdicional;
	}

	/**
	 * @param idInfoAdicional
	 *            the idInfoAdicional to set
	 */
	public void setIdInfoAdicional(Long idInfoAdicional) {
		this.idInfoAdicional = idInfoAdicional;
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
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug
	 *            the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * @return the termo
	 */
	public String getTermo() {
		return termo;
	}

	/**
	 * @param termo
	 *            the termo to set
	 */
	public void setTermo(String termo) {
		this.termo = termo;
	}

}
