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
@RequestMapping("/evaluador")
public class EvaluadorController {
	
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
	@RequestMapping(value="/proyecto/{idEvaluador}", method=RequestMethod.GET)
    public ModelAndView getProyectosPorEvaluador(
    		HttpServletRequest request,
    		@PathVariable("idEvaluador") String idEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("proyectoEvaluar");	
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