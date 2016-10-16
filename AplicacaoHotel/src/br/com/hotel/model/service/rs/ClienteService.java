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

import br.com.hotel.model.dao.IClienteDao;
import br.com.hotel.model.domain.Cliente;
import br.com.hotel.model.service.IClienteService;

@Path("/cliente")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ClienteService implements IClienteService {
	
	@Inject
	private IClienteDao clienteDao;

	@Override
	@POST
	public void salvar(Cliente cliente) {
		clienteDao.salvar(cliente);
	}

	@Override
	@PUT
	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		clienteDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Cliente buscarPorId(@PathParam("codigo") Integer codigo) {
		return clienteDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Cliente> buscarTodos() {
		return clienteDao.buscar(new Cliente());
	}

}
