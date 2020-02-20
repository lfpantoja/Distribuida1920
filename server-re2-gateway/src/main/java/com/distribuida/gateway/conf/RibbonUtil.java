package com.distribuida.gateway.conf;

import java.io.IOException;

import org.apache.commons.configuration.AbstractConfiguration;

import com.distribuida.gateway.model.Album;
import com.distribuida.gateway.model.Singer;
import com.distribuida.gateway.rest.AlbumRest;
import com.distribuida.gateway.rest.SingerRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.config.CommonClientConfigKey;
//import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.util.HystrixTimer;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.netty.buffer.ByteBuf;

public class RibbonUtil {
	public static Album[] listarAlbums (String URL){
//		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
//		config.setProperty("rest-album.ribbon." + CommonClientConfigKey.ListOfServers, URL);
//		AlbumRest servicio = Ribbon.from(AlbumRest.class);
//
//		RibbonRequest<ByteBuf> ret = servicio.albums();
//		ByteBuf result = ret.execute();
//		int size = result.readableBytes();
//		byte[] data = new byte[size];
//		result.readBytes(data);
//		String str = new String(data);
//		
//		Album[] dtos1 = null;
//		ObjectMapper mapperx = new ObjectMapper();
//		
//			try {
//				dtos1 = mapperx.readValue(str,Album[].class);
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		
//		HystrixTimer.reset();
//		return dtos1;
		return null;
	}
	
	public static Album buscarAlbum(Integer id, String URL) {
//		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
//		config.setProperty("rest-album.ribbon." + CommonClientConfigKey.ListOfServers, URL);
//		AlbumRest servicio = Ribbon.from(AlbumRest.class);
//
//		RibbonRequest<ByteBuf> ret = servicio.albumGet(id);
//		ByteBuf result = ret.execute();
//		int size = result.readableBytes();
//		byte[] data = new byte[size];
//		result.readBytes(data);
//		String str = new String(data);
//
//		ObjectMapper mapper = new ObjectMapper();
//		Album miAlbum1 = new Album();
//		try {
//			miAlbum1 = mapper.readValue(str, Album.class);
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		HystrixTimer.reset();
//		return miAlbum1;
		return null;
	}
	
	public static Singer[] listarSingers (String URL){
		System.out.println("Listar Singers Gate");
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
		config.setProperty("rest-singer.ribbon." + CommonClientConfigKey.ListOfServers, URL);
		System.out.println(config);
		SingerRest servicio = Ribbon.from(SingerRest.class);

		RibbonRequest<ByteBuf> ret = servicio.singers();
		ByteBuf result = ret.execute();
		int size = result.readableBytes();
		byte[] data = new byte[size];
		result.readBytes(data);
		String str = new String(data);
		
		Singer[] dtos1 = null;
		ObjectMapper mapperx = new ObjectMapper();
		
		try {
			dtos1 = mapperx.readValue(str,Singer[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HystrixTimer.reset();
		return dtos1;
		//return null;
	}

	public static Singer buscarSinger(Integer id, String URL) {
//		AbstractConfiguration config = ConfigurationManager.getConfigInstance();
//		config.setProperty("rest-singer.ribbon." + CommonClientConfigKey.ListOfServers, URL);
//		SingerRest servicio = Ribbon.from(SingerRest.class);
//
//		RibbonRequest<ByteBuf> ret = servicio.singerGet(id);
//		ByteBuf result = ret.execute();
//		int size = result.readableBytes();
//		byte[] data = new byte[size];
//		result.readBytes(data);
//		String str = new String(data);
//
//		ObjectMapper mapper = new ObjectMapper();
//		Singer miSinger1 = new Singer();
//		try {
//			miSinger1 = mapper.readValue(str, Singer.class);
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		HystrixTimer.reset();
//		return miSinger1;
		return null;
	}
}
