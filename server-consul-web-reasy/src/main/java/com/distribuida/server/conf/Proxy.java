package com.distribuida.server.conf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.server.model.Album;
import com.distribuida.server.model.Singer;
import com.distribuida.server.rest.ServiceAlbum;
import com.distribuida.server.rest.ServiceSinger;

public class Proxy {
	
	public static ResteasyWebTarget retE (String url) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(url));
		return target;
	}
	
	public static List<Album> lAlbum (String url){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceAlbum proxy = re.proxy(ServiceAlbum.class);
		List<Album> newList = new ArrayList<Album>();
		
		newList = Arrays.asList(proxy.listAlbums());
		
		return newList;
	}
	
	public static Album gAlbum (String url, Integer id){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceAlbum proxy = re.proxy(ServiceAlbum.class);
		
		return proxy.getAlbum(id);
	}
	
	public static Response aAlbum (String url, Album e){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceAlbum proxy = re.proxy(ServiceAlbum.class);
		
		return proxy.addAlbum(e);
	}
	
	public static Response dAlbum (String url, Integer id){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceAlbum proxy = re.proxy(ServiceAlbum.class);
		
		return proxy.deleteAlbum(id);
	}
	
	public static Album uAlbum (String url, Album e){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceAlbum proxy = re.proxy(ServiceAlbum.class);
		
		return proxy.updateAlbum(e);
	}
	
	public static List<Singer> lSinger (String url){
		ResteasyWebTarget re = Proxy.retE(url);
		ServiceSinger proxy = re.proxy(ServiceSinger.class);
		List<Singer> newList = new ArrayList<Singer>();
		
		newList = Arrays.asList(proxy.listSingers());
		
		return newList;
	}
	
	public static Singer gSinger (String url, Integer id){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(url));
		ServiceSinger proxy = target.proxy(ServiceSinger.class);
		
		return proxy.getSinger(id);
	}
	
	public static Response aSinger (String url, Singer e){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(url));
		ServiceSinger proxy = target.proxy(ServiceSinger.class);
		
		return proxy.addSinger(e);
	}
	
	public static Response dSinger (String url, Integer id){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(url));
		ServiceSinger proxy = target.proxy(ServiceSinger.class);
		
		return proxy.deleteSinger(id);
	}
	
	public static Singer uSinger (String url, Singer e){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(url));
		ServiceSinger proxy = target.proxy(ServiceSinger.class);
		
		return proxy.updateSinger(e);
	}
}
