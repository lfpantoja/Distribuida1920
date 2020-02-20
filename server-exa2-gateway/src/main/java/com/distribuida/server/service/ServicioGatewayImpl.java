package com.distribuida.server.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.server.model.Direccion;
import com.distribuida.server.model.Persona;

@ApplicationScoped
public class ServicioGatewayImpl implements ServicioGateway{
	
	@Inject private ServicePersona servicioP;
	@Inject private ServiceDireccion servicioD;
	@Override
	public Persona getPersona(Integer id) {
		return servicioP.getPersona(id);
	}
	@Override
	public List<Persona> listPersonas() {
		return servicioP.listPersonas();
	}
	@Override
	public Direccion getDireccion(Integer id) {
		return servicioD.getDireccion(id);
	}
	@Override
	public List<Direccion> listDirecciones() {
		return servicioD.listDirecciones();
	}
	
	
	
}
