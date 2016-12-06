package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Quarto;

@Model
public class QuartoDao implements IQuartoDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;	
	
	@Override
	@Transactional
	public Quarto salvar(Quarto quarto) {
		entityManager.persist(quarto);
		return quarto;
	}	

	@Override
	@Transactional
	public void atualizar(Quarto quarto) {
		Quarto merge = entityManager.merge(quarto);
		entityManager.persist(merge);
	}
	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Quarto merge = entityManager.merge(new Quarto(id));
		entityManager.remove(merge);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Quarto> buscar(Quarto quarto) {
		Query query = entityManager.createQuery("from Quarto");
		return query.getResultList();
	}

	public Quarto buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Quarto where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Quarto)query.getSingleResult();
	}
}
