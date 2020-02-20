package com.distribuida.server.conf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.server.model.Persona;
import com.distribuida.server.model.Direccion;
import com.distribuida.server.service.ServicioDireccion;
import com.distribuida.server.service.ServicioPersona;

@ApplicationScoped
public class Producer {

	@Produces
	@ApplicationScoped
	public ServicioPersona servicioPersona() {

		return new ServicioPersona() {

			@Override
			public List<Persona> listar() {
				Persona[] dtos = ClienteHttp.invoke( "http://127.0.0.1:7010/personas", Persona[].class);
				return Arrays.asList(dtos);
			}

			@Override
			public Persona buscar(Integer id) {
				return ClienteHttp.invoke("http://127.0.0.1:7010/personas/" + id, Persona.class);
			}

		};
	}

	@Produces
	@ApplicationScoped
	public ServicioDireccion servicioDireccion() {

		return new ServicioDireccion() {

			@Override
			public List<Direccion> listar() {
				Direccion[] dtos = ClienteHttp.invoke("http://127.0.0.1:7010" + "/direcciones", Direccion[].class);
				return Arrays.asList(dtos);
			}

			@Override
			public Direccion buscar(Integer id) {
				return ClienteHttp.invoke("http://127.0.0.1:7010"+ "/direcciones/" + id, Direccion.class);
			}

		};
	}
}
