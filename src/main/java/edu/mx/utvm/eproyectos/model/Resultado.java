package edu.mx.utvm.eproyectos.model;

public class Resultado {
	private String idEvaluacion;
	private String idProyecto;
	private String idEvaluador;
	private String idRubrica;
	private int idItemRubrica;
	private double calificacion;
	
	public Resultado(String idEvaluacion, String idProyecto, String idEvaluador,String idRubrica, Integer idItemRubrica, double calificacion){
		this.idEvaluacion =idEvaluacion;
		this.idProyecto = idProyecto;
		this.idEvaluador = idEvaluador;
		this.idRubrica = idRubrica;
		this.idItemRubrica = idItemRubrica;
		this.calificacion = calificacion;
	}
	
	public String getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(String idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getIdEvaluador() {
		return idEvaluador;
	}

	public void setIdEvaluador(String idEvaluador) {
		this.idEvaluador = idEvaluador;
	}

	public String getIdRubrica() {
		return idRubrica;
	}
	public void setIdRubrica(String idRubrica) {
		this.idRubrica = idRubrica;
	}
	public int getIdItemRubrica() {
		return idItemRubrica;
	}
	public void setIdItemRubrica(int idItemRubrica) {
		this.idItemRubrica = idItemRubrica;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
}
