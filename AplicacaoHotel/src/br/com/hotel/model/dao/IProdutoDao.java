package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Produto;

public interface IProdutoDao {

	
	public Produto salvar(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(Integer id) ;
	public List<Produto> buscar(Produto produto) ;
	public Produto buscarPorId(Integer id);
}
