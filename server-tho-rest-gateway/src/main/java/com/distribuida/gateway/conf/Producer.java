package com.distribuida.gateway.conf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.distribuida.gateway.model.Album;
import com.distribuida.gateway.model.Singer;
import com.distribuida.gateway.service.ServiceAlbum;
import com.distribuida.gateway.service.ServiceSinger;

@ApplicationScoped
public class Producer {

	private String URL;
	
	@Inject
	InstanciasActivas in;
	
	@Produces
	@ApplicationScoped
	public ServiceAlbum serviceAlbum() {
		
		return new ServiceAlbum() {
			
			@Override
			public Album getAlbum(Integer id) {
				URL=in.instanciasA();
				return RibbonUtil.buscarAlbum(id, URL);
			}

			@Override
			public List<Album> listAlbums() {
				URL=in.instanciasA();
				return Arrays.asList(RibbonUtil.listarAlbums(URL));
			}

		};
	}

	@Produces
	@ApplicationScoped
	public ServiceSinger serviceSinger() {

		return new ServiceSinger() {

			@Override
			public Singer getSinger(Integer id) {
				URL=in.instanciasS();
				return RibbonUtil.buscarSinger(id, URL);
			}

			@Override
			public List<Singer> listSingers() {
				URL = in.instanciasS();
				return Arrays.asList(RibbonUtil.listarSingers(URL));
			}

		};
	}
}
