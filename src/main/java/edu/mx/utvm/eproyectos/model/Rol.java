package edu.mx.utvm.eproyectos.model;

public enum Rol {
	
	EVALUADOR(1, "Evaluador"), ADMINISTRADOR(2, "Administrador"), MANAGER(3, "Manager");
	
	private int idRole;
	private String descripcion;
	
	private Rol(int idRole, String descripcion){
		this.idRole = idRole;
		this.descripcion = descripcion;
	}
	
	public int getIdRole() {
		return idRole;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
