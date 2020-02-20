package com.distribuida.gateway.service;

import java.util.List;

import com.distribuida.gateway.model.Album;

public interface ServiceAlbum {
	public Album getAlbum(Integer id);
	public List<Album> listAlbums();
}
