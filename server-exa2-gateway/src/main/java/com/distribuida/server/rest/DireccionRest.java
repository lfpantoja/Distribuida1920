package com.distribuida.server.rest;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-direccion")
public interface DireccionRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/direcciones"
	)
	public RibbonRequest<ByteBuf> direcciones();
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/direcciones/{id}"
	)
	public RibbonRequest<ByteBuf> direccionGet(@Var("id") Integer id);
}