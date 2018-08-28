/**
 * 
 */
package br.com.ribeiraoreefshop.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.stella.frete.CalculoFreteCorreio;
import br.com.caelum.stella.frete.entity.Encomenda;
import br.com.caelum.stella.frete.entity.Frete;
import br.com.caelum.stella.frete.enums.Servico;
import br.com.caelum.stella.frete.exception.CorreiosException;
import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;

/**
 * @author Tiago Ferezin Data: 28/08/2018
 */
public class FreteCalculoFactory {

	public static Map<ETipoFrete, Frete> mapFrete(String cepDestino,
			Double altura, Double largura, Double comprimento, Double peso,
			Double valor) throws CorreiosException {

		Map<ETipoFrete, Frete> retorno = new HashMap<ETipoFrete, Frete>();

		String comp = String.valueOf(comprimento);
		String larg = String.valueOf(largura);
		String alt = String.valueOf(altura);
		Encomenda encomenda = new Encomenda().doCep("14020380")
				.paraOCep(cepDestino).comComprimento(comp).comLargura(larg)
				.comAltura(alt).comPeso(peso).comValorDeclarado(valor);

		Frete freteSedex = new Frete();
		Frete freteSedex10 = new Frete();
		Frete fretePac = new Frete();
		Frete freteSedex12 = new Frete();

		freteSedex = CalculoFreteCorreio
				.calcularFrete(encomenda, Servico.SEDEX);
		freteSedex10 = CalculoFreteCorreio.calcularFrete(encomenda,
				Servico.SEDEX_10);
		fretePac = CalculoFreteCorreio.calcularFrete(encomenda, Servico.PAC);
		freteSedex12 = CalculoFreteCorreio.calcularFrete(encomenda,
				Servico.SEDEX_12);

		retorno.put(ETipoFrete.PAC, fretePac);
		retorno.put(ETipoFrete.SEDEX, freteSedex);
		retorno.put(ETipoFrete.SEDEX10, freteSedex10);
		retorno.put(ETipoFrete.SEDEX12, freteSedex12);

		return retorno;

	}

}
