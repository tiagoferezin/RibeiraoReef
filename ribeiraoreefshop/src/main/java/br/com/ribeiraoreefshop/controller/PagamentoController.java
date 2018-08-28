/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tiago Ferezin
 * Data: 22/08/2018
 */
@Controller
@RequestMapping("/pagmento")
public class PagamentoController {

	// MercadoPago.SDK.setClientSecret(System.getenv("CLIENT_SECRET_OK"));
	// MercadoPago.SDK.setClientId(System.getenv("CLIENT_ID_OK"));
	//
	// Payment payment = new Payment()
	// .setTransactionAmount(100f)
	// .setToken("your_cardtoken")
	// .setDescription("description")
	// .setInstallments(1)
	// .setPaymentMethodId("visa")
	// .setPayer(new Payer()
	// .setEmail("dummy_email"));
	//
	// payment.save();
	//
	// System.out.println(payment.getStatus());
	
}
