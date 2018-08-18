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
 * @author Tiago Ferezin Data: 18/08/2018
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "urlSlug", name = "uk_urlSlug") })
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@Column(nullable = false)
	private String nomeProduto;

	@Column(nullable = false)
	private String urlSlug;

	@Column(nullable = false)
	private Double valor;

	private String valorDemonstrado;

	private String breveDescricao;

	private String descricao;

	@Column(nullable = false)
	private Integer estoque;

	public Produto() {

	}

	/**
	 * @return the idProduto
	 */
	public Long getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto
	 *            the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	/**
	 * @param nomeProduto
	 *            the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	/**
	 * @return the urlSlug
	 */
	public String getUrlSlug() {
		return urlSlug;
	}

	/**
	 * @param urlSlug
	 *            the urlSlug to set
	 */
	public void setUrlSlug(String urlSlug) {
		this.urlSlug = urlSlug;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the breveDescricao
	 */
	public String getBreveDescricao() {
		return breveDescricao;
	}

	/**
	 * @param breveDescricao
	 *            the breveDescricao to set
	 */
	public void setBreveDescricao(String breveDescricao) {
		this.breveDescricao = breveDescricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the estoque
	 */
	public Integer getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque
	 *            the estoque to set
	 */
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the valorDemonstrado
	 */
	public String getValorDemonstrado() {
		return valorDemonstrado;
	}

	/**
	 * @param valorDemonstrado
	 *            the valorDemonstrado to set
	 */
	public void setValorDemonstrado(String valorDemonstrado) {
		this.valorDemonstrado = valorDemonstrado;
	}

}
