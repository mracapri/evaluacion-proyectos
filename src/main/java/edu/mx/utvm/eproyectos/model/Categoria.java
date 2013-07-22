package edu.mx.utvm.eproyectos.model;

import org.springframework.data.annotation.Id;

public class Categoria {
	@Id
	private int idCategoria;
	private String descripcion;
	
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
}
