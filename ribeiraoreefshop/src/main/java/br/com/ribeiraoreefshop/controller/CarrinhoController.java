/**
 * 
 */
package br.com.ribeiraoreefshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.stella.frete.entity.Frete;
import br.com.caelum.stella.frete.exception.CorreiosException;
import br.com.ribeiraoreefshop.factory.FreteCalculoFactory;
import br.com.ribeiraoreefshop.model.entity.Carrinho;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.ProdutoCarrinho;
import br.com.ribeiraoreefshop.model.entity.Usuario;
import br.com.ribeiraoreefshop.model.entity.factory.CarrinhoFactory;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoCarrinhoFactory;
import br.com.ribeiraoreefshop.model.enumerador.ETipoFrete;
import br.com.ribeiraoreefshop.model.repositories.CarrinhoRepositorio;
import br.com.ribeiraoreefshop.model.repositories.ProdutoCarrinhoRepositorio;
import br.com.ribeiraoreefshop.model.repositories.UsuarioRepositorio;

/**
 * @author Tiago Ferezin Data: 27/08/2018
 */
@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Autowired
	CarrinhoRepositorio carrinhoRepositorio;

	@Autowired
	ProdutoCarrinhoRepositorio produtoCarrinhoRepositorio;

	@RequestMapping(method = RequestMethod.GET, value = "{idUsuario}")
	public String carrinho(@PathVariable Long idUsuario, Model model,
			String cepDestino) {

		Usuario usuario = new Usuario();
		Carrinho carrinho = new Carrinho();
		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
		Integer quantidadeItensCarrinho = 0;
		Map<ETipoFrete, Frete> mapFretes = new HashMap<ETipoFrete, Frete>();
		CarrinhoFactory cf = new CarrinhoFactory();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		usuario = usuarioRepositorio.findOne(idUsuario);
		Carrinho carrinhoFrete = new Carrinho();

		String emailUsuario = "";
		emailUsuario = usuario.getEmail();

		carrinho = carrinhoRepositorio.carrinhoDoUsuario(emailUsuario);

		if (carrinho != null) {
			listaProdutos = produtoCarrinhoRepositorio
					.produtosCarrinho(carrinho);

			if ((listaProdutos != null) && (listaProdutos.size() > 0)) {
				quantidadeItensCarrinho = listaProdutos.size();

				carrinhoFrete = cf.dadosParaFreteDoCarrinho(listaProdutos);

				Double valor = carrinhoFrete.getTotal();
				carrinho.setTotal(valor);
				try {
					Double altura = carrinhoFrete.getAlturaTotal();
					Double largura = carrinhoFrete.getLarguraTotal();
					Double comprimento = carrinhoFrete.getComprimentoTotal();
					Double peso = carrinhoFrete.getPesoTotal();
					mapFretes = FreteCalculoFactory.mapFrete(cepDestino,
							altura, largura, comprimento, peso, valor);
					System.out.println("TESTANDO");
				} catch (CorreiosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			carrinho = new Carrinho();
			carrinho.setEmailUsuario(emailUsuario);
			carrinho.setTotal(0D);
			carrinho.setTotalComFreteCalculado(0D);

			carrinhoRepositorio.save(carrinho);

		}
		model.addAttribute("listaProdutos", listaProdutos);
		model.addAttribute("carrinho", carrinho);
		model.addAttribute("usuario", usuario);
		model.addAttribute("quantidadeItensCarrinho", quantidadeItensCarrinho);

		return "carrinho/paginaCarrinho";

	}

	@RequestMapping(method = RequestMethod.POST, value = "{idCarrinho}")
	public String inserirProdutoNoCarrinho(
			@Valid @ModelAttribute Produto produto, Model model,
			@PathVariable Long idCarrinho, Integer quantidade) {

		Carrinho carrinho = new Carrinho();

		ProdutoCarrinhoFactory pcf = new ProdutoCarrinhoFactory();

		carrinho = carrinhoRepositorio.findOne(idCarrinho);
		ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
		produtoCarrinho.setCarrinho(carrinho);
		produtoCarrinho.setProduto(produto);
		produtoCarrinho.setQuantidade(quantidade);
		produtoCarrinho.setTotal(pcf
				.valorTotalDoProdutoPelaQuantidade(produtoCarrinho));

		produtoCarrinhoRepositorio.save(produtoCarrinho);

		return "carrinho/paginaCarrinho";

	}

}
