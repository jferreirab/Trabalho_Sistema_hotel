package br.com.hotel.model.service.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hotel.model.dao.IProdutoDao;
import br.com.hotel.model.domain.Produto;
import br.com.hotel.model.service.IProdutoService;

@Path("/produto")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProdutoService implements IProdutoService {

	@Inject
	private IProdutoDao produtoDao;

	@Override
	@POST
	public Produto salvar(Produto produto) {
		return produtoDao.salvar(produto);
	}

	@Override
	@PUT
	public void atualizar(Produto produto) {
		produtoDao.atualizar(produto);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		produtoDao.excluir(codigo);
	}

	@GET
	@Override
	@Path("/{codigo}")
	public Produto buscarPorId(@PathParam("codigo") Integer codigo) {
		return produtoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Produto> buscarTodos() {
		return produtoDao.buscar(new Produto());
	}

}
