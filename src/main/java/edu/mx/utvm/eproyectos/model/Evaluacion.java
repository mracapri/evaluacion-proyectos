package edu.mx.utvm.eproyectos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluacion {
	private String idEvaluacion;	
	private String descripcion;
	private Date fechaCreacion;
	private Map<String, Proyecto> proyectos;
	private String descripcionDetallada;
	private Map<String, Evaluador> evaluadores;

	public Evaluacion(String idEvaluacion, String descripcion) {
		this.idEvaluacion = idEvaluacion;
		this.descripcion = descripcion;
		this.fechaCreacion = new Date();
		this.proyectos = new HashMap<String,Proyecto>();
		this.evaluadores = new HashMap<String,Evaluador>();		
	}
	
	public String getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(String idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Map<String, Proyecto> getProyectos() {
		return proyectos;
	}

	public Map<String, Evaluador> getEvaluadores() {
		return evaluadores;
	}
	
}
