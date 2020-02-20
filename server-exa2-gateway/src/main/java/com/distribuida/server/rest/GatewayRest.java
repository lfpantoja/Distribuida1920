package com.distribuida.server.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.server.model.Direccion;
import com.distribuida.server.model.Persona;
import com.distribuida.server.service.ServiceDireccion;
import com.distribuida.server.service.ServicePersona;

@Path("/")
@ApplicationScoped
public class GatewayRest {
	
	@Inject	private ServicePersona servicioP;
	@Inject	private ServiceDireccion servicioD;
	
	@Path("/personas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona[] listarP(){
		List<Persona> singers = servicioP.listPersonas();
		Persona[] arrayP = new Persona[singers.size()];
		arrayP = singers.toArray(arrayP);
		return arrayP;
	}
	
	@GET
	@Path("/personas/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Persona getPersona(@PathParam(value = "id") Integer id) {
		Persona singer = new Persona();
		
		singer.setId(servicioP.getPersona(id).getId());
		singer.setCedula(servicioP.getPersona(id).getCedula());
		singer.setDireccion(servicioP.getPersona(id).getDireccion());
		singer.setTipoDireccion(Integer.valueOf(servicioP.getPersona(id).getDireccion()));
		singer.setNombre(servicioP.getPersona(id).getNombre());
		
		//singer =servicio.getSinger(id)
		return singer;
	}
	
	@Path("/direcciones")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Direccion[] listarD(){
		List<Direccion> singers = servicioD.listDirecciones();
		Direccion[] arrayP = new Direccion[singers.size()];
		arrayP = singers.toArray(arrayP);
		return arrayP;
	}
	
	@GET
	@Path("/direcciones/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Direccion getDireccion(@PathParam(value = "id") Integer id) {
		Direccion singer = new Direccion();
		
		singer.setId(servicioD.getDireccion(id).getId());
		singer.setDescripcion(servicioD.getDireccion(id).getDescripcion());
		
		//singer =servicio.getSinger(id)
		return singer;
	}
	
}
