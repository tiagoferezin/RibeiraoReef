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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ribeiraoreefshop.model.enumerador.EPermissaoEncomenda;
import br.com.ribeiraoreefshop.model.enumerador.EStatus;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Produto extends AEntity<Produto> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@Column(nullable = false)
	private String nomeProduto;

	private String breveDescricao;

	private String descricao;

	private String codigoReferencia;

	@Column(nullable = false)
	private Double valor;

	@Column(nullable = false)
	private Integer estoque;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EPermissaoEncomenda permitirEncomenda;

	@Column(nullable = false)
	private Integer venderInidividual;

	@Enumerated(EnumType.STRING)
	private EStatus status;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Produto() {

		this.estoque = 0;
		this.valor = 0D;
		this.venderInidividual = 0;

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
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia
	 *            the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
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
	 * @return the permitirEncomenda
	 */
	public EPermissaoEncomenda getPermitirEncomenda() {
		return permitirEncomenda;
	}

	/**
	 * @param permitirEncomenda
	 *            the permitirEncomenda to set
	 */
	public void setPermitirEncomenda(EPermissaoEncomenda permitirEncomenda) {
		this.permitirEncomenda = permitirEncomenda;
	}

	/**
	 * @return the venderInidividual
	 */
	public Integer getVenderInidividual() {
		return venderInidividual;
	}

	/**
	 * @param venderInidividual
	 *            the venderInidividual to set
	 */
	public void setVenderInidividual(Integer venderInidividual) {
		this.venderInidividual = venderInidividual;
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
		return idProduto;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idProduto = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
