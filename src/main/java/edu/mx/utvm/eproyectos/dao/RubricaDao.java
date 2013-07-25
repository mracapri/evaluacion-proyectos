package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Rubrica;

public interface RubricaDao extends Dao<Rubrica, String> {
	Map<String, Rubrica> findAllMap();
}