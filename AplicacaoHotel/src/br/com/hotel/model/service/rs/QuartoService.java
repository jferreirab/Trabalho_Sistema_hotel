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

import br.com.hotel.model.dao.IQuartoDao;
import br.com.hotel.model.domain.Quarto;
import br.com.hotel.model.service.IQuartoService;

@Path("/quarto")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class QuartoService implements IQuartoService{
	
	
		
		@Inject
		private IQuartoDao quartoDao;

		@Override
		@POST
		public Quarto salvar(Quarto quarto) {
			return quartoDao.salvar(quarto);
		}

		@Override
		@PUT
		public void atualizar(Quarto quarto) {
			quartoDao.atualizar(quarto);
		}

		@Override
		@DELETE
		@Path("/{codigo}")
		public void excluir(@PathParam("codigo") Integer codigo) {
			quartoDao.excluir(codigo);
		}
		
		@GET
		@Override
		@Path("/{codigo}")
		public Quarto buscarPorId(@PathParam("codigo") Integer codigo) {
			return quartoDao.buscarPorId(codigo);
		}

		@Override
		@GET
		public List<Quarto> buscarTodos() {
			return quartoDao.buscar(new Quarto());
		}
		
		/*@GET
		@Override
		@Path("/desc/[reserva]")
		public List<Quarto> buscaQuartoLivre(@PathParam("reserva" ) Reserva reserva ){
			//Reserva reserva = new Reserva();
			return quartoDao.buscaQuartoLivre(reserva);
		}*/

}
