package br.com.hotel.model.service;

import java.util.List;

import br.com.hotel.model.domain.Cidade;

public interface ICidadeService {
     
	void salvar(Cidade cidade);

	void atualizar(Cidade cidade);

	void excluir(Integer codigo);
	
	List<Cidade> buscarTodos();
	
	public Cidade buscarPorId(Integer codigo);
}
