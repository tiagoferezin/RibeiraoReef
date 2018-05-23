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
public class PessoaUsuario extends AEntity<PessoaUsuario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoaUsuario;

	@OneToOne
	@JoinColumn(name = "idPessoa", nullable = false)
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public PessoaUsuario() {

	}

	/**
	 * @return the idPessoaUsuario
	 */
	public Long getIdPessoaUsuario() {
		return idPessoaUsuario;
	}

	/**
	 * @param idPessoaUsuario
	 *            the idPessoaUsuario to set
	 */
	public void setIdPessoaUsuario(Long idPessoaUsuario) {
		this.idPessoaUsuario = idPessoaUsuario;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		return idPessoaUsuario;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPessoaUsuario = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
