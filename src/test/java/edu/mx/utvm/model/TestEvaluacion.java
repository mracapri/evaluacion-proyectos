package edu.mx.utvm.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestEvaluacion {

	private List<Categoria> categorias;
	private List<ItemRubrica> itemsRubricas;
	private Escala escala1;
	private List<RubricaCategoria> rubricasCategoria;
	
	
	@Before
	public void cargandoItemsRubricasConEscala() {
		//Creando escala
		escala1 = new Escala(0, 10);
		
		//Cargando categorias
		Categoria categoria1 = new Categoria(0,"desarrollo web");		

		categorias = new ArrayList<Categoria>();
		categorias.add(categoria1);
		
		ItemRubrica itemRubrica1 = new ItemRubrica(
				"Revision de estructura de codigo",
				"Revisar que el codigo este estructurado, nombre de variables, utilizacion de elementos", escala1);
		ItemRubrica itemRubrica2 = new ItemRubrica("Base de datos",
				"Estructura de base de datos y su administracion", escala1);
		ItemRubrica itemRubrica3 = new ItemRubrica("Diseño web",
				"Adaptacion de estilos, Compatibilidad con navegadores",
				escala1);
		ItemRubrica itemRubrica4 = new ItemRubrica("Analisis del proyecto",
				"Metodologias utilizadas, Herramientas de analisis", escala1);
		ItemRubrica itemRubrica5 = new ItemRubrica(
				"Herraminetas de desarrollo",
				"Utilizacion aceptable de la herramineta de desarrollo",
				escala1);

		itemsRubricas = new ArrayList<ItemRubrica>();
		itemsRubricas.add(itemRubrica1);
		itemsRubricas.add(itemRubrica2);
		itemsRubricas.add(itemRubrica3);
		itemsRubricas.add(itemRubrica4);
		itemsRubricas.add(itemRubrica5);
		
		rubricasCategoria = new ArrayList<RubricaCategoria>();
		RubricaCategoria rubricaCategoria = new RubricaCategoria(categorias.get(0), itemsRubricas);
		rubricasCategoria.add(rubricaCategoria);

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
		evaluacion.getEvaluadores().add(new Evaluador(1, "Noe Abelino", "TIC"));
		assertTrue(evaluacion.getEvaluadores() != null);
		assertTrue(evaluacion.getEvaluadores().size() > 0);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}

	@Test
	public void agregandoProyectosALaEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");

		Proyecto p = new Proyecto("Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().add(p);
		assertTrue(evaluacion.getProyectos().size() == 1);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}

	@Test
	public void agregandoIntegrantesAlProyecto() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");

		Proyecto p = new Proyecto("Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().add(p);

		p.getIntegrantes().add("Gerardo");
		p.getIntegrantes().add("Armando");
		p.getIntegrantes().add("Leonardo");
		p.getIntegrantes().add("Adrian");

		assertTrue(p.getIntegrantes().size() > 1);
		System.out.println(ToStringBuilder.reflectionToString(p));
	}

	@Test
	public void agregandoRubricaAProyecto() {
		Evaluacion evaluacion = new Evaluacion("Evaluacion 2013");

		Proyecto p = new Proyecto("Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().add(p);		
		
		
	}
	
	

}
