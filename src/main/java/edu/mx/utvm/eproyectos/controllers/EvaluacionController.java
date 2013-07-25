package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mx.utvm.eproyectos.model.Evaluacion;

@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController {
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ModelAndView getEvaluacionesPorUsuario(
    		HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("view-evaluaciones");
		List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		model.addObject("evaluaciones", evaluaciones);
		return model;
    }
}
