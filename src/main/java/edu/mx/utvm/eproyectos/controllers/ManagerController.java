package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
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
import edu.mx.utvm.eproyectos.util.ProyectoRankingComparator;

@Controller
@RequestMapping("/manager")
@SessionAttributes({"idEvaluacion"})
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
	@RequestMapping(value="/option/{idEvaluacion}", method=RequestMethod.GET)
    public ModelAndView optionResult(
    		HttpServletRequest request,  
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("managerOptions");

		model.addObject("idEvalaucion", idEvaluacion);
		return model;
    }
	
	/*Resultados slide por categoria*/
	@RequestMapping(value="/resultados/categoria/{idEvaluacion}", method=RequestMethod.GET)
    public ModelAndView getResultadoFinal(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoRubricaCate");	
		Map<String, Proyecto> proyectos = proyectoService.findAllByIdEvaluacion(idEvaluacion);
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+proyectos);
		model.addObject("proyectos", proyectos);
		return model;
    }
	
	/*lista de proyectos*/
	@RequestMapping(value="/resultados/exposicion/{idEvaluacion}", method=RequestMethod.GET)
    public ModelAndView getListProyectos(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoRubricaExpo");	
		return model;
    }
	
	/*Resultados por proyecto generales*/
	@RequestMapping(value="/resultados/finales/{idEvaluacion}", method=RequestMethod.GET)
    public ModelAndView getResultadoPorProyecto(
    		HttpServletRequest request,
    		@PathVariable("idEvaluacion") String idEvaluacion,
		HttpServletResponse response)
	            throws ServletException, IOException {
			ModelAndView model = new ModelAndView("resultadoFinal");	
			return model;
    }
	
	@RequestMapping(value="/resultados-categoria/{idEvaluacion}.json", method = RequestMethod.GET)
	public @ResponseBody String getResultadosEvaluacion(HttpServletRequest request,	
			@PathVariable("idEvaluacion") String idEvaluacion,
			HttpServletResponse response){								 				
		response.setHeader("content-type", "application/json");	
		
		/*Obtener proyectos por evaluacion*/
		Evaluacion evaluacion = evaluacionService.read(idEvaluacion);
		
		/*
		 * Ciclo de proyectos
		 * */
		for (String idProyecto : evaluacion.getProyectos().keySet()) {
			Proyecto proyecto = evaluacion.getProyectos().get(idProyecto);
			
			proyecto.setFoto(null);
			proyecto.setLogo(null);
			proyecto.setArchivoPresentacion(null);
			
			/*Lista de resultados por proyecto*/
			List<CalificacionEvaluador> resultados = resultadoService.findAllByProyecto(idProyecto);

			ResultadoFinal resultadoFinal = new ResultadoFinal(resultados);			
			
			proyecto.setResultado(resultadoFinal);		
		}
		
		return gson.toJson(evaluacion); 
	}
	
	@RequestMapping(value="/resultados-ranking/{idEvaluacion}.json", method = RequestMethod.GET)
	public @ResponseBody String getResultadosProyecto(HttpServletRequest request,
			@PathVariable("idEvaluacion") String idEvaluacion,
			HttpServletResponse response){								 				
		response.setHeader("content-type", "application/json");	
		
		/*Obtener proyectos por evaluacion*/
		Evaluacion evaluacion = evaluacionService.read(idEvaluacion);
		
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		/*
		 * Ciclo de proyectos
		 * */
		for (String idProyecto : evaluacion.getProyectos().keySet()) {
			Proyecto proyecto = evaluacion.getProyectos().get(idProyecto);
			
			proyecto.setFoto(null);
			proyecto.setLogo(null);
			proyecto.setArchivoPresentacion(null);			
			
			/*Lista de resultados por proyecto*/
			List<CalificacionEvaluador> resultados = resultadoService.findAllByProyecto(idProyecto);

			/* agreando resultado final */
			ResultadoFinal resultadoFinal = new ResultadoFinal(resultados);						
			proyecto.setResultado(resultadoFinal);
			
			/* agrengando a la lista de proyectos */
			proyectos.add(proyecto);
		}
		
		// ordenando la lista para el ranking
		Collections.sort( proyectos, new ProyectoRankingComparator());
		
		return gson.toJson(proyectos); 
	}
}
