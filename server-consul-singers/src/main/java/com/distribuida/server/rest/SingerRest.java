package com.distribuida.server.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.server.model.Singer;
import com.distribuida.server.service.ServiceSinger;

@Path("/singers")
@ApplicationScoped
public class SingerRest {
	
	@Inject	private ServiceSinger servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Singer[] listar(){
		List<Singer> singers = servicio.listSingers();
		Singer[] arrayS = new Singer[singers.size()];
		arrayS = singers.toArray(arrayS);
		return arrayS;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam(value = "id") Integer id) {
		Singer singer = new Singer();
		
		singer.setId(servicio.getSinger(id).getId());
		singer.setFirstName(servicio.getSinger(id).getFirstName());
		singer.setLastName(servicio.getSinger(id).getLastName());
		singer.setBirthDate(null);
		
		//singer =servicio.getSinger(id)
		return singer;
	}
	
}
