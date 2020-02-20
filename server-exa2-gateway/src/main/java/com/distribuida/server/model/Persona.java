package com.distribuida.server.model;

import java.io.Serializable;

public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cedula;
	private String direccion;
	private Integer tipoDireccion;
	private String nombre;
	
	public Persona(Integer id, String cedula, String direccion, Integer tipoDireccion, String nombre) {
		this.id = id;
		this.cedula = cedula;
		this.direccion = direccion;
		this.tipoDireccion = tipoDireccion;
		this.nombre = nombre;
	}
	
	public Persona() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(Integer tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
