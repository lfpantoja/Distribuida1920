package com.distribuida.server.service;

import java.util.List;

import com.distribuida.server.model.Album;

public interface ServiceAlbum{
	public Album getAlbum(Integer id);
	public List<Album> listAlbums();
}
