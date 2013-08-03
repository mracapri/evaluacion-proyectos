package edu.mx.utvm.eproyectos.model;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalificacionEvaluador {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private Evaluador evaluador;
	private Map<Integer, Double> resultadoPorItem;
	private Rubrica rubrica;
	private double totalRubrica;
	
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
		
		if(resultadoPorItem.size() == 0){
			return 0.0;
		}else{
			/*log.info("===============");
			log.info("total="+total);
			log.info("Div="+resultadoPorItem.size());*/			
			total = total / resultadoPorItem.size();
			//log.info("Result--->"+total);
			this.totalRubrica = total;
			return total;
		}		
	}

	public Rubrica getRubrica() {
		return rubrica;
	}
}
