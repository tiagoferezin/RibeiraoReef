/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity;

import java.util.Calendar;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.ribeiraoreefshop.model.enumerador.ETipoAuditoria;

/**
 * @author Tiago Ferezin
 *
 */
@Entity
public class Auditoria extends AEntity<Auditoria> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAuditoria;

	@Column(columnDefinition = "text")
	private String sqlGerado;
	@Column(columnDefinition = "text")
	private String descricao;
	@Column(columnDefinition = "text")
	private String erro;
	@Column(columnDefinition = "text")
	private String erroDetalhe;
	@Column(columnDefinition = "text")
	private String urlSolitada;
	@Column(columnDefinition = "text")
	private String urlAtendida;

	@Enumerated(EnumType.STRING)
	private ETipoAuditoria tipoAuditoria;
	@Column(columnDefinition = "text")
	private String username;

	private Integer atendida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar dataOcorrencia;

	@Transient
	@Inject
	private EntityManager entityManager;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDesativacao;

	public Auditoria() {

	}

	/**
	 * @return the idAuditoria
	 */
	public Long getIdAuditoria() {
		return idAuditoria;
	}

	/**
	 * @param idAuditoria
	 *            the idAuditoria to set
	 */
	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	/**
	 * @return the sqlGerado
	 */
	public String getSqlGerado() {
		return sqlGerado;
	}

	/**
	 * @param sqlGerado
	 *            the sqlGerado to set
	 */
	public void setSqlGerado(String sqlGerado) {
		this.sqlGerado = sqlGerado;
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
	 * @return the erro
	 */
	public String getErro() {
		return erro;
	}

	/**
	 * @param erro
	 *            the erro to set
	 */
	public void setErro(String erro) {
		this.erro = erro;
	}

	/**
	 * @return the erroDetalhe
	 */
	public String getErroDetalhe() {
		return erroDetalhe;
	}

	/**
	 * @param erroDetalhe
	 *            the erroDetalhe to set
	 */
	public void setErroDetalhe(String erroDetalhe) {
		this.erroDetalhe = erroDetalhe;
	}

	/**
	 * @return the urlSolitada
	 */
	public String getUrlSolitada() {
		return urlSolitada;
	}

	/**
	 * @param urlSolitada
	 *            the urlSolitada to set
	 */
	public void setUrlSolitada(String urlSolitada) {
		this.urlSolitada = urlSolitada;
	}

	/**
	 * @return the urlAtendida
	 */
	public String getUrlAtendida() {
		return urlAtendida;
	}

	/**
	 * @param urlAtendida
	 *            the urlAtendida to set
	 */
	public void setUrlAtendida(String urlAtendida) {
		this.urlAtendida = urlAtendida;
	}

	/**
	 * @return the tipoAuditoria
	 */
	public ETipoAuditoria getTipoAuditoria() {
		return tipoAuditoria;
	}

	/**
	 * @param tipoAuditoria
	 *            the tipoAuditoria to set
	 */
	public void setTipoAuditoria(ETipoAuditoria tipoAuditoria) {
		this.tipoAuditoria = tipoAuditoria;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the atendida
	 */
	public Integer getAtendida() {
		return atendida;
	}

	/**
	 * @param atendida
	 *            the atendida to set
	 */
	public void setAtendida(Integer atendida) {
		this.atendida = atendida;
	}

	/**
	 * @return the dataOcorrencia
	 */
	public Calendar getDataOcorrencia() {
		return dataOcorrencia;
	}

	/**
	 * @param dataOcorrencia
	 *            the dataOcorrencia to set
	 */
	public void setDataOcorrencia(Calendar dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
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
		return idAuditoria;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.idAuditoria = id;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

}
