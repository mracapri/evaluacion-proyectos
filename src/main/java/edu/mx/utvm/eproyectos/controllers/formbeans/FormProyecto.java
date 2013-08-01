package edu.mx.utvm.eproyectos.controllers.formbeans;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class FormProyecto {
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String lider;
	@NotEmpty
	private String integrantes;
	@Min(1)
	private int idCategoria;
	@NotEmpty
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
