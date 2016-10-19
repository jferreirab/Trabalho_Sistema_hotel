package br.com.hotel.model.dao;

import java.util.List;

import br.com.hotel.model.domain.Logradouro;

public interface ILogradouroDao {
 
	void salvar(Logradouro logradouro);

	void atualizar(Logradouro logradouro);

	void excluir(Integer id);

	List<Logradouro> buscar(Logradouro logradouro);

	Logradouro buscarPorId(Integer id);

	List<Logradouro> buscarPelaDescricao(String nome);
}
