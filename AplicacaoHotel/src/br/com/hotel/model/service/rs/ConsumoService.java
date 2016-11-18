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

import br.com.hotel.model.dao.IConsumoDao;
import br.com.hotel.model.domain.Consumo;
import br.com.hotel.model.service.IConsumoService;

@Path("/consumo")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ConsumoService implements IConsumoService {

	@Inject
	private IConsumoDao consumoDao;

	@Override
	@POST
	public Consumo salvar(Consumo consumo) {
		return consumoDao.salvar(consumo);
	}

	@Override
	@PUT
	public void atualizar(Consumo consumo) {
		consumoDao.atualizar(consumo);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		consumoDao.excluir(codigo);
	}

	@GET
	@Override
	@Path("/{codigo}")
	public Consumo buscarPorId(@PathParam("codigo") Integer codigo) {
		return consumoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Consumo> buscarTodos() {
		return consumoDao.buscar(new Consumo());
	}

}
