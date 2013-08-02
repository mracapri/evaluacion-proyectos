package edu.mx.utvm.eproyectos.services;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Resultado;

public interface ResultadoService extends Service<Resultado, Integer> {
	List<Resultado> findAllByProyecto(String id);
}
