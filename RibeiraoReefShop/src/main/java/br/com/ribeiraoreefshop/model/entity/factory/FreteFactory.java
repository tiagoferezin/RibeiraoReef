/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.math.BigDecimal;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWSLocator;
import org.tempuri.CalcPrecoPrazoWSSoap;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.enumerador.EAvisoRecebimento;
import br.com.ribeiraoreefshop.model.enumerador.EMaoPropria;
import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;

/**
 * @author Tiago Ferezin
 *
 */
public class FreteFactory {

	private static String codSedex = "04014";
	private static String codPAC = "04510";
	private static String contratoCorreios = "";

	public Double getValorDoFreteSemSeguro(Frete frete, String cepOrigem,
			String cepDestino, Carrinho carrinho, EMaoPropria maopropia,
			EAvisoRecebimento avisoRecebimento) {

		Double result = 0D;

		CServico cs = chamadaFrete(frete, cepOrigem, cepDestino, carrinho,
				maopropia, avisoRecebimento);

		String valor = cs.getValorSemAdicionais();

		result = Double.parseDouble(valor);

		return result;

	}

	public Double getValorDoFreteComSeguro(Frete frete, String cepOrigem,
			String cepDestino, Carrinho carrinho, EMaoPropria maopropia,
			EAvisoRecebimento avisoRecebimento) {

		Double result = 0D;

		CServico cs = chamadaFrete(frete, cepOrigem, cepDestino, carrinho,
				maopropia, avisoRecebimento);

		String valor = cs.getValor();

		result = Double.parseDouble(valor);

		return result;

	}

	public Integer getPrazoDoFrete(Frete frete, String cepOrigem,
			String cepDestino, Carrinho carrinho, EMaoPropria maopropia,
			EAvisoRecebimento avisoRecebimento) {

		Integer result = 0;

		CServico cs = chamadaFrete(frete, cepOrigem, cepDestino, carrinho,
				maopropia, avisoRecebimento);

		String prazo = cs.getPrazoEntrega();

		result = Integer.parseInt(prazo);

		return result;

	}

	/**
	 * @param frete
	 * @param cepOrigem
	 * @param cepDestino
	 * @param carrinho
	 * @param maopropia
	 * @param avisoRecebimento
	 * @return
	 */
	private CServico chamadaFrete(Frete frete, String cepOrigem,
			String cepDestino, Carrinho carrinho, EMaoPropria maopropia,
			EAvisoRecebimento avisoRecebimento) {
		String nCdEmpresa = contratoCorreios;
		String sDsSenha = "";
		CServico result = null;
		String sCdMaoPropria = "";

		if (maopropia.equals(EMaoPropria.SIM)) {
			sCdMaoPropria = "S";
		} else {
			sCdMaoPropria = "N";
		}
		String sCdAvisoRecebimento = "";
		if (avisoRecebimento.equals(EAvisoRecebimento.SIM)) {
			sCdAvisoRecebimento = "S";
		} else {
			sCdAvisoRecebimento = "N";
		}

		String nCdServico = "";

		if (frete.getTipoFrete() == ETipoFrete.PAC) {
			nCdServico = codPAC;
		} else if (frete.getTipoFrete() == ETipoFrete.SEDEX) {
			nCdServico = codSedex;
		}

		String peso = String.valueOf(frete.getPeso());

		cepDestino = retornaFormatoCep(cepDestino);
		cepOrigem = retornaFormatoCep(cepOrigem);
		int nCdFormato = 1;// 1 para caixa, 2 para rolo ou prisma e 3 para
							// envelope

		BigDecimal nVlValorDeclarado = BigDecimal.valueOf(carrinho.getTotal());
		BigDecimal nVlComprimento = BigDecimal.valueOf(carrinho
				.getComprimentoTotal());
		BigDecimal nVlAltura = BigDecimal.valueOf(carrinho.getAlturaTotal());
		BigDecimal nVlLargura = BigDecimal.valueOf(carrinho.getLarguraTotal());
		BigDecimal nVlDiametro = BigDecimal.ZERO;

		try {

			CalcPrecoPrazoWSSoap soap = new CalcPrecoPrazoWSLocator()
					.getCalcPrecoPrazoWSSoap();

			CResultado res = soap.calcPrecoPrazo(nCdEmpresa, sDsSenha,
					nCdServico, cepOrigem, cepDestino, peso, nCdFormato,
					nVlComprimento, nVlAltura, nVlLargura, nVlDiametro,
					sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);

			CServico[] arrayServicos = res.getServicos();

			CServico cs = arrayServicos[0];

			result = cs;

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		return result;
	}

	public String retornaFormatoCep(String cep) {

		String result = "";
		cep = cep.trim();

		if (cep.contains("-")) {
			result = cep.replaceAll("-", "");
		} else {
			result = cep;
		}
		result = result.trim();
		return result;

	}

}
