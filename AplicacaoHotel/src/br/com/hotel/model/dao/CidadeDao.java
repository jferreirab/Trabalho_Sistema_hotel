package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Cidade;

@Model
public class CidadeDao implements ICidadeDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;
		
	@Override
	@Transactional
	public void salvar(Cidade cidade) {
		entityManager.persist(cidade);
	}
	

	@Override
	@Transactional
	public void atualizar(Cidade cidade) {
		Cidade merge = entityManager.merge(cidade);
		entityManager.persist(merge);
	}

	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Cidade merge = entityManager.merge(new Cidade(id));
		entityManager.remove(merge);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cidade> buscar(Cidade cidade) {
		Query query = entityManager.createQuery("from Cidade");
		return query.getResultList();
	}

	public Cidade buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Cidade where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Cidade)query.getSingleResult();
	}
}
