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
 * @author Tiago Ferezin Data: 20/08/2018
 */
@Entity
public class ImagemProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImagemProduto;

	@OneToOne
	@JoinColumn(name = "idImagem")
	private Imagem imagem;

	@OneToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;

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

}
