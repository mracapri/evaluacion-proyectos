package edu.mx.utvm.eproyectos.model;

public class Evaluador {
	private int idEvaluador;
	private String nombre;
	private String especialidad;

	public Evaluador(int idEvaluador, String nombre, String especialidad) {
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

	public int getIdEvaluador() {
		return idEvaluador;
	}
	
}
