package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;

public interface ProyectoDao extends Dao<Proyecto, String>{
	void create(Proyecto proyecto, Evaluacion evaluacion);
	List<Proyecto> findAllByIdEvaluacion(String id);	
}
