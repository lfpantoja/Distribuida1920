package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Singer;

public interface ServicioSinger {

	public List<Singer> listar( );
	public Singer buscar( Integer id );
	
	public void addSinger(Singer e);
	public void deleteSinger(Integer id);
}
