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
 * @author Tiago Ferezin Data: 27/08/2018
 */
@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinho;

	private String emailUsuario;

	private Double total;

	private Double totalComFreteCalculado;
	
	private Double pesoTotal;
	private Double alturaTotal;
	private Double comprimentoTotal;
	private Double larguraTotal;

	public Carrinho() {

	}

	/**
	 * @return the pesoTotal
	 */
	public Double getPesoTotal() {
		return pesoTotal;
	}

	/**
	 * @param pesoTotal the pesoTotal to set
	 */
	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	/**
	 * @return the alturaTotal
	 */
	public Double getAlturaTotal() {
		return alturaTotal;
	}

	/**
	 * @param alturaTotal the alturaTotal to set
	 */
	public void setAlturaTotal(Double alturaTotal) {
		this.alturaTotal = alturaTotal;
	}

	/**
	 * @return the comprimentoTotal
	 */
	public Double getComprimentoTotal() {
		return comprimentoTotal;
	}

	/**
	 * @param comprimentoTotal the comprimentoTotal to set
	 */
	public void setComprimentoTotal(Double comprimentoTotal) {
		this.comprimentoTotal = comprimentoTotal;
	}

	/**
	 * @return the larguraTotal
	 */
	public Double getLarguraTotal() {
		return larguraTotal;
	}

	/**
	 * @param larguraTotal the larguraTotal to set
	 */
	public void setLarguraTotal(Double larguraTotal) {
		this.larguraTotal = larguraTotal;
	}

	/**
	 * @return the idCarrinho
	 */
	public Long getIdCarrinho() {
		return idCarrinho;
	}

	/**
	 * @param idCarrinho
	 *            the idCarrinho to set
	 */
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	/**
	 * @return the emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * @param emailUsuario
	 *            the emailUsuario to set
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the totalComFreteCalculado
	 */
	public Double getTotalComFreteCalculado() {
		return totalComFreteCalculado;
	}

	/**
	 * @param totalComFreteCalculado
	 *            the totalComFreteCalculado to set
	 */
	public void setTotalComFreteCalculado(Double totalComFreteCalculado) {
		this.totalComFreteCalculado = totalComFreteCalculado;
	}

}
