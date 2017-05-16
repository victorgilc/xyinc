package br.com.xyinc.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.xyinc.bo.PoiBo;
import br.com.xyinc.dto.PoiDto;
import br.com.xyinc.dto.converters.PoiDtoConverter;
import br.com.xyinc.entity.Poi;
import br.com.xyinc.filter.PoiFilter;

@Path("/poiEndpoint")
public class PoiEndpoint {
	
	@Inject
	private PoiBo poiBO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarPois")
	public Response listarPois() {
		List<PoiDto> dtoList = poiBO.listarPois().stream().map(s->PoiDtoConverter.convertToDto(s)).collect(Collectors.toList());
		
		return Response.status(200).entity(dtoList).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarPoisProximidade")
	public Response listarPoisProximidade(@QueryParam("coordenadaX")Long coordenadaX, 
			@QueryParam("coordenadaY")Long coordenadaY, @QueryParam("dMax")Long dMax) {
		
		PoiFilter filter = new PoiFilter(coordenadaX,coordenadaY,dMax);
		
		List<PoiDto> dtoList = poiBO.listarPoisProximidade(filter).stream().map(s->PoiDtoConverter.convertToDto(s)).collect(Collectors.toList());
		
		return Response.status(200).entity(dtoList).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public Response cadastrar(PoiDto poiDto) {
		
		Poi entity = PoiDtoConverter.convertToEntity(poiDto);
		
		poiBO.salvar(entity);
		
		return Response.status(200).entity(Void.class).build();
	}
	
}
