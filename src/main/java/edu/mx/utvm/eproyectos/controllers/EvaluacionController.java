package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.model.Evaluacion;

@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController {
	/*Lista de evaluaciones*/
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorUsuario(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("view-evaluaciones");
		//List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		//model.addObject("evaluaciones", evaluaciones);
		return model;
    }
	
	/**/
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView getEvaluadorForm(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevaEvaluacion");		
		return model;
    }
	
	@RequestMapping(value="/form/save", method=RequestMethod.POST)
    public ModelAndView saveFormEvaluacion(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("all");		
		return model;
    }
	 
	@RequestMapping(value="/proyecto/{idEvaluacion}", method=RequestMethod.GET)
    public ModelAndView getProyectoByEvaluacion(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");		
		return model;
    }
	
	@RequestMapping(value="/proyecto/form", method=RequestMethod.GET)
    public ModelAndView getProyectoByEvaluadorForm(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoProyecto");		
		return model;
    }
	
	@RequestMapping(value="/proyecto/form/save", method=RequestMethod.POST)
    public ModelAndView saveFormProyecto(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");		
		return model;
    }
}
