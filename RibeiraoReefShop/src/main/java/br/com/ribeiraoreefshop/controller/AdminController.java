/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.factory.UsuarioFactory;
import br.com.ribeiraoreefshop.model.enumerador.ETipoUsuario;

/**
 * @author Tiago Ferezin
 *
 */
@Path("/admin")
@Controller
public class AdminController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;

	private GenericDAOFactory genericDAOFactory = new GenericDAOFactory();

	@Path("/formularioAdmin")
	public void formularioAdmin() {

	}

	@Path("/")
	public void admin() {

	}

	@Path("/loginAdmin")
	public void loginAdmin(String username, String senha) {
		Usuario usuario = new Usuario();

		String email = "";
		if (username.contains("@")) {
			email = username;
		}

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String senhaCheck = "";

		UsuarioFactory uf = new UsuarioFactory();
		try {

			listaUsuarios = uf.listarUsuariosAtivos(this.entityManager);

			for (Usuario usuarioProv : listaUsuarios) {
				if (usuario == null) {

					if (email != "") {
						if (usuarioProv.getEmail() == email) {
							usuario = usuarioProv;
						}
					} else {
						if (usuarioProv.getUsername() == username) {
							usuario = usuarioProv;
						}
					}
				}
			}

			senhaCheck = uf.chkAutenticar(usuario, senha);
			ETipoUsuario tipoUsuario = usuario.getTipoUsuario();
			if (senhaCheck == "") {
				if ((tipoUsuario.equals(ETipoUsuario.ADMINISTRADOR))
						|| (tipoUsuario == ETipoUsuario.ADMINISTRADOR)) {
					result.redirectTo(this).admin();
				}else{
					result.include("erro", senhaCheck);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
