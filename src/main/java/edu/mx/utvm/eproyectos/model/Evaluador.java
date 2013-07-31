package edu.mx.utvm.eproyectos.model;

public class Evaluador extends Usuario{
	private String idEvaluador;
	private String especialidad;

	public Evaluador(String idEvaluador, String nombre, String especialidad,
			String usuario, String clave) {
		
		super(usuario, clave, nombre);
		this.idEvaluador = idEvaluador;
		this.especialidad = especialidad;		
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
	
	public Usuario convertUsuario(){
		return this;
	}
}
