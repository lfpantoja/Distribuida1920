package com.distribuida.server.conf;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.distribuida.server.model.Direccion;
import com.distribuida.server.model.Persona;
import com.distribuida.server.service.ServicePersona;
import com.distribuida.server.service.ServiceDireccion;

@ApplicationScoped
public class Producer {

	private String URL;
	
	@Inject
	ListInstances in;
	
	@Produces
	@ApplicationScoped
	public ServicePersona servicioPersona() {
		
		return new ServicePersona() {
			
			@Override
			public Persona getPersona(Integer id) {
				URL=in.instanciasP();
				return RibbonUtil.buscarPersona(id, URL);
			}

			@Override
			public List<Persona> listPersonas() {
				URL=in.instanciasP();
				return Arrays.asList(RibbonUtil.listarPersonas(URL));
			}

		};
	}

	@Produces
	@ApplicationScoped
	public ServiceDireccion servicioDireccion() {

		return new ServiceDireccion() {

			@Override
			public Direccion getDireccion(Integer id) {
				URL=in.instanciasD();
				return RibbonUtil.buscarDireccion(id, URL);
			}

			@Override
			public List<Direccion> listDirecciones() {
				URL = in.instanciasD();
				return Arrays.asList(RibbonUtil.listarDirecciones(URL));
			}


		};
	}
}
