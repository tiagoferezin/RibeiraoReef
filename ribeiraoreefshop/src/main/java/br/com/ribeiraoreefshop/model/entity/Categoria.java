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
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;

	@Column(nullable = false)
	private String slugUrl;
	@Column(nullable = false)
	private String nomeCategoria;

	public Categoria() {

	}

	/**
	 * @return the idCategoria
	 */
	public Long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria
	 *            the idCategoria to set
	 */
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the slugUrl
	 */
	public String getSlugUrl() {
		return slugUrl;
	}

	/**
	 * @param slugUrl
	 *            the slugUrl to set
	 */
	public void setSlugUrl(String slugUrl) {
		this.slugUrl = slugUrl;
	}

	/**
	 * @return the nomeCategoria
	 */
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	/**
	 * @param nomeCategoria
	 *            the nomeCategoria to set
	 */
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}
