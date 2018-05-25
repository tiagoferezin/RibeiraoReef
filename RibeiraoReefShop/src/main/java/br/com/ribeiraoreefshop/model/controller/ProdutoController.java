/**
 * 
 */
package br.com.ribeiraoreefshop.model.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ribeiraoreefshop.anotacao.AcessoPublico;
import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.Produto;
import br.com.ribeiraoreefshop.model.entity.factory.ProdutoFactory;

/**
 * @author Tiago Ferezin
 *
 */
@Controller
@Path("/produto")
public class ProdutoController {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Result result;

	private GenericDAOFactory genericDAOFactory = new GenericDAOFactory();

	@Path("/adicionaProduto/{produto}")
	public void adicionaProduto(Produto produto) {
		genericDAOFactory = new GenericDAOFactory();
		try {
			genericDAOFactory.create(produto, this.entityManager);

			result.redirectTo(ProdutoController.class).listar();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Get({ "/editar/{idProduto}", "/editar/novo" })
	public void editar(Long idProduto) {
		genericDAOFactory = new GenericDAOFactory();
		Produto produto = new Produto();
		if ((idProduto != null) && (idProduto > 0L)) {
			try {
				produto = (Produto) genericDAOFactory.readPorId(produto,
						this.entityManager, idProduto);
				result.redirectTo("/produto/listar");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@AcessoPublico
	@Post("/listar")
	public List<Produto> listar() {
		genericDAOFactory = new GenericDAOFactory();
		Produto produto = new Produto();
		ProdutoFactory pf = new ProdutoFactory();
		List<Produto> lista = new ArrayList<Produto>();

		try {
			lista = pf.listarProdutosAtivos(this.entityManager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}
