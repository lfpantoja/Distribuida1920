package com.distribuida.server.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.server.model.Persona;
import com.distribuida.server.service.ServicePersona;

@Path("/personas")
@ApplicationScoped
public class PersonaRest {
	
	@Inject	private ServicePersona servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona[] listar(){
		List<Persona> personas = servicio.listPersonas();
		Persona[] arrayP = new Persona[personas.size()];
		arrayP = personas.toArray(arrayP);
		return arrayP;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Persona getPersona(@PathParam(value = "id") Integer id) {
		Persona persona = new Persona();
		
		persona.setId(servicio.getPersona(id).getId());
		persona.setCedula(servicio.getPersona(id).getCedula());
		persona.setDireccion(servicio.getPersona(id).getDireccion());
		persona.setTipoDireccion(servicio.getPersona(id).getTipoDireccion());
		persona.setNombre(servicio.getPersona(id).getNombre());
		
		return persona;
	}

}
