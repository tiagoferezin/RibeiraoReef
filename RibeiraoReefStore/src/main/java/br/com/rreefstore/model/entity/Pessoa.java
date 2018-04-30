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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Pessoa extends AEntity<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idPessoa;

	@Column(nullable = false)
	private String nomePessoa;

	private Integer idade;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Pessoa() {

	}

	/**
	 * @return the idPessoa
	 */
	public Long getIdPessoa() {
		return idPessoa;
	}

	/**
	 * @param idPessoa
	 *            the idPessoa to set
	 */
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * @return the nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}

	/**
	 * @param nomePessoa
	 *            the nomePessoa to set
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
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
		return idPessoa;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idPessoa = id;
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
