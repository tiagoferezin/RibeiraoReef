/**
 * 
 */
package br.com.ribeiraoreefshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.enumerador.ETipoPessoa;

/**
 * @author Tiago Ferezin Data: 17/08/2018
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();

		if (uri.endsWith("login") || uri.endsWith("autenticar")
				|| uri.contains("resources")
				|| uri.endsWith("registrarUsuario")) {
			
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			Usuario usuario = new Usuario();
			usuario = (Usuario) request.getSession().getAttribute(
					"usuarioLogado");
			if (uri.contains("admin")) {
				

				if ((usuario.getTipoPessoa().equals(ETipoPessoa.CLIENTE))
						|| (usuario.getTipoPessoa() == ETipoPessoa.CLIENTE)) {
					response.sendRedirect("/");
					
					return false;
				} else {
					return true;
				}
			}
			return true;
		}

		response.sendRedirect("/login");
		return false;
	}

}
