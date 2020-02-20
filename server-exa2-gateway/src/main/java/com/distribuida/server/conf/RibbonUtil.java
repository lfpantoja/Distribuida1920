package com.distribuida.server.conf;

import java.io.IOException;

import org.apache.commons.configuration.AbstractConfiguration;

import com.distribuida.server.model.Direccion;
import com.distribuida.server.model.Persona;
import com.distribuida.server.rest.PersonaRest;
import com.distribuida.server.rest.DireccionRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.util.HystrixTimer;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.netty.buffer.ByteBuf;

public class RibbonUtil {
	
	public static Persona[] listarPersonas (String URL){
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("rest-persona.ribbon." + CommonClientConfigKey.ListOfServers, URL);
		PersonaRest servicio = Ribbon.from(PersonaRest.class);

		RibbonRequest<ByteBuf> ret = servicio.personas();
		ByteBuf result = ret.execute();
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);
		String str = new String(data);
		
		Persona[] dtos1 = null;
		ObjectMapper mapperx = new ObjectMapper();
		
		
		try {
			dtos1 = mapperx.readValue(str,Persona[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HystrixTimer.reset();
		return dtos1;
	}

	public static Persona buscarPersona(Integer id, String URL) {
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("rest-persona.ribbon." + CommonClientConfigKey.ListOfServers, URL);
		PersonaRest servicio = Ribbon.from(PersonaRest.class);

		RibbonRequest<ByteBuf> ret = servicio.personaGet(id);
		ByteBuf result = ret.execute();
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);
		String str = new String(data);

		ObjectMapper mapper = new ObjectMapper();
		Persona miAlbum1 = new Persona();
		try {
			miAlbum1 = mapper.readValue(str, Persona.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HystrixTimer.reset();
		return miAlbum1;
	}
	
	public static Direccion[] listarDirecciones (String URL){
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("rest-direccion.ribbon." + CommonClientConfigKey.ListOfServers, URL);
		DireccionRest servicio = Ribbon.from(DireccionRest.class);

		RibbonRequest<ByteBuf> ret = servicio.direcciones();
		ByteBuf result = ret.execute();
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);
		String str = new String(data);
		
		Direccion[] dtos1 = null;
		ObjectMapper mapperx = new ObjectMapper();
		
		try {
			dtos1 = mapperx.readValue(str,Direccion[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HystrixTimer.reset();
		return dtos1;
	}

	public static Direccion buscarDireccion(Integer id, String URL) {
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("rest-direccion.ribbon." + CommonClientConfigKey.ListOfServers, URL);
		DireccionRest servicio = Ribbon.from(DireccionRest.class);

		RibbonRequest<ByteBuf> ret = servicio.direccionGet(id);
		ByteBuf result = ret.execute();
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);
		String str = new String(data);

		ObjectMapper mapper = new ObjectMapper();
		Direccion miSinger1 = new Direccion();
		try {
			miSinger1 = mapper.readValue(str, Direccion.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HystrixTimer.reset();
		return miSinger1;
	}
	
}
