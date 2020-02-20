package com.distribuida.gateway.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.gateway.model.Album;
import com.distribuida.gateway.model.Singer;
import com.distribuida.gateway.service.ServiceAlbum;
import com.distribuida.gateway.service.ServiceSinger;

@Path("/")
@ApplicationScoped
public class GatewayRest {
	
	@Inject	private ServiceAlbum servicioA;
	@Inject	private ServiceSinger servicioS;
	
	@Path("/albums")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Album[] listarA(){
		List<Album> albums = servicioA.listAlbums();
		Album[] arrayA = new Album[albums.size()];
		arrayA = albums.toArray(arrayA);
		return arrayA;
	}
	
	@GET
	@Path("/albums/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam(value = "id") Integer id) {
		Album album = new Album();
		
		album.setId(servicioA.getAlbum(id).getId());
		album.setSingerId(Integer.valueOf(servicioA.getAlbum(id).getSingerId()));
		album.setTitle(servicioA.getAlbum(id).getTitle());
		album.setReleaseDate(servicioA.getAlbum(id).getReleaseDate());
	
		return album;
	}
	
	@Path("/singers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Singer[] listarS(){
		List<Singer> singers = servicioS.listSingers();
		Singer[] arrayS = new Singer[singers.size()];
		arrayS = singers.toArray(arrayS);
		return arrayS;
	}
	
	@GET
	@Path("/singers/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam(value = "id") Integer id) {
		Singer singer = new Singer();
		
		singer.setId(servicioS.getSinger(id).getId());
		singer.setFirstName(servicioS.getSinger(id).getFirstName());
		singer.setLastName(servicioS.getSinger(id).getLastName());
		singer.setBirthDate(servicioS.getSinger(id).getBirthDate());
		
		return singer;
	}
	
}
