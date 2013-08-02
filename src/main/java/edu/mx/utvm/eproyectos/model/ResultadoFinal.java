package edu.mx.utvm.eproyectos.model;

import java.util.List;

public class ResultadoFinal {
	private List<CalificacionEvaluador> calificacionEvaluadores;
	private double calificacionPorCategoria = 0;
	public ResultadoFinal(List<CalificacionEvaluador> calificacionEvaluadores){		
		this.calificacionEvaluadores = calificacionEvaluadores;
		calificacionPorCategoria = calcularPorCategoria();
		//calcularPorPresentacion();
	}
	
	public Double calcularTotal(){
		double total = 0;
		for (CalificacionEvaluador calificacionEvaluador : calificacionEvaluadores) {
			total = total + calificacionEvaluador.calcularTotal();
		}
		total = total / calificacionEvaluadores.size();
		return total;
	}
	
	private Double calcularPorTipoRubrica(Class rubrica){
		double total = 0;
		int numeroCategorias = 0;
		
		for (CalificacionEvaluador calificacionEvaluador : calificacionEvaluadores) {
			if(calificacionEvaluador.getRubrica().getClass() == rubrica){
				total = total + calificacionEvaluador.calcularTotal();
				numeroCategorias++;
			}
		}
		total = total / numeroCategorias;
		return total;
	}
	
	public Double calcularPorCategoria(){
		return calcularPorTipoRubrica(RubricaCategoria.class);
	}
	
	public Double calcularPorPresentacion(){
		return calcularPorTipoRubrica(RubricaPresentacion.class);
	}
}
