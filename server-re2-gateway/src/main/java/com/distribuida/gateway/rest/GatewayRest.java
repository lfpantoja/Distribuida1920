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
import com.distribuida.gateway.service.ServiceGateway;

@Path("/")
@ApplicationScoped
public class GatewayRest {
	
	@Inject	private ServiceGateway servicioG;
	
	@GET
	@Path("/albums")
	@Produces(MediaType.APPLICATION_JSON)
	public Album[] listarA(){
		List<Album> albums = servicioG.listAlbums();
		Album[] arrayA = new Album[albums.size()];
		arrayA = albums.toArray(arrayA);
		return arrayA;
	}
	
	@GET
	@Path("/albums/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Album getAlbum(@PathParam(value = "id") Integer id) {
		Album album = new Album();
		
		album.setId(servicioG.getAlbum(id).getId());
		album.setSingerId(Integer.valueOf(servicioG.getAlbum(id).getSingerId()));
		album.setTitle(servicioG.getAlbum(id).getTitle());
		album.setReleaseDate(servicioG.getAlbum(id).getReleaseDate());
	
		return album;
	}
	
	@GET
	@Path("/singers")
	@Produces(MediaType.APPLICATION_JSON)
	public Singer[] listarS(){
		List<Singer> singers = servicioG.listSingers();
		Singer[] arrayS = new Singer[singers.size()];
		arrayS = singers.toArray(arrayS);
		return arrayS;
	}
	
	@GET
	@Path("/singers/{id}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Singer getSinger(@PathParam(value = "id") Integer id) {
		Singer singer = new Singer();
		
		singer.setId(servicioG.getSinger(id).getId());
		singer.setFirstName(servicioG.getSinger(id).getFirstName());
		singer.setLastName(servicioG.getSinger(id).getLastName());
		singer.setBirthDate(servicioG.getSinger(id).getBirthDate());
		
		return singer;
	}
	
	@GET
	@Path("/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String ping(){
		return "okG";
	}
	
}
