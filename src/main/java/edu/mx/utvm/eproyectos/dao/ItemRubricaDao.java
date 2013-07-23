package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Rubrica;

public interface ItemRubricaDao extends Dao<ItemRubrica, Integer> {
	void create(ItemRubrica newInstance, Rubrica rubrica);
	List<ItemRubrica> findItemsRubricaByIdRubrica(String id);
}