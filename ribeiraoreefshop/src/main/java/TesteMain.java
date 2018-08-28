import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Santander;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.ribeiraoreefshop.factory.FreteCalculoFactory;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;

/**
 * 
 */

/**
 * @author Tiago Ferezin Data: 22/08/2018
 */
public class TesteMain {

	/**
	 * @param args
	 */

	private static String CLIENT_ID = "6022561322187514";
	private static String CLIENT_SECRET = "o6I92sjAPuPfTAJ7kvPXBxT4d4xKKzPq";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Datas datas = Datas.novasDatas().comDocumento(23, 8, 2018)
				.comVencimento(26, 8, 2018).comProcessamento(23, 8, 2018);
		Endereco enderecoBeneficiario = Endereco.novoEndereco()
				.comLogradouro("Av Portugal, 1000")
				.comBairro("Bairro Jd São Luiz").comCep("14020-380")
				.comCidade("Ribeirão Preto").comUf("SP");

		Beneficiario beneficiario = Beneficiario.novoBeneficiario()
				.comNomeBeneficiario("Ribeirão Reef").comAgencia("1824")
				.comDigitoAgencia("4").comCodigoBeneficiario("76000")
				.comDigitoCodigoBeneficiario("5").comNumeroConvenio("1207113")
				.comCarteira("18").comEndereco(enderecoBeneficiario)
				.comNossoNumero("9000206");

		Endereco enderecoPagador = Endereco.novoEndereco()
				.comLogradouro("Av dos testes, 111 apto 333")
				.comBairro("Bairro Teste").comCep("01234-111")
				.comCidade("São Paulo").comUf("SP");

		Pagador pagador = Pagador.novoPagador().comNome("Tiago Ferezin")
				.comDocumento("320.557.748-59").comEndereco(enderecoPagador);
		
		Banco banco = new Santander();
		
		Boleto boleto = Boleto.novoBoleto()  
                .comBanco(banco)  
                .comDatas(datas)  
                .comBeneficiario(beneficiario)  
                .comPagador(pagador)  
                .comValorBoleto("200.00")  
                .comNumeroDoDocumento("1234").comLocaisDePagamento("local 1", "local 2"); 
		
		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
		gerador.geraPDF("Pedido-12355.pdf");
		byte[] bPDF = gerador.geraPDF();  
		
		


		try {
			MercadoPago.SDK.setClientId(CLIENT_ID);
			MercadoPago.SDK.setClientSecret(CLIENT_SECRET);

			Payment pay = new Payment();

			String id = "4025024217";
			Payment p = pay.findById(id);

			System.out.println(p.getDescription());

		} catch (MPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
