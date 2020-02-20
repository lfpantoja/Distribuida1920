package com.distribuida.server.rest;

import com.distribuida.server.model.Album;
import com.distribuida.server.transf.Trans;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Content;
import com.netflix.ribbon.proxy.annotation.ContentTransformerClass;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-album")
public interface AlbumRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/albums"
	)
	public RibbonRequest<ByteBuf> albums();
	
	@Http(method = Http.HttpMethod.POST, 
			uri = "/albums", 
			headers = {
					@Http.Header(
							name = "Content-Type", 
							value = "application/json"
					) 
			}

	)
	@ContentTransformerClass(Trans.class)
	public RibbonRequest<ByteBuf> albumsPost(@Content Album e);
	
	@Http(
			method = Http.HttpMethod.DELETE,
			uri="/albums/{id}"
	)
	public RibbonRequest<ByteBuf> albumDelete(@Var("id") Integer id);
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/albums/{id}"
	)
	public RibbonRequest<ByteBuf> albumGet(@Var("id") Integer id);
}
