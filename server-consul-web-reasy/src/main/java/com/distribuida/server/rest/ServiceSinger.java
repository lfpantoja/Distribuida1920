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

import com.distribuida.server.model.Singer;

public interface ServiceSinger {
	@GET
	@Path("/singers")
    @Produces(MediaType.APPLICATION_JSON)
    Singer[] listSingers();
	
	@GET
    @Path("/singers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	Singer getSinger(@PathParam("id") Integer id);
	
	@POST
	@Path("/singers")
    @Consumes(MediaType.APPLICATION_JSON)
    Response addSinger(Singer e);
	
	@PUT
	@Path("/singers")
	@Consumes( MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
    Singer updateSinger(Singer e);
	
	@DELETE
	@Path("/singers/{id}")
    Response deleteSinger(@PathParam("id") Integer id);
}
