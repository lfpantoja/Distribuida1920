package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Album;

public interface ServicioAlbum {
	public List<Album> listar( );
	public Album buscar( Integer id );
}
