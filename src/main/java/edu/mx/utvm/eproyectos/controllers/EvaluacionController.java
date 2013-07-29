package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.services.EvaluacionService;

@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionService service;
	
	/*Lista de evaluaciones*/
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorUsuario(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("adminEvaluaciones");
		//List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		//model.addObject("evaluaciones", evaluaciones);
		return model;
    }
	
	/*Formulario de nuevo y actualizar evaluacion*/
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView getEvaluadorForm(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("altaEvaluacion");		
		return model;
    }
	
	/*Guardar formulario de evaluacion*/
	@RequestMapping(value="/form/save", method=RequestMethod.POST)
    public ModelAndView saveFormEvaluacion(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("adminEvaluaciones");	
		return model;
    }
	
	/*Lista de proyectos por evaluacion*/
	@RequestMapping(value="/{idEvaluacion}/proyectos", method=RequestMethod.GET)
    public ModelAndView getProyectoByEvaluacion(
    		HttpServletRequest request, 
    		@PathVariable("idEvaluacion") String idEvaluacion,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");		
		return model;
    }
	
	/*Formulario de nuevo y actualizar proyecto por evalaucion*/
	@RequestMapping(value="/proyecto/form", method=RequestMethod.GET)
    public ModelAndView getProyectoByEvaluadorForm(
    		HttpServletRequest request,     		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoProyecto");		
		return model;
    }
	
	/*Guardar formulario de proyecto*/
	@RequestMapping(value="/proyecto/form/save", method=RequestMethod.POST)
    public ModelAndView saveFormProyecto(
    		HttpServletRequest request,     		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");		
		return model;
    }
}
