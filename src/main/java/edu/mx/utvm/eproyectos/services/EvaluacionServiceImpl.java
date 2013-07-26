package edu.mx.utvm.eproyectos.services;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mx.utvm.eproyectos.dao.EvaluacionDao;
import edu.mx.utvm.eproyectos.model.Evaluacion;

public class EvaluacionServiceImpl implements EvaluacionService{


	@Autowired
	private EvaluacionDao dao;
	
	@Override
	public void save(Evaluacion evaluacion) {		
		
	}

	@Override
	public Evaluacion read(int id) {
		Evaluacion read = dao.read(id);
		dao.create(new Evaluacion(1, ""));
		return read;
	}

}
