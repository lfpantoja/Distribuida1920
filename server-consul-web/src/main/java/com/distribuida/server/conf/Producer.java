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
	//lista de instancias por nombre y clasificar
	//public static final String URL;

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
				Singer[] dtos = HttpExaUtils.invoke(URL + "/singers", Singer[].class);

				return Arrays.asList(dtos);
			}

			@Override
			public Singer buscar(Integer id) {
				URL=in.instanciasS();
				return HttpExaUtils.invoke(URL + "/singers/" + id, Singer.class);
			}
		};
	}

	@Produces
	@ApplicationScoped
	public ServicioAlbum servicioAlbum() {

		return new ServicioAlbum() {

			@Override
			public List<Album> listar() {
				URL=in.instanciasA();
				Album[] dtos = HttpExaUtils.invoke(URL + "/albums", Album[].class);

				return Arrays.asList(dtos);
			}

			@Override
			public Album buscar(Integer id) {
				URL=in.instanciasA();
				return HttpExaUtils.invoke(URL + "/albums/" + id, Album.class);
			}
		};
	}
}
