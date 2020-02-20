package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.model.Album;
import com.distribuida.service.ServiceAlbum;

@Path("/albums")
@ApplicationScoped
public class ServiceAlbumRest {
	@Inject private ServiceAlbum servicio;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Album> listar(){
		return servicio.listAlbums();
	}
	
	@POST
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Album addAlbum(Album e) {
		return servicio.addAlbum(e);
	}
	
	@GET
	@Path("/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam(value = "id") Integer id) {
		Album album = new Album();
		album.setId(servicio.getAlbum(id).getId());
		album.setSingerId(servicio.getAlbum(id).getSingerId());
		album.setTitle(servicio.getAlbum(id).getTitle());
		album.setReleaseDate(servicio.getAlbum(id).getReleaseDate());
		//singer =servicio.getSinger(id)
		return album;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteAlbum(@PathParam(value = "id") Integer id) {
		servicio.deleteAlbum(id);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Album updateAlbum(Album e) {
		return servicio.updateAlbum(e);
	}
}
