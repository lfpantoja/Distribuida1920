package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Direccion;

public interface ServiceDireccion{
	public Direccion getDireccion(Integer id);
	public List<Direccion> listDirecciones();
	
}
