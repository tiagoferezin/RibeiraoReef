/**
 * 
 */
package br.com.ribeiraoreefshop.controleHorario.model.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ribeiraoreefshop.controleHorario.model.entity.Horario;
import br.com.ribeiraoreefshop.controleHorario.model.repositories.HorarioRepositorio;
import br.com.ribeiraoreefshop.controleHorario.utils.VerificacaoData;

/**
 * @author Tiago Ferezin Data: 09/08/2018
 */
public class HorarioFactory {

	@Autowired
	HorarioRepositorio horarioRepositorio;

	public Integer totalMinutosTrabalhadoDoDia(Long idHorario) {
		Integer retorno = 0;

		Horario horario = new Horario();

		horario = horarioRepositorio.findOne(idHorario);

		Integer minutosManha = 0;
		Integer minutosTarde = 0;
		Integer totalMinutos = 0;

		minutosManha = 0;

		Calendar horaEntrada = horario.getHoraEntrada();
		Calendar horaSaidaAlmoco = horario.getSaidaAlmoco();
		Calendar horaRetornoAlmoco = horario.getRetornoAlmoco();
		Calendar horaSaida = horario.getSaida();

		if (horaSaidaAlmoco != null) {

			minutosManha = VerificacaoData.minutosEntreCalendar(horaEntrada,
					horaSaidaAlmoco);
			minutosTarde = VerificacaoData.minutosEntreCalendar(
					horaRetornoAlmoco, horaSaida);

			totalMinutos = minutosManha + minutosTarde;
		} else {
			totalMinutos = VerificacaoData.minutosEntreCalendar(horaEntrada,
					horaSaida);
		}

		retorno = totalMinutos;

		return retorno;
	}

	public String getHorasString(Horario horario) {
		String retorno = "";

		Integer minutosDoDia = 0;

		minutosDoDia = horario.getMinutosTrabalhados();

		if (minutosDoDia > 0) {
			Long idHorario = 0L;
			idHorario = horario.getIdHorario();

			if (idHorario > 0L) {
				minutosDoDia = totalMinutosTrabalhadoDoDia(idHorario);
			}

			Integer horas = 0;
			Integer minutos = 0;

			horas = minutosDoDia / 60;
			minutos = minutosDoDia % 60;

			retorno = horas + ":" + minutos;

		}

		return retorno;

	}

	public String totalDeHorasTrabalhadasNoMes(Integer mes) {
		String retorno = "";

		List<Horario> listaHorarios = new ArrayList<Horario>();

		listaHorarios = horarioRepositorio.listarHorarios(mes);

		Integer totalMinutos = 0;

		for (Horario horario : listaHorarios) {

			Integer minutosTrabalhadoDia = 0;
			minutosTrabalhadoDia = horario.getMinutosTrabalhados();
			totalMinutos = totalMinutos + minutosTrabalhadoDia;
		}
		
		Integer horas = 0;
		Integer minutos = 0;

		horas = totalMinutos / 60;
		minutos = totalMinutos % 60;

		retorno = horas + ":" + minutos;

		return retorno;
	}

}
