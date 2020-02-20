package com.distribuida.server.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.server.model.Direccion;
import com.distribuida.server.service.ServicioDireccion;

@SessionScoped
@Named("direccionAction")
public class DireccionAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioDireccion servicio;

	private List<Direccion> direcciones;
	private Direccion direccionSeleccionado;

	public List<Direccion> getAlbums() {
		return direcciones;
	}

	public Direccion getDireccionSeleccionado() {
		return direccionSeleccionado;
	}

	public String iniciar() {
		direcciones = servicio.listar();
		return "direcciones";
	}

	public String detalle(Direccion dto) {
		direccionSeleccionado = servicio.buscar(dto.getId());
		return "direccion-detalle";
	}

}
