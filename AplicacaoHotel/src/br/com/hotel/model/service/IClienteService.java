package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Cliente;



public interface IClienteService {
    
	@ValidateOnExecution
	Cliente salvar(@Valid Cliente cliente);

	void atualizar(Cliente cliente);

	void excluir(Integer codigo);
	
	List<Cliente> buscarTodos();
	
	public Cliente buscarPorId(Integer codigo);
}
