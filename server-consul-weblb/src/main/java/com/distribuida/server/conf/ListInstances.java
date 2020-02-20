package com.distribuida.server.conf;

import java.util.List;
import java.util.Map;
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
	
	private List<String> servs;
	
	@Produces
	@ApplicationScoped
	public String instanciasA(){
		
		ConsulClient client = new ConsulClient("127.0.0.1");
		
		Response<Map<String, Service>> ss = client.getAgentServices();
		
		Map<String, Service> services = ss.getValue();

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
		
		String str = new String(sb);

		System.out.println("--------Instancias Activas------------------------");
		System.out.println(str);
		System.out.println("--------*********------------------------");
		
		if (str.isEmpty()) {
			System.err.println("No existe servicio registrado con el nombre: " + NAME_A);
			return null;
		}
		return str;
	}

	@Produces
	@ApplicationScoped
	public String instanciasS(){
		
		ConsulClient client = new ConsulClient("127.0.0.1");
		
		Response<Map<String, Service>> ss = client.getAgentServices();
		
		Map<String, Service> services = ss.getValue();

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
		
		String str = new String(sb);

		System.out.println("--------Instancias Activas------------------------");
		System.out.println(str);
		System.out.println("--------*********------------------------");
		
		if (str.isEmpty()) {
			System.err.println("No existe servicio registrado con el nombre: " + NAME_S);
			return null;
		}
		
		return str;
	}
}
