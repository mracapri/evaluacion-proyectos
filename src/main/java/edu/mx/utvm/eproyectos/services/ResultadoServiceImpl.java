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
import edu.mx.utvm.eproyectos.model.ResultadoFinal;
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
	public ResultadoFinal read(String idProyecto) {		
		List<CalificacionEvaluador> evaluaciones = resultadoDao.findAllByProyecto(idProyecto);
		ResultadoFinal resultadoFinal = new ResultadoFinal(evaluaciones);
		return resultadoFinal;
	}

	@Override
	public void create(CalificacionEvaluador newInstance,
			Evaluacion evaluacion, Proyecto proyecto) {
		boolean laRubricaYaFueCapurada = resultadoDao.laRubricaYaFueCapuradaParaElProyecto(proyecto, newInstance);
		if(!laRubricaYaFueCapurada){
			resultadoDao.create(newInstance, evaluacion, proyecto);	
		}
	}

	@Override
	public boolean laRubricaYaFueCapuradaParaElProyecto(Proyecto proyecto,
			CalificacionEvaluador calificacionEvaluador) {
		return resultadoDao.laRubricaYaFueCapuradaParaElProyecto(proyecto, calificacionEvaluador);
	}

	@Override
	public List<CalificacionEvaluador> findAllByProyecto(String idProyecto) {
		return resultadoDao.findAllByProyecto(idProyecto);
	}
	
	
}
