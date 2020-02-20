package com.distribuida.server.rest;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-persona")
public interface PersonaRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/personas"
	)
	public RibbonRequest<ByteBuf> personas();
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/personas/{id}"
	)
	public RibbonRequest<ByteBuf> personaGet(@Var("id") Integer id);
}
