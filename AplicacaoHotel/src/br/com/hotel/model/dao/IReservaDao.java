package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Reserva;

public interface IReservaDao {

	public Reserva salvar(Reserva reserva);
	public void atualizar(Reserva reserva);
	public void excluir(Integer id);
	public List<Reserva> buscar(Reserva reserva);
	public Reserva buscarPorId(Integer id);
}
