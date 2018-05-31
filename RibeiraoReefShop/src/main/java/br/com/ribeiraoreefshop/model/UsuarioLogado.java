/**
 * 
 */
package br.com.ribeiraoreefshop.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.funcoes.Funcoes;
import br.com.ribeiraoreefshop.intercepts.AcessoInterceptor;
import br.com.ribeiraoreefshop.model.entity.Auditoria;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.factory.AuditoriaFactory;
import br.com.ribeiraoreefshop.model.enumerador.ETipoAuditoria;

/**
 * @author Tiago Ferezin
 *
 */

//@Named("usuarioLogado")
public class UsuarioLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Boolean logado;

	private AuditoriaFactory af = new AuditoriaFactory();
//	private Auditoria auditoria;

//	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public UsuarioLogado() {
		System.out.println("Inicializando Construtor Usuario Logado");
		usuario = new Usuario();

		logado = false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Boolean getLogado() {
		return logado;
	}

	public Boolean chkLogado() {

		return this.logado;

	}

	public void setLogin(Usuario usuario, Boolean logado) {

		// EntityManager entityManager = acessoInterceptor.getEntityManager();
		if (logado) {
			this.usuario = usuario;
			this.logado = true;
			// try {
			// auditoria = af.getAuditoria(entityManager);//
			// ETipoAuditoria.Autenticacao
			//
			// auditoria.setAtendida(1);
			// auditoria.setDataOcorrencia(Calendar.getInstance());
			// auditoria.setDescricao("Autenticação de Usuário");
			// auditoria.setTipoAuditoria(ETipoAuditoria.Autenticacao);
			// // auditoria.setUrlRequisitada("/teste/test");
			// auditoria.setUsername(usuario.getUsername());
			// // auditoria.inserir();
			//
			// daoFactory.create(auditoria, entityManager);
			// } catch (Exception e) {
			// // TODO: handle exception
			// e.printStackTrace();
			// }
		} else {
			this.logado = false;
			// try {
			// auditoria = af.getAuditoria(entityManager);//
			// ETipoAuditoria.Autenticacao
			//
			// auditoria.setAtendida(0);
			// auditoria.setDataOcorrencia(Calendar.getInstance());
			// auditoria.setDescricao("Autenticação de Usuário Negada");
			// auditoria.setTipoAuditoria(ETipoAuditoria.AutenticacaoNegada);
			// // auditoria.setUrlRequisitada("");
			// auditoria.setUsername(this.usuario.getUsername());
			// // auditoria.inserir();
			// daoFactory.create(auditoria, entityManager);
			// } catch (Exception e) {
			// // TODO: handle exception
			// e.printStackTrace();
			// }
		}

	}

	public void setLogout() {
		// EntityManager entityManager = acessoInterceptor.getEntityManager();
		Funcoes funcoes = new Funcoes();
		funcoes.logout();

		// try {
		// System.out.println("Gravando auditoria de logout!");
		// auditoria = af.getAuditoria(entityManager);//
		// ETipoAuditoria.AutenticacaoLogout
		//
		// auditoria.setAtendida(1);
		// auditoria.setDataOcorrencia(Calendar.getInstance());
		// auditoria.setDescricao("Autenticação de Logout de Usuário");
		// auditoria.setTipoAuditoria(ETipoAuditoria.AutenticacaoLogout);
		// // auditoria.setUrlRequisitada("");
		// auditoria.setUsername(usuario.getUsername());
		//
		// daoFactory.create(auditoria, entityManager);
		// // auditoria.inserir();
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// } finally {
		this.logado = false;
		this.usuario = null;
		// }

	}

}
