package edu.mx.utvm.eproyectos.controllers.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class FormEvaluador {
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String especialidad;
	@NotEmpty
	private String usuario;
	@NotEmpty
	private String password;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
