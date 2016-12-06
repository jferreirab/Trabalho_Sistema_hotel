package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Consumo;

@Model
public class ConsumoDao implements IConsumoDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;	
	
	@Override
	@Transactional
	public Consumo salvar(Consumo consumo) {
		entityManager.persist(consumo);
		return consumo;
	}	

	@Override
	@Transactional
	public void atualizar(Consumo consumo) {
		Consumo merge = entityManager.merge(consumo);
		entityManager.persist(merge);
	}
	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Consumo merge = entityManager.merge(new Consumo(id));
		entityManager.remove(merge);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Consumo> buscar(Consumo consumo) {
		Query query = entityManager.createQuery("from Consumo");
		return query.getResultList();
	}

	public Consumo buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Consumo where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Consumo)query.getSingleResult();
	}
}
