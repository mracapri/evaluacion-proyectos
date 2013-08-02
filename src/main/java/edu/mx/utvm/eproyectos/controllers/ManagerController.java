package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Resultado;
import edu.mx.utvm.eproyectos.model.ResultadoFinal;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.services.EvaluacionService;
import edu.mx.utvm.eproyectos.services.EvaluadorService;
import edu.mx.utvm.eproyectos.services.ProyectoService;
import edu.mx.utvm.eproyectos.services.ResultadoService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private EvaluacionService evaluacionService;
	
	@Autowired
	private ResultadoService resultadoService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private EvaluadorService evaluadorService;
	
	@Autowired
	private Catalogos catalogos;
	
	@Autowired
	private Gson gson;
	
	/*Lista de evaluaciones*/
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorUsuario(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("managerEvaluaciones");
		List<Evaluacion> evaluaciones = evaluacionService.findAll();
		model.addObject("evaluaciones", evaluaciones);		
		return model;
    }
	
	/*Opcion de resultados por categoria o por exposicion*/
	@RequestMapping(value="/option", method=RequestMethod.GET)
    public ModelAndView optionResult(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("managerOptions");	
		return model;
    }
	
	/*Resultados slide por categoria*/
	@RequestMapping(value="/resultados/categoria", method=RequestMethod.GET)
    public ModelAndView getResultadoFinal(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoRubricaCate");	
		return model;
    }
	
	/*lista de proyectos*/
	@RequestMapping(value="/resultados/exposicion", method=RequestMethod.GET)
    public ModelAndView getListProyectos(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoRubricaExpo");	
		return model;
    }
	
	/*Resultados por proyecto generales*/
	@RequestMapping(value="/resultados/finales", method=RequestMethod.GET)
    public ModelAndView getResultadoPorProyecto(
    		HttpServletRequest request,    		
    		BindingResult result)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoFinal");
		return model;
    }
	
	@RequestMapping(value="/resultados-categoria.json", method = RequestMethod.GET)
	public @ResponseBody String getEncuestas(HttpServletRequest request,			
			HttpServletResponse response){								 				
		response.setHeader("content-type", "application/json");	
		
		/*Obtener proyectos por evaluacion*/
		Evaluacion evaluacion = evaluacionService.read("25bbdcd06c32d477f7fa1c3e4a91b032");
		
		/*
		 * Ciclo de proyectos
		 * */
		for (String idProyecto : evaluacion.getProyectos().keySet()) {
			Proyecto proyecto = evaluacion.getProyectos().get(idProyecto);
			
			/*Lista de resultados por proyecto*/
			List<Resultado> resultados = resultadoService.findAllByProyecto(proyecto.getIdProyecto());
			
			/*Lista vacia de calificacion evaluadores*/
			List<CalificacionEvaluador> calificacionEvaluadores = new ArrayList<CalificacionEvaluador>();
			
			/*Objeto evaluador*/
			Evaluador evaluador = null;
			
			/*Objeto rubrica*/
			Rubrica rubrica = null;
			
			/*Mapa resultados por item*/
			Map<Integer, Double> resultadoPorItem = new HashMap<Integer, Double>();
			
			/*
			 * Ciclo de resultados
			 * */
			for (Resultado resultado : resultados) {
				/*Evaluador por proyecto*/
				evaluador = evaluadorService.read(resultado.getIdEvaluador());				
				
				/*Rubrica*/
				rubrica = catalogos.getRubricas().get(resultado.getIdRubrica());				
				
				/*Asignando Calificaciones*/						
				resultadoPorItem.put(resultado.getIdItemRubrica(), resultado.getCalificacion());
				
			}
			
			CalificacionEvaluador calificacionEvaluador = new CalificacionEvaluador(evaluador, resultadoPorItem, rubrica);
			calificacionEvaluadores.add(calificacionEvaluador);
			
			ResultadoFinal resultadoFinal = new ResultadoFinal(calificacionEvaluadores);			
			
			proyecto.setResultado(resultadoFinal);		
		}
		
		return gson.toJson(evaluacion); 
	}
	
}
