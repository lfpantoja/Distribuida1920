package com.distribuida.gateway.service;

import java.util.List;

import com.distribuida.gateway.model.Album;
import com.distribuida.gateway.model.Singer;

public interface ServiceGateway {
	public Album getAlbum(Integer id);
	public List<Album> listAlbums();
	
	public Singer getSinger(Integer id);
	public List<Singer> listSingers();
}
