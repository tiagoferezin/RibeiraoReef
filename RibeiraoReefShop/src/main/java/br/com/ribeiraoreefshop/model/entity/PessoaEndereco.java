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
public class PessoaEndereco extends AEntity<PessoaEndereco> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoaEndereco;

	@OneToOne
	@JoinColumn(name = "idPessoa", nullable = false)
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name = "idEndereco", nullable = false)
	private Endereco endereco;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public PessoaEndereco() {

	}

	/**
	 * @return the idPessoaEndereco
	 */
	public Long getIdPessoaEndereco() {
		return idPessoaEndereco;
	}

	/**
	 * @param idPessoaEndereco
	 *            the idPessoaEndereco to set
	 */
	public void setIdPessoaEndereco(Long idPessoaEndereco) {
		this.idPessoaEndereco = idPessoaEndereco;
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
		return idPessoaEndereco;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPessoaEndereco = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}
}
