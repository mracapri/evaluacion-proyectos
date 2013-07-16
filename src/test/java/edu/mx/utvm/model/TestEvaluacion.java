package edu.mx.utvm.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestEvaluacion {

	private Evaluacion evaluacion;	
	private List<Evaluador> evaluadores;
	private List<Categoria> categorias;
	
	@Before
	public void cargandoRubricas() {
		// TODO Auto-generated method stub
	}
	
	@Before
	public void cargandoCategorias() {
		/*Categoria*/
		Categoria categoria1 = new Categoria();
		categoria1.setDescripcion("Diseño web");
		
		categorias = new ArrayList<Categoria>();
		categorias.add(categoria1);
	}
	
	@Test
	public void creandoEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");
		assertTrue(evaluacion.getEvaluadores() != null);
		assertTrue(evaluacion.getEvaluadores().size() == 0);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}
	
	@Test
	public void agregandoEvaluadoresALaEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");
		evaluacion.getEvaluadores().add(new Evaluador(1, "Noe Abelino", "Desarrollo web"));
		assertTrue(evaluacion.getEvaluadores() != null);
		assertTrue(evaluacion.getEvaluadores().size() > 0);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}
	
	@Test
	public void agregandoProyectosALaEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");

		Proyecto p = new Proyecto("Desarrollo de videojuegos", categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().add(p);
		assertTrue(evaluacion.getProyectos().size() == 1);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}
}
