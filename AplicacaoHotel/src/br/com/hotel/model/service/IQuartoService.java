package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Quarto;

public interface IQuartoService {
	
	@ValidateOnExecution
	Quarto salvar(@Valid Quarto estado);

	void atualizar(Quarto estado);

	void excluir(Integer codigo);
	
	List<Quarto> buscarTodos();
	
	public Quarto buscarPorId(Integer codigo);
}
