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
public class ImagemProduto extends AEntity<ImagemProduto> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImagemProduto;

	@OneToOne
	@JoinColumn(name = "idProduto", nullable = false)
	private Produto produto;

	@OneToOne
	@JoinColumn(name = "idImagem", nullable = false)
	private Imagem imagem;

	@Column(nullable = false)
	private Integer principal;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public ImagemProduto() {

	}

	/**
	 * @return the idImagemProduto
	 */
	public Long getIdImagemProduto() {
		return idImagemProduto;
	}

	/**
	 * @param idImagemProduto
	 *            the idImagemProduto to set
	 */
	public void setIdImagemProduto(Long idImagemProduto) {
		this.idImagemProduto = idImagemProduto;
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
	 * @return the imagem
	 */
	public Imagem getImagem() {
		return imagem;
	}

	/**
	 * @param imagem
	 *            the imagem to set
	 */
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	/**
	 * @return the principal
	 */
	public Integer getPrincipal() {
		return principal;
	}

	/**
	 * @param principal
	 *            the principal to set
	 */
	public void setPrincipal(Integer principal) {
		this.principal = principal;
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
		return idImagemProduto;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idImagemProduto = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
