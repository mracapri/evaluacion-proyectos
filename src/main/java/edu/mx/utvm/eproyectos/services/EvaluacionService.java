package edu.mx.utvm.eproyectos.services;

import edu.mx.utvm.eproyectos.model.Evaluacion;

public interface EvaluacionService {
	void save(Evaluacion evaluacion);
	Evaluacion read(String id);
}
