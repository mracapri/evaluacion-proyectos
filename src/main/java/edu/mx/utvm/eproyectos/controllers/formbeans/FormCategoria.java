package edu.mx.utvm.eproyectos.controllers.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class FormCategoria {
	@NotEmpty
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
