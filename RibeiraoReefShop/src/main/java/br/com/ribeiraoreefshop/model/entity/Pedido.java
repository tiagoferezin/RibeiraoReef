/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ribeiraoreefshop.model.enumerador.EStatus;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido extends AEntity<Pedido> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@Column(nullable = false)
	private String numeroPedido;

	@Column(nullable = false)
	private Integer quantidade;

	@Enumerated(EnumType.STRING)
	private EStatus status;

	@OneToOne
	@JoinColumn(name = "idEndereco", nullable = false)
	private Endereco endereco;

	private Double valorSemFrete;

	private Double valorComFrete;

	private Integer pontos;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Pedido() {

	}

	/**
	 * @return the pontos
	 */
	public Integer getPontos() {
		return pontos;
	}

	/**
	 * @param pontos
	 *            the pontos to set
	 */
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	/**
	 * @return the valorSemFrete
	 */
	public Double getValorSemFrete() {
		return valorSemFrete;
	}

	/**
	 * @param valorSemFrete
	 *            the valorSemFrete to set
	 */
	public void setValorSemFrete(Double valorSemFrete) {
		this.valorSemFrete = valorSemFrete;
	}

	/**
	 * @return the valorComFrete
	 */
	public Double getValorComFrete() {
		return valorComFrete;
	}

	/**
	 * @param valorComFrete
	 *            the valorComFrete to set
	 */
	public void setValorComFrete(Double valorComFrete) {
		this.valorComFrete = valorComFrete;
	}

	/**
	 * @return the numeroPedido
	 */
	public String getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * @param numeroPedido
	 *            the numeroPedido to set
	 */
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * @return the status
	 */
	public EStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(EStatus status) {
		this.status = status;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idPedido;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPedido = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calendar getDataDesativacao() {
		// TODO Auto-generated method stub
		return dataDesativacao;
	}

	@Override
	public void setDataDesativacao(Calendar dataDesativacao) {
		// TODO Auto-generated method stub
		this.dataDesativacao = dataDesativacao;
	}

}
