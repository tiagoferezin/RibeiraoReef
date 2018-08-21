/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ribeiraoreefshop.exceptions.LoginInvalidException;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.factory.UsuarioFactory;
import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin Data: 14/08/2018
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public LoginController() {
		// TODO Auto-generated constructor stub
		System.out.println("Criou LoginController");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String paginaLogin() {

		// model.addAttribute("titulo", "Login");
		return "login/paginaLogin";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registrarUsuario")
	public String registrar(@Valid @ModelAttribute Usuario usuario,
			BindingResult bindingResult, Model model, HttpSession session) {
		String retorno = paginaLogin();
		UsuarioFactory uf = new UsuarioFactory();

		if (bindingResult.hasErrors()) {
			throw new LoginInvalidException();
		} else {
			if (usuario.getEmail().contains("@")) {
				String email = usuario.getEmail();
				usuario.setUsername(uf.gerarUsername(email));
			}
			String salt = uf.gerarSalt(usuario);
			usuario.setSalt(salt);
			String pass = "";
			String senhaInserida = "";
			senhaInserida = usuario.getSenha();
			try {
				pass = uf.gerarSenhaCriptogafada(usuario, senhaInserida);
				usuario.setSenha(pass);
				usuarioRepositorio.save(usuario);
				model.addAttribute("usuario", usuario);
				model.addAttribute("usuarioLogado", usuario);
				session.setAttribute("usuarioLogado", usuario);
				retorno = "redirect:minhaConta/" + usuario.getIdUsuario();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return retorno;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String autenticar(@Valid @ModelAttribute Usuario usuario,
			BindingResult bindingResult, Model model, HttpSession session) {

		System.out.println("Logando...");
		Usuario user = new Usuario();
		UsuarioFactory uf = new UsuarioFactory();
		String retorno = "login/paginaLogin";
		String username = "";
		String autenticar = "";
		String msgErro = "";

		if (bindingResult.hasErrors()) {
			throw new LoginInvalidException();
		} else {
			try {
				if (usuario.getUsername() == null) {
					if ((usuario.getEmail() != null)
							&& (!usuario.getEmail().isEmpty())) {
						username = uf.gerarUsername(usuario.getEmail());
					}
				}

				if ((usuario.getUsername() != null)
						&& (!usuario.getUsername().isEmpty())) {
					username = usuario.getUsername();

					if (username.contains("@")) {
						username = uf.gerarUsername(username);
					}

				}

				user = usuarioRepositorio.pegarUsuarioPeloUsername(username);

				if (user.getIdUsuario() > 0L) {
					String senha = "";

					senha = usuario.getSenha();

					autenticar = uf.chkAutenticar(user, senha);

					if(autenticar.equals("")) {
						
						model.addAttribute("usuarioLogado", usuario);
						session.setAttribute("usuarioLogado", usuario);
						retorno = "redirect:minhaConta/" + user.getIdUsuario();

					}

				}
			} catch (Exception e) {
				// TODO: handle exception
				autenticar = "Usuário não encontrado";
			}

		}
		model.addAttribute("usuario", user);
		model.addAttribute("mensagemErro", autenticar);
		System.out.println("O retorno esta assim: "+retorno);

		return retorno;

	}

}
