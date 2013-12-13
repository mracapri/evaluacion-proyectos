package edu.mx.utvm.eproyectos.model;

import java.util.Date;

public class Categoria {
	
	private int idCategoria;
	private String descripcion;
	private Date fechaCreacion;
	
	public Categoria(int idCategoria, String descripcion){
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}	
}
