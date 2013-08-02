package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;

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

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.services.EvaluacionService;
import edu.mx.utvm.eproyectos.services.EvaluadorService;

@Controller
@RequestMapping("/evaluador")
@SessionAttributes({"evaluacion"})
public class EvaluadorController {
	
	@Autowired
	private EvaluadorService evaluadorService;
	
	@Autowired
	private EvaluacionService evaluacionService;

	protected final Log log = LogFactory.getLog(getClass());
	
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/mostrar/rubrica/categoria/{idProyecto}", method=RequestMethod.GET)
    public ModelAndView mostrarRubricaCategoriaEvaluacion(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("evaluacion") Evaluacion evaluacion, 
    		@PathVariable("idProyecto") String idProyecto)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("rubricaCategoria");	
		log.debug("idEvaluacion: " + evaluacion.getIdEvaluacion());
		
		// TODO: buscar el proyecto en la lista de proyectos
		log.debug("Proyecto: " + evaluacion.getProyectos().get(idProyecto));
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
