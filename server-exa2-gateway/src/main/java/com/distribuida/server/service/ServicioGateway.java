package com.distribuida.server.service;

import java.util.List;
import com.distribuida.server.model.Direccion;
import com.distribuida.server.model.Persona;

public interface ServicioGateway {
	public Persona getPersona(Integer id);
	public List<Persona> listPersonas();
	
	public Direccion getDireccion(Integer id);
	public List<Direccion> listDirecciones();
}

