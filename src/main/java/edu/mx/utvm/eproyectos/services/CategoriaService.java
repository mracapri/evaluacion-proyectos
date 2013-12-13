/*
 * Service de <Categoria>
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import edu.mx.utvm.eproyectos.model.Categoria;

public interface CategoriaService extends Service<Categoria, Integer>{
	void create(String descripcion) throws Exception;
}
