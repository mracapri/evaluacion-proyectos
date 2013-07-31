package edu.mx.utvm.eproyectos.model;

public class Usuario {
	private String usuario;
	private String clave;
	private String nombre;
	
	public Usuario(String usuario, String clave) {
		this.usuario = usuario;
		this.setClave(clave);
	}
	
	public Usuario(String usuario, String clave, String nombre) {
		this.usuario = usuario;
		this.setClave(clave);
		this.setNombre(nombre);
	}

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
