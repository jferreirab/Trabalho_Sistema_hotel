package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Estado;

@Model
public class EstadoDao implements IEstadoDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public void salvar(Estado estado) {
		entityManager.persist(estado);
	}
	

	@Override
	@Transactional
	public void atualizar(Estado estado) {
		Estado merge = entityManager.merge(estado);
		entityManager.persist(merge);
	}

	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Estado merge = entityManager.merge(new Estado(id));
		entityManager.remove(merge);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Estado> buscar(Estado estado) {
		Query query = entityManager.createQuery("from Estado");
		return query.getResultList();
	}

	public Estado buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Estado where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Estado)query.getSingleResult();
	}
}
