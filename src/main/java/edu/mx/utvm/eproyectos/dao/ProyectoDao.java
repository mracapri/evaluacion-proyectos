package edu.mx.utvm.eproyectos.dao;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;

public interface ProyectoDao extends Dao<Proyecto, Integer>{
	void create(Proyecto proyecto, Evaluacion evaluacion);
}
