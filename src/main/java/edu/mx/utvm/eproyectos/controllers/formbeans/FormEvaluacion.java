package edu.mx.utvm.eproyectos.controllers.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class FormEvaluacion {
	@NotEmpty
	private String descripcion;
	@NotEmpty
	private String descripcionDetallada;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionDetallada() {
		return descripcionDetallada;
	}
	public void setDescripcionDetallada(String descripcionDetallada) {
		this.descripcionDetallada = descripcionDetallada;
	}	

}
