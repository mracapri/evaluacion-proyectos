package edu.mx.utvm.eproyectos.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.dao.ProyectoDao;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
/*
 * Implementacion del servicio <Proyecto>
 * 
 * @author Mario Rivera
 */
@Service
public class ProyectoServiceImpl implements ProyectoService{

	@Autowired
	private ProyectoDao dao;
	

	@Override
	public Proyecto read(String id) {
		return dao.read(id);
	}

	@Override
	public List<Proyecto> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void create(Proyecto newInstance) {
		dao.create(newInstance);
	}

	@Override
	@Transactional
	public void update(Proyecto transientObject) {
		dao.update(transientObject);
		
	}

	@Override
	@Transactional
	public void delete(Proyecto persistentObject) {
		dao.delete(persistentObject);
	}

	@Override
	public Map<String, Proyecto> findAllByIdEvaluacion(String id) {		
		return dao.findAllByIdEvaluacion(id);
	}

	@Override
	public void create(Proyecto newInstance, Evaluacion evaluacion) {
		dao.create(newInstance, evaluacion);
		
	}
	
}