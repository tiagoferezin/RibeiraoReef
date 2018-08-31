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
 * @author Tiago Ferezin Data: 29/08/2018
 */
@Entity
public class InfoAdicionalProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfoAdicionalProduto;

	@OneToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;

	@OneToOne
	@JoinColumn(name = "idInfoAdicional")
	private InfoAdicional infoAdicional;

	public InfoAdicionalProduto() {

	}

	/**
	 * @return the idInfoAdicionalProduto
	 */
	public Long getIdInfoAdicionalProduto() {
		return idInfoAdicionalProduto;
	}

	/**
	 * @param idInfoAdicionalProduto
	 *            the idInfoAdicionalProduto to set
	 */
	public void setIdInfoAdicionalProduto(Long idInfoAdicionalProduto) {
		this.idInfoAdicionalProduto = idInfoAdicionalProduto;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the infoAdicional
	 */
	public InfoAdicional getInfoAdicional() {
		return infoAdicional;
	}

	/**
	 * @param infoAdicional
	 *            the infoAdicional to set
	 */
	public void setInfoAdicional(InfoAdicional infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

}
