package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Reserva;

@Model
public class ReservaDao implements IReservaDao {

	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;
		
	@Override
	@Transactional
	public void salvar(Reserva reserva) {
		entityManager.persist(reserva);
	}
	

	@Override
	@Transactional
	public void atualizar(Reserva reserva) {
		Reserva merge = entityManager.merge(reserva);
		entityManager.persist(merge);
	}

	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Reserva merge = entityManager.merge(new Reserva(id));
		entityManager.remove(merge);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Reserva> buscar(Reserva reserva) {
		Query query = entityManager.createQuery("from Reserva");
		return query.getResultList();
	}

	public Reserva buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Reserva where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Reserva)query.getSingleResult();
	}
}
