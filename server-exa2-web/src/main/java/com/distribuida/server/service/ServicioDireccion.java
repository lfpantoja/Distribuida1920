package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Direccion;

public interface ServicioDireccion {
	public List<Direccion> listar( );
	public Direccion buscar( Integer id );
}
