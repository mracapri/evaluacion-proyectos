package edu.mx.utvm.eproyectos.controllers.formbeans;

public class FormProyecto {
	private String nombre;
	private String lider;
	private String integrantes;
	private int idCategoria;
	private String descripcion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLider() {
		return lider;
	}
	public void setLider(String lider) {
		this.lider = lider;
	}
	public String getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
