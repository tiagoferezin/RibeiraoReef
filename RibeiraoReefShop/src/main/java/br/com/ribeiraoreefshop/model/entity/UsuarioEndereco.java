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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
@Table(name = "usuarioendereco")
public class UsuarioEndereco extends AEntity<UsuarioEndereco> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuarioEndereco;

	@OneToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "idEndereco", nullable = false)
	private Endereco endereco;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public UsuarioEndereco() {

	}

	/**
	 * @return the idUsuarioEndereco
	 */
	public Long getIdUsuarioEndereco() {
		return idUsuarioEndereco;
	}

	/**
	 * @param idUsuarioEndereco
	 *            the idUsuarioEndereco to set
	 */
	public void setIdUsuarioEndereco(Long idUsuarioEndereco) {
		this.idUsuarioEndereco = idUsuarioEndereco;
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idUsuarioEndereco;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idUsuarioEndereco = id;
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

	@Override
	public Calendar getDataCriacao() {
		// TODO Auto-generated method stub
		return dataCriacao;
	}

	@Override
	public void setDataCriacao(Calendar dataCriacao) {
		// TODO Auto-generated method stub
		this.dataCriacao = dataCriacao;
	}

}
