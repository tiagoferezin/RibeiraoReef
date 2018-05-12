/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class AtributoProduto extends AEntity<AtributoProduto> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtributoProduto;

	@OneToOne
	@JoinColumn(name = "idAtributo", nullable = false)
	private Atributo atributo;

	@OneToOne
	@JoinColumn(name = "idProduto", nullable = false)
	private Produto produto;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public AtributoProduto() {

	}

	/**
	 * @return the idAtributoProduto
	 */
	public Long getIdAtributoProduto() {
		return idAtributoProduto;
	}

	/**
	 * @param idAtributoProduto
	 *            the idAtributoProduto to set
	 */
	public void setIdAtributoProduto(Long idAtributoProduto) {
		this.idAtributoProduto = idAtributoProduto;
	}

	/**
	 * @return the atributo
	 */
	public Atributo getAtributo() {
		return atributo;
	}

	/**
	 * @param atributo
	 *            the atributo to set
	 */
	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
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
	 * @return the dataCriacao
	 */
	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the dataDesativacao
	 */
	public Calendar getDataDesativacao() {
		return dataDesativacao;
	}

	/**
	 * @param dataDesativacao
	 *            the dataDesativacao to set
	 */
	public void setDataDesativacao(Calendar dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idAtributoProduto;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idAtributoProduto = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
