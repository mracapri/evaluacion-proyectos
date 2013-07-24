package edu.mx.utvm.eproyectos.dao;

import java.util.List;
import java.util.Map;


import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;

public interface EvaluacionDao extends Dao<Evaluacion, Integer>{
	 List<Integer>findEvaluadorByEvaluacion(int idevaluacion);
	 void inserEvaluacionEvaluador(int idevaluacion, int idevaluador);
}
