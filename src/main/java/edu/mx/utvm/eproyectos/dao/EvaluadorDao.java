package edu.mx.utvm.eproyectos.dao;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

public interface EvaluadorDao extends Dao<Evaluador, Integer>{
	void create(Evaluador evaluador, Evaluacion evaluacion);
}
