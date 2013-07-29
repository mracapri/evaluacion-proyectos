package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	/*Lista de evaluaciones por evaluador*/
	@RequestMapping(value="/evaluacion/{idEvaluador}", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorEvaluador(
    		HttpServletRequest request,
    		@PathVariable("idEvaluador") String idEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("managerEvaluaciones");	
		return model;
    }
	
	/*Opcion de resultados por categoria o por exposicion*/
	@RequestMapping(value="/option", method=RequestMethod.GET)
    public ModelAndView optionResult(
    		HttpServletRequest request,    		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("");	
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
	@RequestMapping(value="/proyecto/{idEvaluador}", method=RequestMethod.GET)
    public ModelAndView getListProyectos(
    		HttpServletRequest request,
    		@PathVariable("idEvaluador") String idEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");	
		return model;
    }
	
	/*Resultados por proyecto generales*/
	@RequestMapping(value="/resultados/proyecto/{idProyecto}", method=RequestMethod.GET)
    public ModelAndView getResultadoPorProyecto(
    		HttpServletRequest request,
    		@PathVariable("idProyecto") String idProyecto,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoRubricaExpo");
		//ModelAndView model = new ModelAndView("resultadoFinal");	
		return model;
    }
	
}
