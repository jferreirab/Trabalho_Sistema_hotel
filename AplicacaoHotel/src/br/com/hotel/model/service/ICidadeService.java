package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Cidade;

public interface ICidadeService {
     
	@ValidateOnExecution
	Cidade salvar(@Valid Cidade cidade);

	void atualizar(Cidade cidade);

	void excluir(Integer codigo);
	
	List<Cidade> buscarTodos();
	
	public Cidade buscarPorId(Integer codigo);
}
