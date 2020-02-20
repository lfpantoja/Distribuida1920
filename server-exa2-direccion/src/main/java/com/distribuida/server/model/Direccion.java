package com.distribuida.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "tipo_direccion")
public class Direccion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name="descripcion")
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
