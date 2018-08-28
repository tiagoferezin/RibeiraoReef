/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.repositories.PedidoRepositorio;
import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin Data: 22/08/2018
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoRepositorio pedidoRepositorio;

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPedidos(Model model) {

		Iterable<Pedido> listaPedidos = pedidoRepositorio.findAll();

		model.addAttribute("listaPedidos", listaPedidos);

		return "pedido/listaPedidos";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{idUsuario}")
	public String pedidosDoUsuario(@PathVariable Long idUsuario, Model model) {
		Usuario usuario = new Usuario();
		
		usuario = usuarioRepositorio.findOne(idUsuario);
		
		

		return null;
	}

}
