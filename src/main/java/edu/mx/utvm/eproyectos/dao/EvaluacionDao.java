package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;


public interface EvaluacionDao extends Dao<Evaluacion, String>{
	List<Proyecto> findProyectosByIdEvalaucion(String id);
	Evaluacion readByIdEvalauador(String idEvaluador);
}
