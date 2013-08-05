package edu.mx.utvm.eproyectos.controllers.formbeans;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class FormEvaluacion {
	@NotEmpty
	private String descripcion;
	
	@NotEmpty	
	private String descripcionDetallada;
	
	@Min(1)
	private int exposicion_por;
	
	
	public int getExposicion_por() {
		return exposicion_por;
	}
	public void setExposicion_por(int exposicion_por) {
		this.exposicion_por = exposicion_por;
	}
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
