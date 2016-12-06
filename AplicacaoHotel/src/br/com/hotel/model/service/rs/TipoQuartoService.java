package br.com.hotel.model.service.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hotel.model.domain.TipoQuarto;
import br.com.hotel.model.service.ITipoQuarto;

@Path("/tipoQuarto")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TipoQuartoService implements ITipoQuarto {

	@Override
	@GET
	public TipoQuarto[] buscarTodos() {
		return TipoQuarto.values();
	}
}
