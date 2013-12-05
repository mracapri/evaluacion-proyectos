package edu.mx.utvm.eproyectos.model;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResultadoFinal {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private List<CalificacionEvaluador> calificacionEvaluadores;
	private double calificacionPorCategoria = 0;
	private double calificacionPorPresentacion = 0;
	private double calificacionGlobal = 0;
	private int exposicionPor = 0;
	
	public ResultadoFinal(List<CalificacionEvaluador> calificacionEvaluadores, int exposicionPor){		
		this.calificacionEvaluadores = calificacionEvaluadores;
		calificacionPorCategoria = calcularPorCategoria();
		calificacionPorPresentacion = calcularPorPresentacion();
		calificacionGlobal = calcularCalificacionGlobal();
		this.exposicionPor = exposicionPor;
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
		if(numeroCategorias == 0){
			return 0.0;
		}else{
			total = total / numeroCategorias;
			return total;
		}		
	}
	
	public Double calcularCalificacionGlobal(){
		if(exposicionPor == 1){
			calificacionGlobal = calificacionPorPresentacion;
		} else if(exposicionPor == 2){
			calificacionGlobal = calificacionPorCategoria;
		}else if(exposicionPor == 3){
			calificacionGlobal = (calificacionPorCategoria + calificacionPorPresentacion)/2;	
		}		
		return calificacionGlobal;
	}	
	
	public Double calcularPorCategoria(){
		return calcularPorTipoRubrica(RubricaCategoria.class);
	}
	
	public Double calcularPorPresentacion(){
		return calcularPorTipoRubrica(RubricaPresentacion.class);
	}
}
