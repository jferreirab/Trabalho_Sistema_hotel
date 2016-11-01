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

import br.com.hotel.model.dao.IReservaDao;
import br.com.hotel.model.domain.Reserva;
import br.com.hotel.model.service.IReservaService;

@Path("/reserva")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ReservaService implements IReservaService {

	@Inject
	private IReservaDao reservaDao;

	@Override
	@POST
	public Reserva salvar(Reserva reserva) {
		return reservaDao.salvar(reserva);
	}

	@Override
	@PUT
	public void atualizar(Reserva reserva) {
		reservaDao.atualizar(reserva);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		reservaDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Reserva buscarPorId(@PathParam("codigo") Integer codigo) {
		return reservaDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Reserva> buscarTodos() {
		return reservaDao.buscar(new Reserva());
	}
}
