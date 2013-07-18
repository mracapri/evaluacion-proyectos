package edu.mx.utvm.model;

import java.util.Map;

public class CalificacionEvaluador {
	private Evaluador evaluador;
	private Map<Integer, Double> resultadoPorItem;
	private Rubrica rubrica;
	
	public CalificacionEvaluador(Evaluador evaluador,
			Map<Integer, Double> resultadoPorItem, Rubrica rubrica) {
		this.evaluador = evaluador;
		this.resultadoPorItem = resultadoPorItem;
		this.rubrica = rubrica;
	}
	
	public Evaluador getEvaluador() {
		return evaluador;
	}

	public Map<Integer, Double> getResultadoPorItem() {
		return resultadoPorItem;
	}

	public Double calcularTotal(){
		double total = 0;
		for(Integer key : resultadoPorItem.keySet()){
			total = total + resultadoPorItem.get(key);
		}
		total = total / resultadoPorItem.size();
		return total;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}
}
