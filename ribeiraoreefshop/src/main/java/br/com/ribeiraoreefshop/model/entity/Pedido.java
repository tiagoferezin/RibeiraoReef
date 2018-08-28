/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ribeiraoreefshop.model.enumerador.EMetodoPagamento;
import br.com.ribeiraoreefshop.model.enumerador.EStatusPedido;

/**
 * @author Tiago Ferezin Data: 22/08/2018
 */
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	private Double valorTotal;

	private String statusPagamento;

	@Enumerated(EnumType.STRING)
	private EStatusPedido statusPedido;

	@Enumerated(EnumType.STRING)
	private EMetodoPagamento metodoPagamento;

	private Double pesoTotal;
	private Double alturaTotal;
	private Double comprimentoTotal;
	private Double larguraTotal;

	public Pedido() {

	}

	/**
	 * @return the idPedido
	 */
	public Long getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido
	 *            the idPedido to set
	 */
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the statusPagamento
	 */
	public String getStatusPagamento() {
		return statusPagamento;
	}

	/**
	 * @param statusPagamento
	 *            the statusPagamento to set
	 */
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	/**
	 * @return the statusPedido
	 */
	public EStatusPedido getStatusPedido() {
		return statusPedido;
	}

	/**
	 * @param statusPedido
	 *            the statusPedido to set
	 */
	public void setStatusPedido(EStatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	/**
	 * @return the metodoPagamento
	 */
	public EMetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	/**
	 * @param metodoPagamento
	 *            the metodoPagamento to set
	 */
	public void setMetodoPagamento(EMetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	/**
	 * @return the pesoTotal
	 */
	public Double getPesoTotal() {
		return pesoTotal;
	}

	/**
	 * @param pesoTotal
	 *            the pesoTotal to set
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
	 * @param alturaTotal
	 *            the alturaTotal to set
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
	 * @param comprimentoTotal
	 *            the comprimentoTotal to set
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
	 * @param larguraTotal
	 *            the larguraTotal to set
	 */
	public void setLarguraTotal(Double larguraTotal) {
		this.larguraTotal = larguraTotal;
	}

}
