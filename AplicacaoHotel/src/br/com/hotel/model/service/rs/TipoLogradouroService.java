package br.com.hotel.model.service.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hotel.model.domain.TipoLogradouro;
import br.com.hotel.model.service.ITipoLogradouro;

@Path("/tipoLogradouro")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TipoLogradouroService implements ITipoLogradouro {

	@Override
	@GET
	public TipoLogradouro[] buscarTodos() {
		return TipoLogradouro.values();
	}
}
