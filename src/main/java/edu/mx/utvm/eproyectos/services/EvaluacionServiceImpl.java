package edu.mx.utvm.eproyectos.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.dao.EvaluacionDao;
import edu.mx.utvm.eproyectos.model.Evaluacion;
/*
 * Implementacion del servicio <Evaluacion>
 * 
 * @author Mario Rivera
 */
@Service
public class EvaluacionServiceImpl implements EvaluacionService{
	
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private EvaluacionDao dao;
	

	@Override
	public Evaluacion read(String id) {
		return dao.read(id);
	}

	@Override
	public List<Evaluacion> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void create(Evaluacion newInstance) {		
		dao.create(newInstance);
	}

	@Override
	@Transactional
	public void update(Evaluacion transientObject) {
		dao.update(transientObject);
		
	}

	@Override
	@Transactional
	public void delete(Evaluacion persistentObject) {
		dao.delete(persistentObject);
	}

	@Override
	public Evaluacion readByIdEvalauador(String idEvaluador) {
		return dao.readByIdEvalauador(idEvaluador);
	}

}
