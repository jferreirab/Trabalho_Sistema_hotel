package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Logradouro;

public interface ILogradouroDao {
 
	public Logradouro salvar(Logradouro logradouro);

	public void atualizar(Logradouro logradouro);

	public void excluir(Integer id);

	public List<Logradouro> buscar(Logradouro logradouro);

	public Logradouro buscarPorId(Integer id);

	public List<Logradouro> buscarPelaDescricao(String nome);
}
