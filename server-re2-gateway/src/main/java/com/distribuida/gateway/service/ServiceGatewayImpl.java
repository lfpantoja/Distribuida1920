package com.distribuida.gateway.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.gateway.model.Album;
import com.distribuida.gateway.model.Singer;

@ApplicationScoped
public class ServiceGatewayImpl implements ServiceGateway{
	
	@Inject private ServiceAlbum servicioA;
	@Inject private ServiceSinger servicioS;
	
	@Override
	public Album getAlbum(Integer id) {
		return servicioA.getAlbum(id);
	}
	@Override
	public List<Album> listAlbums() {
		return servicioA.listAlbums();
	}
	
	
	@Override
	public Singer getSinger(Integer id) {
		return servicioS.getSinger(id);
	}
	@Override
	public List<Singer> listSingers() {
		return servicioS.listSingers();
	}
	
}
