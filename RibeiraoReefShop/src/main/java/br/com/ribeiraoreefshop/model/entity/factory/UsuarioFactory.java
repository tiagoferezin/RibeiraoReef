/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class UsuarioFactory {

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

	public String getNomeCompleto(Usuario usuario) {
		String result = "";

		List<String> listaNomeCompleto = new ArrayList<String>();
		listaNomeCompleto.add(usuario.getPrimeiroNome());
		listaNomeCompleto.add(usuario.getNomeDoMeio());
		listaNomeCompleto.add(usuario.getSobrenome());

		String nomeCompleto = "";

		for (String s : listaNomeCompleto) {

			if (s != null) {
				nomeCompleto = nomeCompleto + " " + s;
			}
		}

		nomeCompleto = Normalizacao.capitalizarTexto(nomeCompleto);
		nomeCompleto = nomeCompleto.trim();
		result = nomeCompleto;

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

}
