/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class UsuarioFactory {
	GenericDAOFactory daoFactory = new GenericDAOFactory();

	public Usuario getUsuario(Long idUsuario, EntityManager entityManager)
			throws Exception {

		Usuario result = new Usuario();
		Usuario usuario = new Usuario();

		result = (Usuario) daoFactory.readPorId(usuario, entityManager,
				idUsuario);

		return result;
	}

	public List<Usuario> listarUsuariosAtivos(EntityManager entityManager)
			throws Exception {

		List<Usuario> result = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		List<AEntity> lista = new ArrayList<AEntity>();

		lista = daoFactory.readAllActives(usuario, entityManager);

		for (AEntity ae : lista) {
			usuario = (Usuario) ae;
			result.add(usuario);
		}

		return result;

	}

	public String senhaCriptografada(String salt, String senha)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = "";

		if ((senha != null) && (!senha.isEmpty()) && (salt != null)
				&& (!salt.isEmpty())) {

			String pass = senha;
			String nameSalt = salt;
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest((pass + nameSalt)
					.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			senha = hexString.toString();
			result = senha;

		}

		return result;
	}

	public Boolean chkSenha(Usuario usuario, String senhaDescriptografada)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Boolean result = false;

		if ((senhaDescriptografada != null)
				&& (!senhaDescriptografada.isEmpty())
				&& (usuario.getSalt() != null)
				&& (!usuario.getSalt().isEmpty())
				&& (usuario.getSenha() != null)
				&& (!usuario.getSenha().isEmpty())) {

			String pass = senhaDescriptografada;
			String nameSalt = usuario.getSalt();
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest((pass + nameSalt)
					.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			senhaDescriptografada = hexString.toString();
			// logger.debug(senhaDescriptografada);

			result = usuario.getSenha().equals(senhaDescriptografada);

		}
		return result;

	}

	public String chkAutenticar(Usuario usuario, String senhaDescriptografada) {
		String result = "";

		try {
			if (chkSenha(usuario, senhaDescriptografada)) {
				result = "";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "<strong>RR-002:<strong/> O usuário e/ou senha estão incorretos.";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "<strong>RR-002:<strong/> O usuário e/ou senha estão incorretos.";
		}

		return result;
	}

	
	public String gerarUsername(Usuario usuario) {
		String result = usuario.getUsername();

		if ((usuario.getUsername() == "") || (usuario.getUsername() == null)
				|| (usuario.getUsername().isEmpty())) {
			result = usuario.getEmail();
		}
		return result;
	}
	
	public String gerarSalt(Usuario usuario){
		String result = "";
		
		result = usuario.getEmail();
		
		return result;
	}

}
