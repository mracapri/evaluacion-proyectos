package edu.mx.utvm.model;

public class Evaluador {
	private int id;
	private String nombre;
	private String especialidad;

	public Evaluador(int id, String nombre, String especialidad) {
		this.id = id;
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

	public int getId() {
		return id;
	}
}
