package edu.mx.utvm.eproyectos.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.eproyectos.dao.ResultadoDao;
import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
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
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public Resultado read(Integer id) {		
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void update(Resultado transientObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void delete(Resultado persistentObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public List<Resultado> findAll() {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void create(CalificacionEvaluador newInstance,
			Evaluacion evaluacion, Proyecto proyecto) {
		resultadoDao.create(newInstance, evaluacion, proyecto);
	}
	
}
