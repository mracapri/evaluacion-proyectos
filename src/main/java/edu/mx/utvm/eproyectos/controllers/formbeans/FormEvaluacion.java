package edu.mx.utvm.eproyectos.controllers.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class FormEvaluacion {
	@NotEmpty
	private String descripcion;
	@NotEmpty
	private String descripcionDetallada;
	
	private int noPresentacion;	
	private int noCategoria;
	
	public int getNoPresentacion() {
		return noPresentacion;
	}
	public void setNoPresentacion(int noPresentacion) {
		this.noPresentacion = noPresentacion;
	}
	public int getNoCategoria() {
		return noCategoria;
	}
	public void setNoCategoria(int noCategoria) {
		this.noCategoria = noCategoria;
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
