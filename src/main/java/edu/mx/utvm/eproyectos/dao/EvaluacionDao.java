package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;


public interface EvaluacionDao extends Dao<Evaluacion, Integer>{
	List<Evaluador> findEvaluadoresByIdEvaluacion(Integer id);
	List<Proyecto> findProyectosByIdEvalaucion(Integer id);
}
