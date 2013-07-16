package edu.mx.utvm.model;

import java.util.List;

public class ResultadoRubrica {
	private List<CalificacionEvaluador> calificacionEvaluador;

	public List<CalificacionEvaluador> getCalificacionEvaluador() {
		return calificacionEvaluador;
	}

	public void setCalificacionEvaluador(
			List<CalificacionEvaluador> calificacionEvaluador) {
		this.calificacionEvaluador = calificacionEvaluador;
	}
	
	public Double calcularTotal(){
		return 0.0;
	}
	
	public Double calcularPorCategoria(){
		return 0.0;
	}
	
	public Double calcularPorPresentacion(){
		return 0.0;
	}
}
