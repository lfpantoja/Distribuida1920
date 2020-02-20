package com.distribuida.gateway.rest;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-album")
public interface AlbumRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/album"
	)
	public RibbonRequest<ByteBuf> albums();
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/album/{id}"
	)
	public RibbonRequest<ByteBuf> albumGet(@Var("id") Integer id);

}
