package edu.mx.utvm.eproyectos.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

public class TestEvaluacionController {

	@Test
	public void testRequestEvaluacionAll() throws ServletException, IOException {
		EvaluacionController controller = new EvaluacionController();
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		ModelAndView modelAndView = controller.getEvaluacionesPorUsuario(
				request, response);
		Assert.assertTrue(modelAndView.getViewName().equals("view-evaluaciones"));
	}
}
