/*
 * Service de <Evaluacion>
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import edu.mx.utvm.eproyectos.model.Evaluacion;

public interface EvaluacionService extends Service<Evaluacion, String>{
	Evaluacion readByIdEvalauador(String idEvaluador);
}
