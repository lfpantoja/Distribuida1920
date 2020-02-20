package com.distribuida.server.actions;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.server.model.Singer;
import com.distribuida.server.service.ServicioSinger;

@SessionScoped
@Named("singerAction")
public class SingerAction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioSinger servicio;

	private List<Singer> singers;
	private Singer singerSeleccionado;

	public List<Singer> getSingers() {
		return singers;
	}

	public Singer getSingerSeleccionado() {
		return singerSeleccionado;
	}

	public String iniciar() {
		singers = servicio.listar();
		return "singers";
	}

	public String detalle(Singer dto) {
		singerSeleccionado = servicio.buscar(dto.getId());
		return "singer-detalle";
	}
}
