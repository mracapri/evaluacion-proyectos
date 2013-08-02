package edu.mx.utvm.eproyectos.controllers;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/js")
public class JSController {
	
	protected final Log log = LogFactory.getLog(getClass());	
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = "/global", method = RequestMethod.GET)
	public @ResponseBody
	String byPath() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/x-javascript"));
		String javascript = "var URL_APP = '" + context.getContextPath() + "';";
		javascript = javascript + "var URL_APP_SERVICE = '" + context.getContextPath() + "/resolver';";
		javascript = javascript + "var TEST = true;";
		return javascript;
	}
}
