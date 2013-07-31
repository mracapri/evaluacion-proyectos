package edu.mx.utvm.eproyectos.controllers.formbeans;

import java.sql.Date;

public class FormEvaluacion {
	private String descripcion;
	private Date fechaEvaluacion;
	private String  descripcionDetallada;
	private String idProyecto;
	private String idEvaluador;	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	public String getDescripcionDetallada() {
		return descripcionDetallada;
	}
	public void setDescripcionDetallada(String descripcionDetallada) {
		this.descripcionDetallada = descripcionDetallada;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getIdEvaluador() {
		return idEvaluador;
	}
	public void setIdEvaluador(String idEvaluador) {
		this.idEvaluador = idEvaluador;
	}	
}
