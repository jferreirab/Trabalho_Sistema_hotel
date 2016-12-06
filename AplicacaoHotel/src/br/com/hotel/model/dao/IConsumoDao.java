package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Consumo;

public interface IConsumoDao {

	
	public Consumo salvar(Consumo consumo);
	public void atualizar(Consumo consumo);
	public void excluir(Integer id) ;
	public List<Consumo> buscar(Consumo consumo) ;
	public Consumo buscarPorId(Integer id);
}
