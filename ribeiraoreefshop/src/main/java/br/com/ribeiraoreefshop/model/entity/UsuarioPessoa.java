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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Tiago Ferezin Data: 17/08/2018
 */
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "idUsuario", name = "uk_idUsuario"),
		@UniqueConstraint(columnNames = "idPessoa", name = "uk_idPessoa") })
public class UsuarioPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuarioPessoa;

	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	public UsuarioPessoa() {

	}

	/**
	 * @return the idUsuarioPessoa
	 */
	public Long getIdUsuarioPessoa() {
		return idUsuarioPessoa;
	}

	/**
	 * @param idUsuarioPessoa
	 *            the idUsuarioPessoa to set
	 */
	public void setIdUsuarioPessoa(Long idUsuarioPessoa) {
		this.idUsuarioPessoa = idUsuarioPessoa;
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

}
