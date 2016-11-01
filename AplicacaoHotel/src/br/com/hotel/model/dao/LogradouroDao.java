package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import br.com.hotel.model.domain.Logradouro;

@Model
public class LogradouroDao implements ILogradouroDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public Logradouro salvar(Logradouro logradouro) {
		entityManager.persist(logradouro);
		return logradouro;
	}
	

	@Override
	@Transactional
	public void atualizar(Logradouro logradouro) {
		Logradouro merge = entityManager.merge(logradouro);
		entityManager.persist(merge);
	}

	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Logradouro merge = entityManager.merge(new Logradouro(id));
		entityManager.remove(merge);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Logradouro> buscar(Logradouro logradouro) {
		Query query = entityManager.createQuery("from Logradouro");
		return query.getResultList();
	}

	public Logradouro buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Logradouro where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Logradouro)query.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Logradouro> buscarPelaDescricao(String nome){
		Query query = entityManager.createQuery("from Logradouro where nomeLogradouro LIKE :nomeLogradouro ");
		
		query.setParameter("nomeLogradouro", "%"+nome+"%");
		 List<Logradouro> temp =query.getResultList();
		 return temp;
	}
}
