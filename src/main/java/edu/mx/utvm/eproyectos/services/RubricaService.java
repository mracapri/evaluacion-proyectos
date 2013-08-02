/*
 * Service para Rubrica
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Rubrica;

public interface RubricaService {
	Rubrica obtenerRubricaPorCategoriaDeProyecto(Proyecto proyecto);
}
