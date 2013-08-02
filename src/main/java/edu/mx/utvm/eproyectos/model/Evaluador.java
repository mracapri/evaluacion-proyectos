package edu.mx.utvm.eproyectos.model;

public class Evaluador extends Usuario{
	private String idEvaluador;
	private String especialidad;
	private String nombre;
	
	public Evaluador(String idEvaluador, String nombre, String especialidad,
			String usuario, String clave) {
		
		super(usuario, clave);
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
