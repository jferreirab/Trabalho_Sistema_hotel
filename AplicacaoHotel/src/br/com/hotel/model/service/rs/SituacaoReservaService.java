package br.com.hotel.model.service.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hotel.model.domain.SituacaoReserva;
import br.com.hotel.model.service.ISituacaoReservaService;

@Path("/situacaoReserva")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class SituacaoReservaService implements ISituacaoReservaService {
	@Override
	@GET
	public SituacaoReserva[] buscarTodos() {
		return SituacaoReserva.values();
	}
	
}
