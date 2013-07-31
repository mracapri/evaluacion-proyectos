package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

public interface EvaluadorDao extends Dao<Evaluador, String>{
	void create(Evaluador evaluador, Evaluacion evaluacion);
	List<Evaluador> findAllByIdEvaluacion(String idEvaluacion);
	List<Evaluador> findAllByIdProyecto(String idProyecto);
}
