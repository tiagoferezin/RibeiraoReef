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
 * @author Tiago Ferezin Data: 13/08/2018
 */
@Entity
public class Carteira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarteira;

	@Column(nullable = false)
	private Double saldo;

	public Carteira() {

	}

	/**
	 * @return the idCarteira
	 */
	public Long getIdCarteira() {
		return idCarteira;
	}

	/**
	 * @param idCarteira
	 *            the idCarteira to set
	 */
	public void setIdCarteira(Long idCarteira) {
		this.idCarteira = idCarteira;
	}

	/**
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo
	 *            the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
