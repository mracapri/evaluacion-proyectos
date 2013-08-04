/*
 * Service de <Proyecto>
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

public interface EvaluadorService extends Service<Evaluador, String>{
	void create(Evaluador newInstance, Evaluacion evaluacion);
	Evaluador readByNombreUsuario(String nombreUsuario);
	Map<String, Evaluador> findAllByIdEvaluacion(String idEvaluacion);
}
