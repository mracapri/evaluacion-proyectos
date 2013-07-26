package edu.mx.utvm.eproyectos.model;

public class Evaluador {
	private String idEvaluador;
	private String nombre;
	private String especialidad;

	public Evaluador(String idEvaluador, String nombre, String especialidad) {
		this.idEvaluador = idEvaluador;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getIdEvaluador() {
		return idEvaluador;
	}
	
}
