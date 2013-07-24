package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;


public interface EvaluacionDao extends Dao<Evaluacion, Integer>{
	List<Evaluador> findItemsRubricaByIdRubrica(Integer id);
}
