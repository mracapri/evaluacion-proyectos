package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Resultado;

public interface ResultadoDao extends Dao<Resultado, Integer> {
	List<Resultado> findAllByProyecto(String id);
	
}
