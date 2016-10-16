package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Estado;

public interface IEstadoDao {

	
	public void salvar(Estado estado);
	public void atualizar(Estado estado);
	public void excluir(Integer id) ;
	public List<Estado> buscar(Estado estado) ;
	public Estado buscarPorId(Integer id);
}
