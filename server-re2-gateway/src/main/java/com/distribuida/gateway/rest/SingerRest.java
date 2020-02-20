package com.distribuida.gateway.rest;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-singer")
public interface SingerRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/singer"
	)
	public RibbonRequest<ByteBuf> singers();
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/singer/{id}"
	)
	public RibbonRequest<ByteBuf> singerGet(@Var("id") Integer id);

}
