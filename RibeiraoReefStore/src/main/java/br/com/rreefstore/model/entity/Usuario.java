/**
 * 
 */
package br.com.rreefstore.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Usuario extends AEntity<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idUsuario;

	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String nomeCompleto;
	
	@Column(nullable = false)
	private String primeiroNome;
	
	private String nomeDoMeio;
	
	@Column(nullable = false)
	private String sobrenome;
	
	@Column(nullable = false)
	private String cpf;
	
	private String cnpj;
	
	@Column(nullable = false)
	private Double carteira;
	
	@Column(nullable = false)
	private Calendar dataCriacao;

	private Calendar dataDesativacao;

	public Usuario(){
		
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return idUsuario;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idUsuario = id;
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
