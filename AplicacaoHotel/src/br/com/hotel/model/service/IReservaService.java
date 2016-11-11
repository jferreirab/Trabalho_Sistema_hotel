package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.PathParam;

import br.com.hotel.model.domain.Reserva;

public interface IReservaService {
    
	@ValidateOnExecution
	public Reserva salvar(@Valid Reserva reserva);
	public void atualizar(Reserva reserva);
	public void excluir(@PathParam("codigo") Integer codigo);
	public Reserva buscarPorId(@PathParam("codigo") Integer codigo);
	public List<Reserva> buscarTodos();
}
