/**
 * 
 */
package br.com.ribeiraoreefshop.intercepts;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.ribeiraoreefshop.anotacao.AcessoPublico;
import br.com.ribeiraoreefshop.controller.LoginController;
import br.com.ribeiraoreefshop.model.UsuarioLogado;

/**
 * @author Tiago Ferezin
 *
 */

public class AcessoInterceptor {

	

//	@Inject
//	private EntityManager entityManager;
//
//	@Inject
//	private final Result result;
//
//	private final UsuarioLogado usuarioLogado;
//
//	public AcessoInterceptor(UsuarioLogado usuarioLogado, Result result) {
//		// TODO Auto-generated constructor stub
//		this.result = result;
//		this.usuarioLogado = usuarioLogado;
//	}
//
//	@Override
//	@Accepts
//	public boolean accepts(ControllerMethod method) {
//		// TODO Auto-generated method stub
//		Boolean result = false;
//			
//		result = !this.usuarioLogado.chkLogado()
//				&& !method.containsAnnotation(AcessoPublico.class);
//		return result;
//	}
//
//	@Override
//	@AroundCall
//	public void intercept(InterceptorStack stack, ControllerMethod method,
//			Object objetoInstanciado) throws InterceptionException {
//		// TODO Auto-generated method stub
//		result.redirectTo(LoginController.class).login();
//
//	}
//
//	@BeforeCall
//	public void beforeIntercept() {
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("postgreSQL");
//		entityManager = factory.createEntityManager();
//	}

}
