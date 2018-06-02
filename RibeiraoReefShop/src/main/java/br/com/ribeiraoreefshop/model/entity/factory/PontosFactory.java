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

	GenericDAOFactory genericDAOFactory = new GenericDAOFactory();

	public void configurarPontos(Integer pontos, Double valor,
			Integer pontosResgate, Double valorResgate,
			EntityManager entityManager) throws Exception {

		Pontos ponto = new Pontos();
		genericDAOFactory = new GenericDAOFactory();
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

	public Double valorDoPonto(Pontos pontos) {
		Double result = 0D;

		Integer pontosResgate = 0;
		Double valorTotalResgate = 0D;

		pontosResgate = pontos.getPontosResgate();
		valorTotalResgate = pontos.getValorResgate();

		result = valorTotalResgate / pontosResgate;

		return result;

	}

	/**
	 * 
	 * @param ativar
	 *            (0=Desabilita, 1=habilita)
	 * @param pontos
	 * @param valor
	 * @param pontosResgate
	 * @param valorResgate
	 * @param entityManager
	 * @throws Exception
	 */
	public void ativacaoPontos(Integer ativar, Integer pontos, Double valor,
			Integer pontosResgate, Double valorResgate,
			EntityManager entityManager) throws Exception {
		if (ativar == null) {
			ativar = 0;
		}
		Pontos pontosConfig = new Pontos();
		genericDAOFactory = new GenericDAOFactory();

		if (ativar == 1) {
			configurarPontos(pontos, valor, pontosResgate, valorResgate,
					entityManager);
		} else {
			pontosConfig = (Pontos) genericDAOFactory.readAllActives(
					pontosConfig, entityManager);
			genericDAOFactory.delete(pontosConfig, entityManager);
		}
		assegurarUmUnicoRegistroAtivo(entityManager);

	}

	public void assegurarUmUnicoRegistroAtivo(EntityManager entityManager)
			throws Exception {

		Pontos pontos = new Pontos();
		genericDAOFactory = new GenericDAOFactory();
		List<AEntity> listaPontos = new ArrayList<AEntity>();
		List<AEntity> listaPontosAtivos = new ArrayList<AEntity>();

		listaPontos = genericDAOFactory.readAll(pontos, entityManager);
		if (listaPontos.size() == 1) {
			pontos = (Pontos) listaPontos.get(0);
			if (pontos.getDataDesativacao() != null) {
				pontos.setDataDesativacao(null);
				genericDAOFactory.update(pontos, entityManager);
			}
		}

		if (listaPontos.size() == 0) {
			configurarPontos(0, 0D, 0, 0D, entityManager);
		}

		listaPontosAtivos = genericDAOFactory.readAllActives(pontos,
				entityManager);
		if (listaPontosAtivos.size() > 1) {
			for (AEntity aEntity : listaPontosAtivos) {
				pontos = (Pontos) aEntity;
				genericDAOFactory.delete(pontos, entityManager);
			}
			configurarPontos(0, 0D, 0, 0D, entityManager);
		}

	}

}
