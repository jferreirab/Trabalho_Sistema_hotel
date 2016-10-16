package br.com.hotel.model.service;

import java.util.List;

import br.com.hotel.model.domain.Estado;

public interface IEstadoService {
	
	void salvar(Estado estado);

	void atualizar(Estado estado);

	void excluir(Integer codigo);
	
	List<Estado> buscarTodos();
	
	public Estado buscarPorId(Integer codigo);
}
