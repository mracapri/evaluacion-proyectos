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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.services.EvaluacionService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private EvaluacionService evaluacionService;
	
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
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("resultadoFinal");
		return model;
    }
	
	@RequestMapping(value="/jsonResult", method = RequestMethod.GET)
	public String getEncuestas(ModelMap model, HttpServletRequest request, 								
			HttpServletResponse response){								 		
						
		Map<String, Map> proyecto = new HashMap<String, Map>();		
		Categoria categoria = new Categoria(1, "nueva");
		Proyecto proyecto1 = new Proyecto("asdasd23423", "asdasdas", categoria, "asdasd");		
		
		model.put("proyectos", proyecto1);
							
		return "jsonView"; 
	}	
	
}
