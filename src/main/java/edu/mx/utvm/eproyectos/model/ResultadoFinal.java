package edu.mx.utvm.eproyectos.model;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResultadoFinal {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private List<CalificacionEvaluador> calificacionEvaluadores;
	private double calificacionPorCategoria = 0;
	private double calificacionPorPresentacion = 0;
	public ResultadoFinal(List<CalificacionEvaluador> calificacionEvaluadores){		
		this.calificacionEvaluadores = calificacionEvaluadores;
		calificacionPorCategoria = calcularPorCategoria();
		calificacionPorPresentacion = calcularPorPresentacion();
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
