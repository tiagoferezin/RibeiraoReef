/**
 * 
 */
package br.com.ribeiraoreefshop.controleHorario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ribeiraoreefshop.controleHorario.exceptions.HorarioInvalidException;
import br.com.ribeiraoreefshop.controleHorario.model.entity.Horario;
import br.com.ribeiraoreefshop.controleHorario.model.factory.HorarioFactory;
import br.com.ribeiraoreefshop.controleHorario.model.repositories.HorarioRepositorio;

/**
 * @author Tiago Ferezin Data: 09/08/2018
 */
@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private HorarioRepositorio horarioRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listaHorarios(Model model) {

		Iterable<Horario> listaHorarios = horarioRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de Horários");
		model.addAttribute("listaHorarios", listaHorarios);

		return "horario/listaHorarios";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{idHorario}")
	@ResponseBody
	public Horario buscarHorario(@PathVariable Long idHorario) {

		Horario horario = new Horario();

		horario = horarioRepositorio.findOne(idHorario);

		return horario;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarHorario(@Valid @ModelAttribute Horario horario,
			BindingResult bindingResult, Model model) {

		HorarioFactory horarioFactory = new HorarioFactory();

		Long idHorario = horario.getIdHorario();
		Integer minutosTrabalhados = 0;
		String horasString = "";

		minutosTrabalhados = horarioFactory
				.totalMinutosTrabalhadoDoDia(idHorario);

		horasString = horarioFactory.getHorasString(horario);

		horario.setMinutosTrabalhados(minutosTrabalhados);
		horario.setTotalDeHorasTrabalhadas(horasString);

		if (bindingResult.hasErrors()) {

			throw new HorarioInvalidException();

		}else{
			horarioRepositorio.save(horario);
		}
		
		Iterable<Horario> listaHorarios = horarioRepositorio.findAll();

		model.addAttribute("listaHorarios", listaHorarios);

		return "horario/tabelaHorario";

	}

}
