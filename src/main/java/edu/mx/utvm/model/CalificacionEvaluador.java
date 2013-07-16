package edu.mx.utvm.model;

import java.util.Map;

public class CalificacionEvaluador {
	private Evaluador evaluador;
	private Map<Integer, Integer> resultadoPorItem;
	public Evaluador getEvaluador() {
		return evaluador;
	}
	public void setEvaluador(Evaluador evaluador) {
		this.evaluador = evaluador;
	}
	public Map<Integer, Integer> getResultadoPorItem() {
		return resultadoPorItem;
	}
	public void setResultadoPorItem(Map<Integer, Integer> resultadoPorItem) {
		this.resultadoPorItem = resultadoPorItem;
	}
	
	public Double calcularTotal(){
		return 0.0;
	}
}
