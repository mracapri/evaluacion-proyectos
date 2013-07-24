package edu.mx.utvm.eproyectos.dao;

import java.util.List;


import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;

public interface EvaluacionDao extends Dao<Evaluacion, Integer>{
	 List<Evaluador> findEvaluadorByEvaluacion(int idevaluacion);
	 void inserEvaluacionEvaluador(Evaluador evaluador, Evaluacion evaluacion);
}
