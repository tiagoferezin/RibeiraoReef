/**
 * 
 */
package br.com.ribeiraoreefshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/**
 * @author Tiago Ferezin Data: 17/08/2018
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();
		
		if (uri.endsWith("login") || uri.endsWith("autenticar")
				|| uri.contains("resources") || uri.endsWith("registrarUsuario")) {
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}

		response.sendRedirect("/login");
		return false;
	}

}
