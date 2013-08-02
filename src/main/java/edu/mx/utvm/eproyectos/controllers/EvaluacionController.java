package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormEvaluacion;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormEvaluador;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormProyecto;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.services.EvaluacionService;
import edu.mx.utvm.eproyectos.services.EvaluadorService;
import edu.mx.utvm.eproyectos.services.ProyectoService;
import edu.mx.utvm.eproyectos.util.KeyGenerator;

@Controller
@RequestMapping("/evaluacion")
@SessionAttributes({"evaluacionObj", "evaluacion"})
public class EvaluacionController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private EvaluacionService evaluacionService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private EvaluadorService evaluadorService;
	
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
			Evaluacion evaluacion = new Evaluacion(KeyGenerator.uuid(), formEvalaucion.getDescripcion());
			evaluacion.setDescripcionDetallada(formEvalaucion.getDescripcionDetallada());
			evaluacion.setFechaCreacion(new Date());
			
			evaluacionService.create(evaluacion);
			
			model.addObject("evaluacionObj",evaluacion);
			request.getSession().setAttribute("evaluacionObj", evaluacion);
			
			
			return new ModelAndView("redirect:/resolver/evaluacion/all");		
		}
		return model;
    }
	
	/*Lista de evaluadores*/
	@RequestMapping(value="/evaluadores", method=RequestMethod.GET)
    public ModelAndView getEvaluadoresList(HttpServletRequest request,     		
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("adminEvaluadores");		
				
		model.addObject("evaluadores",evaluadorService.findAll());				
		return model;
    }
	
	/*Formulario evalaudores*/
	@RequestMapping(value="/evaluadores/form", method=RequestMethod.GET)
    public ModelAndView getEvaluadoresForm(HttpServletRequest request,  
    		@ModelAttribute("formEvaluador") FormEvaluador formEvaluador,
    		HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoEvaluador");		
		
		return model;
    }
	
	/*Formulario evalaudores POST*/
	@RequestMapping(value="/evaluadores/form", method=RequestMethod.POST)
    public ModelAndView getEvaluadoresFormSave(HttpServletRequest request,      		
    		@ModelAttribute("formEvaluador") @Valid FormEvaluador formEvaluador,
    		BindingResult result)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoEvaluador");				
		if(!result.hasErrors()){
			
			Evaluador evaluador = new Evaluador(KeyGenerator.uuid(), formEvaluador.getNombre(), formEvaluador.getEspecialidad(), formEvaluador.getUsuario(), formEvaluador.getPassword());
			//Evaluacion evaluacion = new Evaluacion("25bbdcd06c32d477f7fa1c3e4a91b032", "otra");
			//evaluadorService.create(evaluador,evaluacion);
			log.info("xxxxxxxxxxxxxxxxxxxxxxxxxx"+request.getSession().getAttribute("evaluacionObj"));
			model.addObject("message", "Evaluador Almacenado");
			model.setViewName("nuevoEvaluador");	
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
		
		Evaluacion read = evaluacionService.read(idEvaluacion);
		
		model.addObject("evaluacion", read);
		
		Map<String, Proyecto> proyectos = proyectoService.findAllByIdEvaluacion(idEvaluacion);
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
	
	/* muestra el logo del proyecto */
	@RequestMapping(value="/proyecto/logo/{idProyecto}", method=RequestMethod.GET)
    public void showLogoProyecto(@PathVariable("idProyecto") String idProyecto, HttpServletRequest request,
    		HttpServletResponse response)
            throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView("nuevoProyecto");
		Proyecto read = proyectoService.read(idProyecto);
		
		
    	if(read != null && read.getLogo() !=null && read.getLogo().length > 0){
    		response.getOutputStream().write(read.getLogo());
		}
    }
	
	@RequestMapping(value="/proyecto/presentacion/{idProyecto}", method=RequestMethod.GET)
    public void showPresentacionProyecto(@PathVariable("idProyecto") String idProyecto, HttpServletRequest request,
    		HttpServletResponse response)
            throws ServletException, IOException {
		
		ModelAndView model = new ModelAndView("nuevoProyecto");
		Proyecto read = proyectoService.read(idProyecto);
		
		response.setContentType("application/pdf");
		
    	if(read != null && read.getArchivoPresentacion() !=null && read.getArchivoPresentacion().length > 0){
    		response.getOutputStream().write(read.getArchivoPresentacion());
		}
    }
	
	/*Guardar formulario de proyecto*/
	@RequestMapping(value="/proyecto/form", method=RequestMethod.POST)
    public ModelAndView saveFormProyecto(HttpServletRequest request,
    		@ModelAttribute("evaluacion") Evaluacion evaluacion,
    		@ModelAttribute("formProyecto") @Valid FormProyecto formProyecto,
    		BindingResult result)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("nuevoProyecto");
		model.addObject("categorias",catalogos.getCategorias());		
		if(!result.hasErrors()){						
			Categoria categoria = catalogos.getCategorias().get(formProyecto.getIdCategoria());
			
			Proyecto proyecto = new Proyecto(KeyGenerator.uuid(), formProyecto.getNombre(), categoria, formProyecto.getLider());			
			proyecto.getIntegrantes().add(formProyecto.getIntegrantes());
			proyecto.setLogo(formProyecto.getLogo().getBytes());
			proyecto.setArchivoPresentacion(formProyecto.getFilePdf().getBytes());
			proyecto.setFoto(formProyecto.getFotoEquipo().getBytes());
			
			log.info("clase..........."+request.getSession().getAttribute("evaluacionObj"));			
			
			proyectoService.create(proyecto,evaluacion);
			
			model.addObject("message", "Proyecto Almacenado");
			model.setViewName("nuevoProyecto");
						
		}else{
			model.addObject("result", result);
		}
		log.info(result);
		return model;
    }
	
	@InitBinder("formProyecto")
	protected void initBinder(WebDataBinder webDataBinder) {
	}
}
