package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.SessionAttributes;
=======
>>>>>>> c54b648dd1c205e3d59bf4cf5bcec723b58989a6
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
<<<<<<< HEAD
	
	// Este es loguer
	protected final Log log = LogFactory.getLog(getClass());	


    @RequestMapping(value="/login",  method = RequestMethod.GET)
    public ModelAndView handleIndexRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView("login");
		return model;
    }
	
   
	
=======

	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView handleIndexRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

>>>>>>> c54b648dd1c205e3d59bf4cf5bcec723b58989a6
}