package com.distribuida.server.rest;

import com.distribuida.server.model.Singer;
import com.distribuida.server.transf.TransS;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Content;
import com.netflix.ribbon.proxy.annotation.ContentTransformerClass;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;
import com.netflix.ribbon.proxy.annotation.Var;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name="rest-singer")
public interface SingerRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/singers"
	)
	public RibbonRequest<ByteBuf> singers();
	
	@Http(method = Http.HttpMethod.POST, 
			uri = "/singers", 
			headers = {
					@Http.Header(
							name = "Content-Type", 
							value = "application/json"
					) 
			}

	)
	@ContentTransformerClass(TransS.class)
	public RibbonRequest<ByteBuf> singersPost(@Content Singer e);
	
	@Http(
			method = Http.HttpMethod.DELETE,
			uri="/singers/{id}"
	)
	public RibbonRequest<ByteBuf> singerDelete(@Var("id") Integer id);
	
	@Http(
			method = Http.HttpMethod.GET,
			uri="/singers/{id}"
	)
	public RibbonRequest<ByteBuf> singerGet(@Var("id") Integer id);
}