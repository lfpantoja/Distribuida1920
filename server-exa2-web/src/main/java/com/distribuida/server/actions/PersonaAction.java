package com.distribuida.server.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.server.model.Persona;
import com.distribuida.server.service.ServicioPersona;

@SessionScoped
@Named("personaAction")
public class PersonaAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioPersona servicio;

	private List<Persona> personas;
	private Persona personaSeleccionado;

	public List<Persona> getPersonas() {
		return personas;
	}

	public Persona getPersonaSeleccionado() {
		return personaSeleccionado;
	}

	public String iniciar() {
		personas = servicio.listar();
		return "personas";
	}

	public String detalle(Persona dto) {
		personaSeleccionado = servicio.buscar(dto.getId());
		return "persona-detalle";
	}
}
