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
import com.distribuida.server.service.ServiceDireccion;

@Path("/direcciones")
@ApplicationScoped
public class DireccionRest {
	
	@Inject	private ServiceDireccion servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Direccion[] listar(){
		List<Direccion> direcciones = servicio.listDirecciones();
		Direccion[] arrayD = new Direccion[direcciones.size()];
		arrayD = direcciones.toArray(arrayD);
		return arrayD;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Direccion getDireccion(@PathParam(value = "id") Integer id) {
		Direccion direccion = new Direccion();
		
		direccion.setId(servicio.getDireccion(id).getId());
		direccion.setDescripcion(servicio.getDireccion(id).getDescripcion());
		
		return direccion;
	}

}
