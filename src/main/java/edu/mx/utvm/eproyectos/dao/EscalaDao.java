package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Escala;

public interface EscalaDao extends Dao<Escala, Integer>{
	Map<Integer, Escala> findAllMap();
}
