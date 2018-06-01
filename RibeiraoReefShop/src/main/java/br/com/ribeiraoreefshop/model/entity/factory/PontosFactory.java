/**
 * 
 */
package br.com.ribeiraoreefshop.model.entity.factory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ribeiraoreefshop.dao.factory.GenericDAOFactory;
import br.com.ribeiraoreefshop.model.entity.AEntity;
import br.com.ribeiraoreefshop.model.entity.Pontos;

/**
 * @author Tiago Ferezin
 *
 */
public class PontosFactory {

	public void configurarPontos(Integer pontos, Double valor,
			Integer pontosResgate, Double valorResgate,
			EntityManager entityManager) throws Exception {

		Pontos ponto = new Pontos();
		GenericDAOFactory genericDAOFactory = new GenericDAOFactory();
		List<AEntity> listaEntity = new ArrayList<AEntity>();
		listaEntity = genericDAOFactory.readAllActives(ponto, entityManager);

		if (listaEntity.size() > 0) {
			ponto = (Pontos) listaEntity.get(listaEntity.size() - 1);
		}

		ponto.setPontos(pontos);
		ponto.setPontosResgate(pontosResgate);
		ponto.setValor(valor);
		ponto.setValorResgate(valorResgate);

		if ((ponto.getIdPontos() != null) && (ponto.getIdPontos() > 0L)) {
			genericDAOFactory.update(ponto, entityManager);
		} else {
			genericDAOFactory.create(ponto, entityManager);
		}

	}

}
