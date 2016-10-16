package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Cliente;

public interface IClienteDao {
	
	void salvar(Cliente cliente);

	void atualizar(Cliente cliente);

	void excluir(Integer id);

	List<Cliente> buscar(Cliente cliente);

	Cliente buscarPorId(Integer id);
}
