package com.distribuida.server.conf;

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
				URL = in.instanciasS();
				return Proxy.lSinger(URL);
			}

			@Override
			public Singer buscar(Integer id) {
				URL = in.instanciasS();
				return Proxy.gSinger(URL, id);
			}

			@Override
			public void addSinger(Singer e) {
				URL = in.instanciasS();
				Proxy.aSinger(URL, e);
			}

			@Override
			public void deleteSinger(Integer id) {
				URL = in.instanciasS();
				Proxy.dAlbum(URL, id);
			}

			@Override
			public Singer updateSinger(Singer e) {
				URL = in.instanciasS();
				return Proxy.uSinger(URL, e);
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
				return Proxy.lAlbum(URL);
			}

			@Override
			public Album buscar(Integer id) {
				URL = in.instanciasA();
				return Proxy.gAlbum(URL, id);
			}

			@Override
			public void addAlbum(Album e) {
				URL = in.instanciasA();
				Proxy.aAlbum(URL, e);
			}

			@Override
			public void deleteAlbum(Integer id) {
				URL = in.instanciasA();
				Proxy.dAlbum(URL, id);
			}

			@Override
			public Album updateAlbum(Album e) {
				URL = in.instanciasA();
				return Proxy.uAlbum(URL, e);
			}
		};
	}
}
