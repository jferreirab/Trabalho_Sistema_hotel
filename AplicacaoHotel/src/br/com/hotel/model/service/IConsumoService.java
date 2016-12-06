package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Consumo;

public interface IConsumoService {
	
	@ValidateOnExecution
	Consumo salvar(@Valid Consumo consumo);
	void atualizar(Consumo consumo);
	void excluir(Integer codigo);	
	List<Consumo> buscarTodos();	
	public Consumo buscarPorId(Integer codigo);
}
