/**
 * 
 */
package br.com.ribeiraoreefshop.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.model.entity.Pedido;
import br.com.ribeiraoreefshop.model.entity.factory.PedidoFactory;
import br.com.ribeiraoreefshop.utils.JPAUtil;

/**
 * @author Tiago Ferezin
 *
 */
public class Testar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Pedido pedido = new Pedido();
		pedido.setDataCriacao(Calendar.getInstance());
		pedido.setQuantidade(5);
		PedidoFactory pf = new PedidoFactory();
		String codigo = "";
		try {
			//codigo = pf.geraCodigo(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Codigo gerado foi: " + codigo);

	}

}
