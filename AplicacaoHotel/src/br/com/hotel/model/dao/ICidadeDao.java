package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Cidade;

public interface ICidadeDao {
	public void salvar(Cidade cidade);
	public void atualizar(Cidade cidade);
	public void excluir(Integer id) ;
	public List<Cidade> buscar(Cidade cidade) ;
	public Cidade buscarPorId(Integer id);
}
