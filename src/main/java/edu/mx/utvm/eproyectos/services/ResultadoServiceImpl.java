package edu.mx.utvm.eproyectos.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.eproyectos.dao.ResultadoDao;
import edu.mx.utvm.eproyectos.model.Resultado;
/*
 * Implementacion del servicio <Resultado>
 * 
 * @author Emmanuel
 */
@Service
public class ResultadoServiceImpl implements ResultadoService {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	ResultadoDao resultadoDao;

	@Override
	public void create(Resultado newInstance) {
		resultadoDao.create(newInstance);
	}

	@Override
	public Resultado read(Integer id) {		
		return resultadoDao.read(id);
	}

	@Override
	public void update(Resultado transientObject) {
		resultadoDao.update(transientObject);
	}

	@Override
	public void delete(Resultado persistentObject) {
		resultadoDao.delete(persistentObject);
	}

	@Override
	public List<Resultado> findAll() {
		return resultadoDao.findAll();
	}

	@Override
	public List<Resultado> findAllByProyecto(String id) {		
		return resultadoDao.findAllByProyecto(id);
	}
	
	
}
