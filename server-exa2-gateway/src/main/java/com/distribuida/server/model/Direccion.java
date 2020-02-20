package com.distribuida.server.model;

import java.io.Serializable;

public class Direccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descripcion;
	
	public Direccion(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Direccion() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
