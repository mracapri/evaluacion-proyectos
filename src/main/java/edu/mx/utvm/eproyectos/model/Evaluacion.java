package edu.mx.utvm.eproyectos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evaluacion {
	private String idEvaluacion;	
	private String descripcion;
	private Date fechaCreacion;
	private List<Proyecto> proyectos;
	private String descripcionDetallada;
	private List<Evaluador> evaluadores;

	public Evaluacion(String idEvaluacion, String descripcion) {
		this.idEvaluacion = idEvaluacion;
		this.descripcion = descripcion;
		this.fechaCreacion = new Date();
		this.proyectos = new ArrayList<Proyecto>();
		this.evaluadores = new ArrayList<Evaluador>();		
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

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public List<Evaluador> getEvaluadores() {
		return evaluadores;
	}
	
}
