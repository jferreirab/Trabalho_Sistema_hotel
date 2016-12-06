package br.com.hotel.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hotel.model.domain.Produto;

public interface IProdutoService {
	
	@ValidateOnExecution
	Produto salvar(@Valid Produto produto);
	void atualizar(Produto produto);
	void excluir(Integer codigo);	
	List<Produto> buscarTodos();	
	public Produto buscarPorId(Integer codigo);
}
