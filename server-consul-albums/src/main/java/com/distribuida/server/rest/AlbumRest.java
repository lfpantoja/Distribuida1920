package com.distribuida.server.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.server.model.Album;
import com.distribuida.server.service.ServiceAlbum;

@Path("/albums")
@ApplicationScoped
public class AlbumRest {
	
	@Inject	private ServiceAlbum servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Album[] listar(){
		List<Album> albums = servicio.listAlbums();
		Album[] arrayA = new Album[albums.size()];
		arrayA = albums.toArray(arrayA);
		return arrayA;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam(value = "id") Integer id) {
		Album album = new Album();
		
		album.setId(servicio.getAlbum(id).getId());
		album.setSingerId(servicio.getAlbum(id).getSingerId());
		album.setTitle(servicio.getAlbum(id).getTitle());
		album.setReleaseDate(null);
		
		//singer =servicio.getSinger(id)
		return album;
	}

}
