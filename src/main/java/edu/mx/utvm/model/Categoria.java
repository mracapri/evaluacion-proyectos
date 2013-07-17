package edu.mx.utvm.model;

public class Categoria {
	
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
