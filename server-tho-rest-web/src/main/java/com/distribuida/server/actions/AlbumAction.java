package com.distribuida.server.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.server.model.Album;
import com.distribuida.server.service.ServicioAlbum;

@SessionScoped
@Named("albumAction")
public class AlbumAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioAlbum servicio;

	private List<Album> albums;
	private Album albumSeleccionado;

	public List<Album> getAlbums() {
		return albums;
	}

	public Album getAlbumSeleccionado() {
		return albumSeleccionado;
	}

	public String iniciar() {
		albums = servicio.listar();
		return "albums";
	}

	public String detalle(Album dto) {
		albumSeleccionado = servicio.buscar(dto.getId());
		return "album-detalle";
	}

}
