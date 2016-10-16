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

import br.com.hotel.model.dao.IEstadoDao;
import br.com.hotel.model.domain.Estado;
import br.com.hotel.model.service.IEstadoService;

@Path("/estado")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class EstadoService implements IEstadoService{
	
	
		
		@Inject
		private IEstadoDao estadoDao;

		@Override
		@POST
		public void salvar(Estado estado) {
			estadoDao.salvar(estado);
		}

		@Override
		@PUT
		public void atualizar(Estado estado) {
			estadoDao.atualizar(estado);
		}

		@Override
		@DELETE
		@Path("/{codigo}")
		public void excluir(@PathParam("codigo") Integer codigo) {
			estadoDao.excluir(codigo);
		}
		
		@GET
		@Override
		@Path("/{codigo}")
		public Estado buscarPorId(@PathParam("codigo") Integer codigo) {
			return estadoDao.buscarPorId(codigo);
		}

		@Override
		@GET
		public List<Estado> buscarTodos() {
			return estadoDao.buscar(new Estado());
		}

}
