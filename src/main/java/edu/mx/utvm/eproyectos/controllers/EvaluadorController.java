package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.services.EvaluacionService;
import edu.mx.utvm.eproyectos.services.EvaluadorService;
import edu.mx.utvm.eproyectos.services.RubricaService;

@Controller
@RequestMapping("/evaluador")
@SessionAttributes({"evaluacion", "proyecto", "evaluador", "rubrica"})
public class EvaluadorController {
	
	@Autowired
	private EvaluadorService evaluadorService;
	
	@Autowired
	private EvaluacionService evaluacionService;
	
	@Autowired
	private RubricaService rubricaService;	

	protected final Log log = LogFactory.getLog(getClass());
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/rubrica/save", method=RequestMethod.POST)
    public ModelAndView saveCalificacionRubrica(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("evaluacion") Evaluacion evaluacion, 
    		@ModelAttribute("evaluador") Evaluador evaluador,
    		@ModelAttribute("proyecto") Proyecto proyecto,
    		@ModelAttribute("rubrica") Rubrica rubrica)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("redirect:/resolver/evaluador/proyectos");	
		log.debug("Guardando rubrica evaluacion");
		log.debug("idEvaluacion: " + evaluacion.getIdEvaluacion());
		log.debug("idEvaluador: " + evaluador.getIdEvaluador());
		log.debug("idProyecto: " + proyecto.getIdProyecto());
		Map<Integer, Double> resultadoPorItem = new HashMap<Integer, Double>();
		
		// saca los parametros de la peticion
		for(Object key : request.getParameterMap().keySet()){
			String keyString = (String) key;
			int indexItemRubrica = Integer.parseInt(keyString.substring(7, keyString.length()));
			String value = (String) request.getParameter(keyString);
			double calificacion = Double.parseDouble(value);
			resultadoPorItem.put(indexItemRubrica, calificacion);
		}
		
		// Crea la calificacion del evaluador
		CalificacionEvaluador calificacionEvaluador = new CalificacionEvaluador(evaluador, resultadoPorItem, rubrica);
		
		return model;
    }
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/mostrar/rubrica/presentacion/{idProyecto}", method=RequestMethod.GET)
    public ModelAndView mostrarRubricaPresentacionEvaluacion(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("evaluacion") Evaluacion evaluacion, 
    		@PathVariable("idProyecto") String idProyecto)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("muestraRubricaAEvaluar");	
		log.debug("idEvaluacion: " + evaluacion.getIdEvaluacion());
		
		Proyecto proyecto = evaluacion.getProyectos().get(idProyecto);
		log.debug("Proyecto: " + proyecto);
		
		if(proyecto != null){
			Rubrica rubrica = rubricaService.obtenerRubricaPorPresentacion();
			model.addObject("rubrica", rubrica);
			model.addObject("proyecto", proyecto);
			model.addObject("tipoRubrica", "porPresentacion");
		}
		
		return model;
    }
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/mostrar/rubrica/categoria/{idProyecto}", method=RequestMethod.GET)
    public ModelAndView mostrarRubricaCategoriaEvaluacion(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("evaluacion") Evaluacion evaluacion, 
    		@PathVariable("idProyecto") String idProyecto)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("muestraRubricaAEvaluar");	
		log.debug("idEvaluacion: " + evaluacion.getIdEvaluacion());
		
		Proyecto proyecto = evaluacion.getProyectos().get(idProyecto);
		log.debug("Proyecto: " + proyecto);
		
		if(proyecto != null){
			Rubrica rubrica = rubricaService.obtenerRubricaPorCategoriaDeProyecto(proyecto);
			model.addObject("rubrica", rubrica);
			model.addObject("proyecto", proyecto);
			model.addObject("tipoRubrica", "porCategoria");
		}
	
		return model;
    }
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/{idEvaluador}", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorEvaluador(
    		HttpServletRequest request,
    		@PathVariable("idEvaluador") String idEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("evaluadorEvaluaciones");	
		return model;
    }
	
	/*Lista proyectos por evaluador*/
	@RequestMapping(value="/proyectos", method=RequestMethod.GET)
    public ModelAndView getProyectosPorEvaluador(
    		HttpServletRequest request,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoParaEvaluar");
		
		String usuario = "mracapri";
		Evaluador readByNombreUsuario = evaluadorService.readByNombreUsuario(usuario);
		if(readByNombreUsuario !=  null){
			Evaluacion evaluacion = evaluacionService.readByIdEvalauador(readByNombreUsuario.getIdEvaluador());
			model.addObject("evaluacion", evaluacion);
			model.addObject("evaluador", readByNombreUsuario);
		}
		return model;
    }
	
	/*Formulario de items Rubrica*/
	@RequestMapping(value="/rubrica/form/{idEvaluador}", method=RequestMethod.GET)
    public ModelAndView getListRubrica(
    		HttpServletRequest request,
    		@PathVariable("idEvaluador") String idEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = null;
		if(idEvaluador.equals("1")){
			model = new ModelAndView("rubricaCategoria");
		}else{
			model = new ModelAndView("rubricaExposicion");
		}		
		
		return model;
    }
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/rubrica/form/save/categoria", method=RequestMethod.POST)
    public ModelAndView saveRubricaCategoria(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView("managerProyectos");
		return model;
    }
	
	@RequestMapping(value="/rubrica/form/save/proyectos", method=RequestMethod.POST)
    public ModelAndView saveRubricaExposicion(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView("managerProyectos");
		return model;
    }
}
