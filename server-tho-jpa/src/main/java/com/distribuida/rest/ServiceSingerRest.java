package com.distribuida.rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

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

import com.distribuida.model.Singer;
import com.distribuida.service.ServiceSinger;

@Path("/singers")
@ApplicationScoped
public class ServiceSingerRest {
	
	@Inject 
	private ServiceSinger servicio;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Singer> listar(){
		System.out.println("**************************rest1");
		List<Singer> a = new ArrayList<Singer>();
		a = servicio.listSingers();
		return null;
	}
	
	@POST
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Singer addSinger(Singer e) {
		return servicio.addSinger(e);
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam(value = "id") Integer id) {
		Singer singer = new Singer();
		singer.setId(servicio.getSinger(id).getId());
		singer.setFirstName(servicio.getSinger(id).getFirstName());
		singer.setLastName(servicio.getSinger(id).getLastName());
		singer.setBirthDate(servicio.getSinger(id).getBirthDate());
		//singer =servicio.getSinger(id)
		return singer;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteSinger(@PathParam(value = "id") Integer id) {
		servicio.deleteSinger(id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Singer updateSinger(Singer e) {
		return servicio.updateSinger(e);
	}
}
