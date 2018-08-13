/**
 * 
 */
package br.com.ribeiraoreefshop.controleHorario.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 09/08/2018
 */
@Entity
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHorario;

	@Column(nullable = false)
	private Calendar data;

	@Column(nullable = false)
	private Calendar horaEntrada;

	private Calendar saidaAlmoco;
	private Calendar retornoAlmoco;

	@Column(nullable = false)
	private Calendar saida;

	private Integer minutosTrabalhados;

	private String totalDeHorasTrabalhadas;

	@Column(nullable = false)
	private Integer mes;

	public Horario() {

	}

	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}

	/**
	 * @param mes
	 *            the mes to set
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	/**
	 * @return the minutosTrabalhados
	 */
	public Integer getMinutosTrabalhados() {
		return minutosTrabalhados;
	}

	/**
	 * @param minutosTrabalhados
	 *            the minutosTrabalhados to set
	 */
	public void setMinutosTrabalhados(Integer minutosTrabalhados) {
		this.minutosTrabalhados = minutosTrabalhados;
	}

	/**
	 * @return the totalDeHorasTrabalhadas
	 */
	public String getTotalDeHorasTrabalhadas() {
		return totalDeHorasTrabalhadas;
	}

	/**
	 * @param totalDeHorasTrabalhadas
	 *            the totalDeHorasTrabalhadas to set
	 */
	public void setTotalDeHorasTrabalhadas(String totalDeHorasTrabalhadas) {
		this.totalDeHorasTrabalhadas = totalDeHorasTrabalhadas;
	}

	/**
	 * @return the idHorario
	 */
	public Long getIdHorario() {
		return idHorario;
	}

	/**
	 * @param idHorario
	 *            the idHorario to set
	 */
	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return the horaEntrada
	 */
	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	/**
	 * @param horaEntrada
	 *            the horaEntrada to set
	 */
	public void setHoraEntrada(Calendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	/**
	 * @return the saidaAlmoco
	 */
	public Calendar getSaidaAlmoco() {
		return saidaAlmoco;
	}

	/**
	 * @param saidaAlmoco
	 *            the saidaAlmoco to set
	 */
	public void setSaidaAlmoco(Calendar saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	/**
	 * @return the retornoAlmoco
	 */
	public Calendar getRetornoAlmoco() {
		return retornoAlmoco;
	}

	/**
	 * @param retornoAlmoco
	 *            the retornoAlmoco to set
	 */
	public void setRetornoAlmoco(Calendar retornoAlmoco) {
		this.retornoAlmoco = retornoAlmoco;
	}

	/**
	 * @return the saida
	 */
	public Calendar getSaida() {
		return saida;
	}

	/**
	 * @param saida
	 *            the saida to set
	 */
	public void setSaida(Calendar saida) {
		this.saida = saida;
	}

}
