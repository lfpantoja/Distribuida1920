package com.distribuida.service;

import java.util.List;

import com.distribuida.model.Album;

public interface ServiceAlbum {
	public Album addAlbum(Album e);
	public void deleteAlbum(Integer id);
	public Album getAlbum(Integer id);
	public List<Album> listAlbums();
	public Album updateAlbum(Album e);
}
