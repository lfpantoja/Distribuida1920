package com.distribuida.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name="cedula")
	private String cedula;
	@Column(name="direccion")
	private String direccion;
	@Column(name="tipo_direccion")
	private Integer tipoDireccion;
	@Column(name="nombre")
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
