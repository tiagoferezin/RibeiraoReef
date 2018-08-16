/**
 * 
 */
package br.com.ribeiraoreefshop.model;

import br.com.ribeiraoreefshop.model.entity.Usuario;

/**
 * @author Tiago Ferezin Data: 16/08/2018
 */
public class UsuarioLogado {

	private Long idUsuarioLogado;

	private Usuario usuarioLogado;

	private Integer logado;

	public UsuarioLogado(Usuario usuario) {

		this.usuarioLogado = usuario;
		this.logado = 1;

	}

	/**
	 * @return the logado
	 */
	public Integer getLogado() {
		return logado;
	}

	/**
	 * @param logado
	 *            the logado to set
	 */
	public void setLogado(Integer logado) {
		this.logado = logado;
	}

	/**
	 * @return the idUsuarioLogado
	 */
	public Long getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	/**
	 * @param idUsuarioLogado
	 *            the idUsuarioLogado to set
	 */
	public void setIdUsuarioLogado(Long idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	/**
	 * @return the usuarioLogado
	 */
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	/**
	 * @param usuarioLogado the usuarioLogado to set
	 */
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	

}
