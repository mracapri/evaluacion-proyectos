package edu.mx.utvm.eproyectos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.dao.EvaluadorDao;
import edu.mx.utvm.eproyectos.model.Evaluador;
/*
 * Implementacion del servicio <Evaluador>
 * 
 * @author Mario Rivera
 */
@Service
public class EvaluadorServiceImpl implements EvaluadorService{


	@Autowired
	private EvaluadorDao dao;
	

	@Override
	public Evaluador read(String id) {
		return dao.read(id);
	}

	@Override
	public List<Evaluador> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void create(Evaluador newInstance) {
		dao.create(newInstance);
	}

	@Override
	@Transactional
	public void update(Evaluador transientObject) {
		dao.update(transientObject);
		
	}

	@Override
	@Transactional
	public void delete(Evaluador persistentObject) {
		dao.delete(persistentObject);
	}

}
