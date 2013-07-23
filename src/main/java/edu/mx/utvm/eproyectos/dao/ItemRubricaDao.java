package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.ItemRubrica;

public interface ItemRubricaDao extends Dao<ItemRubrica, Integer> {
	void createRubricaItemRubricas(String idRubrica, Integer idItemRubrica);
	List<ItemRubrica> findAllItemRubricasByRubrica();
}