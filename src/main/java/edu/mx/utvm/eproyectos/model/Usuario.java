package edu.mx.utvm.eproyectos.model;

public class Usuario {
	private String usuario;
	private String clave;
	private int activo;
	
	public Usuario(String usuario, String clave) {
		this.usuario = usuario;
		this.setClave(clave);
		setActivo(1);
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

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
}
