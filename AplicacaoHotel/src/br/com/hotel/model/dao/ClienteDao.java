package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Cliente;

@Model
public class ClienteDao implements IClienteDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public void salvar(Cliente cliente) {
		entityManager.persist(cliente);
	}
	

	@Override
	@Transactional
	public void atualizar(Cliente cliente) {
		Cliente merge = entityManager.merge(cliente);
		entityManager.persist(merge);
	}

	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Cliente merge = entityManager.merge(new Cliente(id));
		entityManager.remove(merge);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> buscar(Cliente cliente) {
		Query query = entityManager.createQuery("from Cliente");
		return query.getResultList();
	}

	public Cliente buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Cliente where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Cliente)query.getSingleResult();
	}
}
