package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Cliente;

public interface IClienteDao {
	
	public Cliente salvar(Cliente cliente);

	public void atualizar(Cliente cliente);

	public void excluir(Integer id);

	public List<Cliente> buscar(Cliente cliente);

	public Cliente buscarPorId(Integer id);
}
