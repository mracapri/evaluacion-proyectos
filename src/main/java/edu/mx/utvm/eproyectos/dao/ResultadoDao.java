package edu.mx.utvm.eproyectos.dao;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;

public interface ResultadoDao extends Dao<CalificacionEvaluador, Integer> {
	public void create(CalificacionEvaluador newInstance, Evaluacion evaluacion, Proyecto proyecto);
	
}
