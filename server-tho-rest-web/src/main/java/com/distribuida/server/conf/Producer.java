package com.distribuida.server.conf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.server.model.Singer;
import com.distribuida.server.model.Album;
import com.distribuida.server.service.ServicioAlbum;
import com.distribuida.server.service.ServicioSinger;

@ApplicationScoped
public class Producer {

	public static final String URL_S = "http://127.0.0.1:9095/singers";
	public static final String URL_A = "http://127.0.0.1:9095/albums";
	
	@Produces
	@ApplicationScoped
	public ServicioSinger servicioSinger() {

		return new ServicioSinger() {

			@Override
			public List<Singer> listar() {
				Singer[] dtos = ClienteHttp.invoke( URL_S, Singer[].class);
				return Arrays.asList(dtos);
			}

			@Override
			public Singer buscar(Integer id) {
				return ClienteHttp.invoke(URL_S + "/" + id, Singer.class);
			}

		};
	}

	@Produces
	@ApplicationScoped
	public ServicioAlbum servicioAlbum() {

		return new ServicioAlbum() {

			@Override
			public List<Album> listar() {
				Album[] dtos = ClienteHttp.invoke(URL_A, Album[].class);
				return Arrays.asList(dtos);
			}

			@Override
			public Album buscar(Integer id) {
				return ClienteHttp.invoke(URL_A + "/" + id, Album.class);
			}

		};
	}
}
