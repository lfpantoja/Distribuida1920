package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Persona;

public interface ServicePersona {
	public Persona getPersona(Integer id);
	public List<Persona> listPersonas();
	
}
