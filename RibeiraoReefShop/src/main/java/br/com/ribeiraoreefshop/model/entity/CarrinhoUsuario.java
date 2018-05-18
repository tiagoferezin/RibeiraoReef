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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ribeiraoreefshop.model.enumerador.EStatus;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class CarrinhoUsuario extends AEntity<CarrinhoUsuario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinhoUsuario;

	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "idCarrinho")
	private Carrinho carrinho;

	@Enumerated(EnumType.STRING)
	private EStatus status;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public CarrinhoUsuario() {

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
	 * @return the idCarrinhoUsuario
	 */
	public Long getIdCarrinhoUsuario() {
		return idCarrinhoUsuario;
	}

	/**
	 * @param idCarrinhoUsuario
	 *            the idCarrinhoUsuario to set
	 */
	public void setIdCarrinhoUsuario(Long idCarrinhoUsuario) {
		this.idCarrinhoUsuario = idCarrinhoUsuario;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the carrinho
	 */
	public Carrinho getCarrinho() {
		return carrinho;
	}

	/**
	 * @param carrinho
	 *            the carrinho to set
	 */
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
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
		return idCarrinhoUsuario;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idCarrinhoUsuario = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
