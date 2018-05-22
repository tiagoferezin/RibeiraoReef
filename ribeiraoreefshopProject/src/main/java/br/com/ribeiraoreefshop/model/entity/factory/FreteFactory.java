/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWSLocator;
import org.tempuri.CalcPrecoPrazoWSSoap;

import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Frete;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.model.enumerador.EAvisoRecebimento;
import br.com.ribeiraoreefshop.model.enumerador.EMaoPropria;
import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;
import br.com.ribeiraoreefshop.utils.Normalizacao;

/**
 * @author Tiago Ferezin
 *
 */
public class FreteFactory {

	private static String codSedex = "04014";
	private static String codPAC = "04510";
	private static String contratoCorreios = "";

	public Double getPesoDoFrete(Carrinho carrinho, EntityManager entityManager) {

		Double result = 0D;

		ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();
		CarrinhoFactory cf = new CarrinhoFactory();
		List<ProdutoCarrinho> listaProdutoCarrinho = new ArrayList<ProdutoCarrinho>();
		listaProdutoCarrinho = pcf.getProdutosDoCarrinho(carrinho,
				entityManager);

		result = cf.calcularPesoTotal(listaProdutoCarrinho);
		return result;

	}

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

	public Integer quantidadeDeFretesNoPedido(Double pesoDaEncomenda) {
		Integer result = 0;

		double resultado = pesoDaEncomenda / 29;

		resultado = Normalizacao.arredondar(resultado, 0, 0);

		result = (int) resultado;

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

		String peso = "";

		cepDestino = retornaFormatoCep(cepDestino);
		cepOrigem = retornaFormatoCep(cepOrigem);
		int nCdFormato = 1;// 1 para caixa, 2 para rolo ou prisma e 3 para
							// envelope

		BigDecimal nVlValorDeclarado = BigDecimal.valueOf(carrinho.getTotal());
		BigDecimal nVlComprimento = BigDecimal.valueOf(carrinho
				.getComprimentoTotal());
		BigDecimal nVlAltura = BigDecimal.valueOf(carrinho.getAlturaTotal());
		BigDecimal nVlLargura = BigDecimal.valueOf(carrinho.getLarguraTotal());
		Double diametro = carrinho.getDiametroTotal();
		BigDecimal nVlDiametro = BigDecimal.ZERO;
		if (diametro > 0D) {
			nVlDiametro = BigDecimal.valueOf(diametro);
		}
		CServico cs = new CServico();

		try {

			Double pesoFrete = frete.getPeso();

			CalcPrecoPrazoWSSoap soap = new CalcPrecoPrazoWSLocator()
					.getCalcPrecoPrazoWSSoap();
			CResultado res = new CResultado();
			CServico arrayServicos[] = new CServico[50];
			if (pesoFrete <= 29) {
				peso = String.valueOf(pesoFrete);
				res = soap.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico,
						cepOrigem, cepDestino, peso, nCdFormato,
						nVlComprimento, nVlAltura, nVlLargura, nVlDiametro,
						sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);

				arrayServicos = res.getServicos();

				cs = arrayServicos[0];

				result = cs;

			} else {
				Double qtdDeFrete = pesoFrete / 29;

				List<Double> listaPeso = new ArrayList<Double>();

				Double novoPeso = 0D;
				Double qtd = qtdDeFrete;

				for (int i = 0; i < qtdDeFrete; i++) {

					if (i < qtdDeFrete - 1) {
						novoPeso = 29D;
					} else {

						novoPeso = 29 * qtd;

					}
					novoPeso = Normalizacao.arredondar(novoPeso, 2, 0);
					listaPeso.add(novoPeso);
					qtd = qtd - 1;
				}

				String valorSemAdicional = "";
				String valorTotalComTudo = "";
				Double vsa = 0D;
				Double vca = 0D;

				for (int i = 0; i < listaPeso.size(); i++) {
					Double peso1 = 0D;
					Double vsaInter = 0D;
					Double vcaInter = 0D;
					peso1 = listaPeso.get(i);

					peso = String.valueOf(peso1);
					res = soap.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico,
							cepOrigem, cepDestino, peso, nCdFormato,
							nVlComprimento, nVlAltura, nVlLargura, nVlDiametro,
							sCdMaoPropria, nVlValorDeclarado,
							sCdAvisoRecebimento);
					String value = "";

					arrayServicos = res.getServicos();
					CServico cs2 = new CServico();
					cs2 = arrayServicos[0];

					valorSemAdicional = cs2.getValorSemAdicionais();
					valorTotalComTudo = cs2.getValor();

					vcaInter = Normalizacao
							.converterStringValorToDouble(valorTotalComTudo);
					vsaInter = Normalizacao
							.converterStringValorToDouble(valorSemAdicional);

					vsa = vsa + vsaInter;
					vca = vca + vcaInter;

				}
				vsa = Normalizacao.arredondar(vsa, 2, 0);
				vca = Normalizacao.arredondar(vca, 2, 0);
				valorSemAdicional = String.valueOf(vsa);
				valorTotalComTudo = String.valueOf(vca);

				arrayServicos = res.getServicos();

				cs = arrayServicos[0];

				cs.setValor(valorTotalComTudo);
				cs.setValorSemAdicionais(valorSemAdicional);

				result = cs;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
		}

		return result;
	}

	public String retornaFormatoCep(String cep) {

		String result = "";
		cep = cep.trim();

		cep = Normalizacao.getTextoPesquisa(cep);

		// if (cep.contains("-")) {
		// result = cep.replaceAll("-", "");
		// } else {
		// result = cep;
		// }

		String resultado = cep.replaceAll("[^0-9]", "");
		result = resultado;

		result = result.trim();
		return result;

	}

}
