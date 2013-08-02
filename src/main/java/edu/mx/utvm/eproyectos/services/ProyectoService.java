/*
 * Service de <Proyecto>
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;

public interface ProyectoService extends Service<Proyecto, String>{
	List<Proyecto> findAllByIdEvaluacion(String id);
	void create(Proyecto newInstance, Evaluacion evaluacion);
}
