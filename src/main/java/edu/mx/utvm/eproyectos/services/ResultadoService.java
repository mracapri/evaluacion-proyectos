package edu.mx.utvm.eproyectos.services;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Resultado;

public interface ResultadoService extends Service<Resultado, Integer> {
	void create(CalificacionEvaluador newInstance, Evaluacion evaluacion, Proyecto proyecto);
}
