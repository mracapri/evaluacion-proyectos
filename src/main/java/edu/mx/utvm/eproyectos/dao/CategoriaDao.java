package edu.mx.utvm.eproyectos.dao;

import java.util.Map;

import edu.mx.utvm.eproyectos.model.Categoria;

public interface CategoriaDao extends Dao<Categoria, Integer>{
	Map<Integer, Categoria> findAllMap();
	Integer getId();
}
