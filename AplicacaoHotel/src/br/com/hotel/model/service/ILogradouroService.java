package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Logradouro;

public interface ILogradouroService {
  
	@ValidateOnExecution
	Logradouro salvar(@Valid Logradouro logradouro);

	void atualizar(Logradouro logradouro);

	void excluir(Integer codigo);
	
	List<Logradouro> buscarTodos();
	
	public Logradouro buscarPorId(Integer codigo);

	List<Logradouro> buscarPelaDescricao(String nome);
}
