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

	public Carrinho() {

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
