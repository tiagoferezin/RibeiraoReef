/**
 * 
 */
package br.com.ribeiraoreefshop.model.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin
 * Data: 16/08/2018
 */
@Service
public class ServicoAutenticacao implements UserDetailsService{

	@Autowired UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findOneByLogin(login);
	}
}
