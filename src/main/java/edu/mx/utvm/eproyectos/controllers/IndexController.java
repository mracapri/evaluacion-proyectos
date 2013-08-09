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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {


	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView handleIndexRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/creditos", method = RequestMethod.GET)
	public ModelAndView handleBlog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("creditos");
		return model;
	}

}