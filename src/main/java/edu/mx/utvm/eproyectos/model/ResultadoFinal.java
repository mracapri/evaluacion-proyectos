package edu.mx.utvm.eproyectos.model;

import java.util.ArrayList;
import java.util.List;

public class ResultadoFinal {
	private List<CalificacionEvaluador> calificacionEvaluadores;
	
	public ResultadoFinal(List<CalificacionEvaluador> calificacionEvaluadores){		
		this.calificacionEvaluadores = calificacionEvaluadores;
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