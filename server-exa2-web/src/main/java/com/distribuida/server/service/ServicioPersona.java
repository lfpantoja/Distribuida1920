package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Persona;

public interface ServicioPersona {
	public List<Persona> listar( );
	public Persona buscar( Integer id );
}
