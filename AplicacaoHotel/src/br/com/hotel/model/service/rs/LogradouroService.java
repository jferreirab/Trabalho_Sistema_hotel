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

import br.com.hotel.model.dao.ILogradouroDao;
import br.com.hotel.model.domain.Logradouro;
import br.com.hotel.model.service.ILogradouroService;

@Path("/logradouro")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class LogradouroService implements ILogradouroService {

	@Inject
	private ILogradouroDao logradouroDao;

	@Override
	@POST
	public void salvar(Logradouro logradouro) {
		logradouroDao.salvar(logradouro);
	}

	@Override
	@PUT
	public void atualizar(Logradouro logradouro) {
		logradouroDao.atualizar(logradouro);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		logradouroDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Logradouro buscarPorId(@PathParam("codigo") Integer codigo) {
		return logradouroDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Logradouro> buscarTodos() {
		return logradouroDao.buscar(new Logradouro());
	}
}
