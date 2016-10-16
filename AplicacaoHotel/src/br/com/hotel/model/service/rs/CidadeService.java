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

import br.com.hotel.model.dao.ICidadeDao;
import br.com.hotel.model.domain.Cidade;
import br.com.hotel.model.service.ICidadeService;

@Path("/cidade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CidadeService implements ICidadeService{

	
	@Inject
	private ICidadeDao cidadeDao;

	@Override
	@POST
	public void salvar(Cidade cidade) {
		cidadeDao.salvar(cidade);
	}

	@Override
	@PUT
	public void atualizar(Cidade cidade) {
		cidadeDao.atualizar(cidade);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		cidadeDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Cidade buscarPorId(@PathParam("codigo") Integer codigo) {
		return cidadeDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Cidade> buscarTodos() {
		return cidadeDao.buscar(new Cidade());
	}
}
