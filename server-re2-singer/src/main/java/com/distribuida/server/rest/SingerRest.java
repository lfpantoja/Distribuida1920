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

@Path("/")
@ApplicationScoped
public class SingerRest {
	
	@Inject 
	private ServiceSinger servicio;
	
	@GET
	@Path("/singer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listar(){
		List<Singer> singers = servicio.listSingers();
		singers = servicio.listSingers();
		//Singer[] arrayS = new Singer[singers.size()];
		//arrayS = singers.toArray(arrayS);
		//return arrayS;
		return singers;
	}
	
	@GET
	@Path("/singer/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam("id") Integer id) {
		Singer singer = servicio.getSinger(id);
		return singer;
	}
	
	@GET
	@Path("/ping")
	@Produces(value=MediaType.APPLICATION_JSON)
	public String ping() {
		return "ok";
	}
	
}
