package edu.mx.utvm.eproyectos.model;

public class Resultado {
	private int idEvaluacion;
	private String idProyecto;
	private String idRubrica;
	private int idItemRubrica;
	private double calificacion;
	
	public Resultado(Integer idEvaluacion, String idProyecto, String idRubrica, Integer idItemRubrica, double calificacion){
		this.idEvaluacion =idEvaluacion;
		this.idProyecto = idProyecto;
		this.idRubrica = idRubrica;
		this.idItemRubrica = idItemRubrica;
		this.calificacion = calificacion;
	}
	
	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
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
