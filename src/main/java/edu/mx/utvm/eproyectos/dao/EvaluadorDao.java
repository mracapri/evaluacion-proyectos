package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

public interface EvaluadorDao extends Dao<Evaluador, String>{
	void create(Evaluador evaluador, Evaluacion evaluacion);
	Map<String,Evaluador> findAllByIdEvaluacion(String idEvaluacion);
	Evaluador readByNombreUsuario(String nombreUsuario);
}
