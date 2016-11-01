package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Estado;

public interface IEstadoService {
	
	@ValidateOnExecution
	Estado salvar(@Valid Estado estado);

	void atualizar(Estado estado);

	void excluir(Integer codigo);
	
	List<Estado> buscarTodos();
	
	public Estado buscarPorId(Integer codigo);
}
