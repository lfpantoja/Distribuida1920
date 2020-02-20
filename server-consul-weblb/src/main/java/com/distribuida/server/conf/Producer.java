package com.distribuida.server.conf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.distribuida.server.model.Album;
import com.distribuida.server.model.Singer;
import com.distribuida.server.service.ServicioAlbum;
import com.distribuida.server.service.ServicioSinger;

@ApplicationScoped
public class Producer {

	private String URL;
	
	@Inject
	ListInstances in;
	
	@Produces
	@ApplicationScoped
	public ServicioSinger servicioSinger() {
		
		return new ServicioSinger() {

			@Override
			public List<Singer> listar() {
				URL=in.instanciasS();
				return Arrays.asList(RibbonUtil.listarSingers(URL));
			}

			@Override
			public Singer buscar(Integer id) {
				URL=in.instanciasS();
				return RibbonUtil.buscarSinger(id, URL);
			}

			@Override
			public void addSinger(Singer e) {
				URL=in.instanciasS();
				RibbonUtil.addSinger(URL, e);
			}

			@Override
			public void deleteSinger(Integer id) {
				URL=in.instanciasS();
				RibbonUtil.deleteSinger(URL, id);
				
			}
		};
	}

	@Produces
	@ApplicationScoped
	public ServicioAlbum servicioAlbum() {

		return new ServicioAlbum() {

			@Override
			public List<Album> listar() {
				URL = in.instanciasA();
				return Arrays.asList(RibbonUtil.listarAlbums(URL));
			}

			@Override
			public Album buscar(Integer id) {
				URL=in.instanciasA();
				return RibbonUtil.buscarAlbum(id, URL);
			}

			@Override
			public void addAlbum(Album e) {
				URL=in.instanciasA();
				RibbonUtil.addAlbum(URL, e);
			}

			@Override
			public void deleteAlbum(Integer id) {
				URL=in.instanciasA();
				RibbonUtil.deleteAlbum(URL, id);
				
			}

		};
	}
}
