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

@Path("/")
@ApplicationScoped
public class AlbumRest {
	
	@Inject 
	private ServiceAlbum servicio;
	
	@GET
	@Path("/album")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> listar(){
		List<Album> albums = servicio.listAlbums();
		albums = servicio.listAlbums();
		//Singer[] arrayS = new Singer[singers.size()];
		//arrayS = singers.toArray(arrayS);
		//return arrayS;
		return albums;
	}
	
	@GET
	@Path("/album/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam("id") Integer id) {
		Album album = servicio.getAlbum(id);
		return album;
	}
	
	@GET
	@Path("/ping")
	@Produces(value=MediaType.APPLICATION_JSON)
	public String ping() {
		return "ok";
	}
	
}
