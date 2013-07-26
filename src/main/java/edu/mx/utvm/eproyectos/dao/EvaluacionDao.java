package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;


public interface EvaluacionDao extends Dao<Evaluacion, String>{
	List<Evaluador> findEvaluadoresByIdEvaluacion(String id);
	List<Proyecto> findProyectosByIdEvalaucion(String id);
}
