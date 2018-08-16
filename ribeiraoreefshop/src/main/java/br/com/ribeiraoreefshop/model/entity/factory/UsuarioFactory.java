/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.ribeiraoreefshop.model.entity.Usuario;

/**
 * @author Tiago Ferezin Data: 14/08/2018
 */
public class UsuarioFactory {

	public String gerarUsername(String email) {

		String retorno = "";

		String[] partesDoEmail = email.split("@");

		retorno = partesDoEmail[0];

		return retorno;
	}

	public String gerarSenhaCriptogafada(Usuario usuario, String senhaAberta)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {

		String retorno = "";

		if ((senhaAberta != null) && (!senhaAberta.isEmpty())) {
			String salt = "";
			salt = usuario.getSalt();
			if ((salt != null) && (!salt.isEmpty()) && (salt != "")) {

				MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
				byte messageDigest[] = algorithm.digest((senhaAberta + salt)
						.getBytes("UTF-8"));
				StringBuilder hexString = new StringBuilder();
				for (byte b : messageDigest) {
					hexString.append(String.format("%02X", 0xFF & b));
				}
				retorno = hexString.toString();

			}

		}

		return retorno;

	}

	public String gerarSalt(Usuario usuario) {

		String retorno = "";

		String email = "";
		email = usuario.getEmail();
		String username = "";
		if ((usuario.getUsername() == null)
				|| (usuario.getUsername().isEmpty())) {
			usuario.setUsername(gerarUsername(email));
		}
		username = usuario.getUsername();

		retorno = email + username;

		return retorno;

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

}
