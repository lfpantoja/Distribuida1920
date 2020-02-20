package com.distribuida.server.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.server.model.Album;

public interface ServiceAlbum {
	@GET
	@Path("/albums")
    @Produces(MediaType.APPLICATION_JSON)
    Album[] listAlbums();
	
	@GET
    @Path("/albums/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	Album getAlbum(@PathParam("id") Integer id);
	
	@POST
	@Path("/albums")
    @Consumes(MediaType.APPLICATION_JSON)
    Response addAlbum(Album e);
	
	@PUT
	@Path("/albums")
	@Consumes( MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
    Album updateAlbum(Album e);
	
	@DELETE
	@Path("/albums/{id}")
    Response deleteAlbum(@PathParam("id") Integer id);
}
