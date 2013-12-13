package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormCategoria;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
@SessionAttributes({ "categoriaAModificar" })
public class CategoriaController {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private Catalogos catalogos;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getCategoriasAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("categorias");
		model.addObject("categorias", catalogos.getCatalogoCategorias());
		return model;
	}

	@RequestMapping(value = "/delete/{idCategoria}", method = RequestMethod.GET)
	public ModelAndView eliminarCategoria(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("idCategoria") int idCategoria)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView("categorias");
		Categoria read = categoriaService.read(idCategoria);
		
		try {
			categoriaService.delete(read);			
		} catch (DataIntegrityViolationException e) {
			// TODO: Enviar los mensajes a travez del archivo de propiedades
			model.addObject("mensajeError", "Esta categoria, tiene asignados proyectos. Por eso " +
					"no pueden ser eliminada. Gracias!");
		}
		model.addObject("categorias", catalogos.getCatalogoCategorias());
		return model;
	}
	
	@RequestMapping(value = "/modify/{idCategoria}", method = RequestMethod.GET)
	public ModelAndView modificarForm(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("idCategoria") int idCategoria)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView("modify-categoria");
		Categoria read = categoriaService.read(idCategoria);

		FormCategoria formCategoria = new FormCategoria();
		formCategoria.setDescripcion(read.getDescripcion());
		model.addObject("formCategoria", formCategoria);
		model.addObject("categoriaAModificar", read);
		return model;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modificarFormSave(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("categoriaAModificar") Categoria categoria,
			@ModelAttribute("formCategoria") @Valid FormCategoria formCategoria, 
			BindingResult result)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView("redirect:all");

		Categoria categoriaParaModificar = new Categoria(
				categoria.getIdCategoria(), formCategoria.getDescripcion());

		if(!result.hasErrors()){
			categoriaService.update(categoriaParaModificar);	
		}else{
			model.addObject("result", result);
		}
		
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newCategoriaForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("new-categoria");
		model.addObject("formCategoria", new FormCategoria());
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView saveCategoriaForm(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("formCategoria") @Valid FormCategoria categoria,
			BindingResult result) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("redirect:all");
		if (!result.hasErrors()) {
			try {
				categoriaService.create(categoria.getDescripcion());
			} catch (Exception e) {
				// TODO: Definir el error para cargar catalogos;
			}
		} else {
			model.addObject("result", result);
		}

		return model;
	}

	@InitBinder({ "formCategoria" })
	protected void initBinder(WebDataBinder webDataBinder) {
	}
}
