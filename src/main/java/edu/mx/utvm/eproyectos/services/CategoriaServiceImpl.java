package edu.mx.utvm.eproyectos.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.dao.CategoriaDao;
import edu.mx.utvm.eproyectos.dao.EvaluacionDao;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
/*
 * Implementacion del servicio <Evaluacion>
 * 
 * @author Mario Rivera
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private CategoriaDao dao;
	
	@Autowired
	private Catalogos catalogos;

	@Override
	public Categoria read(Integer id) {
		return dao.read(id);
	}

	@Override
	public List<Categoria> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void create(String descripcion) throws Exception {
		Categoria categoria = new Categoria(dao.getId(), descripcion);
		dao.create(categoria);
		catalogos.afterPropertiesSet();
	}
	
	@Override
	@Transactional
	public void create(Categoria newInstance) {		
		dao.create(newInstance);
	}

	@Override
	@Transactional
	public void update(Categoria transientObject) {
		dao.update(transientObject);
		
	}

	@Override
	@Transactional
	public void delete(Categoria persistentObject) throws DataIntegrityViolationException{
		dao.delete(persistentObject);
	}

}
