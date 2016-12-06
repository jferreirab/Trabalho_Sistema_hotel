package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Quarto;

public interface IQuartoDao {

	
	public Quarto salvar(Quarto estado);
	public void atualizar(Quarto estado);
	public void excluir(Integer id) ;
	public List<Quarto> buscar(Quarto estado) ;
	public Quarto buscarPorId(Integer id);
}
