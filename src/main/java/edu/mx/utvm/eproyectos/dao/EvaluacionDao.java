package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;


public interface EvaluacionDao extends Dao<Evaluacion, String>{
	Map<String, Proyecto> findProyectosByIdEvalaucion(String id);
	Evaluacion readByIdEvalauador(String idEvaluador);
}
