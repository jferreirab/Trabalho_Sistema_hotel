package br.com.hotel.model.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.hotel.model.domain.Produto;

@Model
public class ProdutoDao implements IProdutoDao {
	
	@PersistenceContext(unitName="AplicacaoHotelPU")
	private EntityManager entityManager;	
	
	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		entityManager.persist(produto);
		return produto;
	}	

	@Override
	@Transactional
	public void atualizar(Produto produto) {
		Produto merge = entityManager.merge(produto);
		entityManager.persist(merge);
	}
	
	@Override
	@Transactional
	public void excluir(Integer id) {
		Produto merge = entityManager.merge(new Produto(id));
		entityManager.remove(merge);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> buscar(Produto produto) {
		Query query = entityManager.createQuery("from Produto");
		return query.getResultList();
	}

	public Produto buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Produto where codigo = :codigo");
		query.setParameter("codigo",id);
		return (Produto)query.getSingleResult();
	}
}
