/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "nomeImagem", name = "uk_nomeImagem") })
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImagem;

	@Column(nullable = false)
	private String nomeImagem;

	@Column(nullable = false)
	private String caminhoImagem;

	public Imagem() {

	}

	/**
	 * @return the idImagem
	 */
	public Long getIdImagem() {
		return idImagem;
	}

	/**
	 * @param idImagem
	 *            the idImagem to set
	 */
	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	/**
	 * @return the nomeImagem
	 */
	public String getNomeImagem() {
		return nomeImagem;
	}

	/**
	 * @param nomeImagem
	 *            the nomeImagem to set
	 */
	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	/**
	 * @return the caminhoImagem
	 */
	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	/**
	 * @param caminhoImagem
	 *            the caminhoImagem to set
	 */
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

}
