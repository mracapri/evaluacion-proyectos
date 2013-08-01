package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormEvaluacion;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormProyecto;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.services.EvaluacionService;
import edu.mx.utvm.eproyectos.services.ProyectoService;

@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController {
	
	@Autowired
	private EvaluacionService evaluacionService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private Catalogos catalogos;
	
	/*Lista de evaluaciones*/
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorUsuario(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("adminEvaluaciones");
		List<Evaluacion> evaluaciones = evaluacionService.findAll();
		model.addObject("evaluaciones", evaluaciones);
		return model;
    }
	
	/*Formulario de nuevo y actualizar evaluacion*/
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView getEvaluadorForm(HttpServletRequest request,
    		@ModelAttribute("formEvaluacion") FormEvaluacion formEvalaucion,
    		HttpServletResponse response)    		
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevaEvaluacion");		
		return model;
    }
	
	/*Guardar formulario de evaluacion*/
	@RequestMapping(value="/form", method=RequestMethod.POST)
    public ModelAndView saveFormEvaluacion(
    		HttpServletRequest request,
    		@ModelAttribute("formEvaluacion") @Valid FormEvaluacion formEvalaucion,    		
    		BindingResult result)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevaEvaluacion");
		if(!result.hasErrors()){
			
			/*Save evaluacion*/					
			Evaluacion evaluacion = new Evaluacion("aslhdkgadasasdasd", formEvalaucion.getDescripcion());
			evaluacion.setDescripcionDetallada(formEvalaucion.getDescripcionDetallada());
			evaluacion.setFechaCreacion(new Date());
			
			evaluacionService.create(evaluacion);
			
			model.addObject("message", "Evaluaci&oacuten almacenada");
			model.setViewName("nuevaEvaluacion");			
		}
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
		
		List<Proyecto> proyectos = proyectoService.findAllByIdEvaluacion(idEvaluacion);
		model.addObject("proyectos", proyectos);
		
		return model;
    }
	
	/*Formulario de nuevo y actualizar proyecto por evalaucion*/
	@RequestMapping(value="/proyecto/form", method=RequestMethod.GET)
    public ModelAndView getProyectoByEvaluadorForm(HttpServletRequest request,
    		@ModelAttribute("formProyecto") FormProyecto formProyecto,
    		HttpServletResponse response)
            throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView("nuevoProyecto");		
		model.addObject("categorias",catalogos.getCategorias());				
		return model;
    }
	
	/*Guardar formulario de proyecto*/
	@RequestMapping(value="/proyecto/form", method=RequestMethod.POST)
    public ModelAndView saveFormProyecto(HttpServletRequest request,
    		@ModelAttribute("formProyecto") @Valid FormProyecto formProyecto,    		
    		BindingResult result)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoProyecto");
		model.addObject("categorias",catalogos.getCategorias());
		if(!result.hasErrors()){
			model.addObject("message", "Evaluaci&oacuten almacenada");
			model.setViewName("nuevoProyecto");
		}
		return model;
    }
}
