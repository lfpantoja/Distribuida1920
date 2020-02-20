package com.distribuida.server.conf;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;

@ApplicationScoped
public class ListInstances {
	
	public static final String NAME_A = "rest-album";
	public static final String NAME_S = "rest-singer";
	
	private List<Service> listaA;
	private List<Service> listaS;
	private List<String> servs;
	
	private String singer;
	private String album;
	
	@Produces
	@ApplicationScoped
	public String instanciasA(){
		ConsulClient client = new ConsulClient("127.0.0.1");
		
		Response<Map<String, Service>> ss = client.getAgentServices();
		
		Map<String, Service> services = ss.getValue();
		
		listaA = services.values()
				.stream()
				.filter(s -> NAME_A.equals(s.getService()))
				.collect(Collectors.toList());

		servs = services.values()
				.stream()
				.filter(s1 -> NAME_A.equals(s1.getService()))
				.map(s1->String.format("%s:%d",s1.getAddress(),s1.getPort()))
				.collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		for(String s1:servs) {
			sb.append(s1);
			sb.append(",");
		}
		
		Random rnd = new Random();
		int rango = (int)(rnd.nextDouble() * listaA.size() + 0);
		
		album = "http://"+listaA.get(rango).getAddress()+":"+ listaA.get(rango).getPort();
		System.out.println("**********Instancias***********");
		System.out.println(listaA);
		System.out.println("**********Seleccion de Instancia***********");
		System.out.println(album);
		System.out.println("*********************");
		
		if (listaA.isEmpty()) {
			System.err.println("No existe servicio registrado con el nombre: " + NAME_A);
			return null;
		}
		
		return album;
	}

	@Produces
	@ApplicationScoped
	public String instanciasS(){
		ConsulClient client = new ConsulClient("127.0.0.1");
		
		Response<Map<String, Service>> ss = client.getAgentServices();
		
		Map<String, Service> services = ss.getValue();
		
		listaS = services.values()
				.stream()
				.filter(s -> NAME_S.equals(s.getService()))
				.collect(Collectors.toList());
		
		servs = services.values()
				.stream()
				.filter(s1 -> NAME_S.equals(s1.getService()))
				.map(s1->String.format("%s:%d",s1.getAddress(),s1.getPort()))
				.collect(Collectors.toList());
		
		StringBuilder sb = new StringBuilder();
		for(String s1:servs) {
			sb.append(s1);
			sb.append(",");
		}

		Random rnd = new Random();
		int rango = (int)(rnd.nextDouble() * listaS.size() + 0);
		
		singer = "http://"+listaS.get(rango).getAddress()+":"+ listaS.get(rango).getPort();
		System.out.println("**********Instancias***********");
		System.out.println(listaS);
		System.out.println("**********Seleccion de Instancia***********");
		System.out.println(singer);
		System.out.println("*********************");
		if (listaS.isEmpty()) {
			System.err.println("No existe servicio registrado con el nombre: " + NAME_S);
			return null;
		}
		
		return singer;
	}
}
