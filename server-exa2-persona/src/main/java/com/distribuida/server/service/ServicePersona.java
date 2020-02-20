package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Persona;

public interface ServicePersona{
	public Persona getPersona(Integer id);
	public List<Persona> listPersonas();
	
//	public Persona addPersona(Persona e);
//	public void deletePersona(Integer id);
//	public Persona updatePersona(Integer id, Persona e);
}
