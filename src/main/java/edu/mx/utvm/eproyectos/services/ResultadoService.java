package edu.mx.utvm.eproyectos.services;

import java.util.List;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.ResultadoFinal;

public interface ResultadoService {
 	void create(CalificacionEvaluador newInstance, Evaluacion evaluacion, Proyecto proyecto);
 	ResultadoFinal read(String idProyecto, int exposicionPor);
 	boolean laRubricaYaFueCapuradaParaElProyecto(Proyecto proyecto, CalificacionEvaluador calificacionEvaluador);
 	List<CalificacionEvaluador> findAllByProyecto(String idProyecto);
}
