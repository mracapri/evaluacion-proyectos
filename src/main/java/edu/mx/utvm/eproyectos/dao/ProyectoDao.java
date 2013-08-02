package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;

public interface ProyectoDao extends Dao<Proyecto, String>{
	void create(Proyecto proyecto, Evaluacion evaluacion);
	Map<String, Proyecto> findAllByIdEvaluacion(String id);	
}
