package edu.mx.utvm.eproyectos.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;

import edu.mx.utvm.model.eproyectos.factories.FactoryRubrica;


public class TestEvaluacion {

	private List<Categoria> categorias;
	private List<ItemRubrica> itemsRubricas;
	private Escala escala1;
	private List<RubricaCategoria> rubricasCategoria;
	
	
	@Test
	public void cargandoItemsRubricasConEscala() {
		//Creando escala
		escala1 = new Escala(01,0, 10);
		
		//Cargando categorias
		Categoria categoria1 = new Categoria(0,"desarrollo web");		

		categorias = new ArrayList<Categoria>();
		categorias.add(categoria1);
		
		ItemRubrica itemRubrica1 = new ItemRubrica(1,
				"Revision de estructura de codigo",
				"Revisar que el codigo este estructurado, nombre de variables, utilizacion de elementos", escala1);
		ItemRubrica itemRubrica2 = new ItemRubrica(2,"Base de datos",
				"Estructura de base de datos y su administracion", escala1);
		ItemRubrica itemRubrica3 = new ItemRubrica(3,"Diseño web",
				"Adaptacion de estilos, Compatibilidad con navegadores",
				escala1);
		ItemRubrica itemRubrica4 = new ItemRubrica(4,"Analisis del proyecto",
				"Metodologias utilizadas, Herramientas de analisis", escala1);
		ItemRubrica itemRubrica5 = new ItemRubrica(5,
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



	@Ignore
	public void creandoEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001","Evaluacion 2013");
		assertTrue(evaluacion.getEvaluadores() != null);
		assertTrue(evaluacion.getEvaluadores().size() == 0);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}

	@Ignore
	public void agregandoEvaluadoresALaEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001","Evaluacion 2013");
		evaluacion.getEvaluadores().put(evaluacion.getIdEvaluacion(), new Evaluador("1", "Noe Abelino", "TIC", "QWE123", "ZXCZ"));
		assertTrue(evaluacion.getEvaluadores() != null);
		assertTrue(evaluacion.getEvaluadores().size() > 0);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}

	@Ignore
	public void agregandoProyectosALaEvaluacionVacia() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001", "Evaluacion 2013");
		
		Proyecto p = new Proyecto("130101","Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().put(p.getIdProyecto(), p);
		assertTrue(evaluacion.getProyectos().size() == 1);
		System.out.println(ToStringBuilder.reflectionToString(evaluacion));
	}

	@Ignore
	public void agregandoIntegrantesAlProyecto() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001", "Evaluacion 2013");

		Proyecto p = new Proyecto("130101","Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().put(p.getIdProyecto(), p);

		p.getIntegrantes().add("Gerardo");
		p.getIntegrantes().add("Armando");
		p.getIntegrantes().add("Leonardo");
		p.getIntegrantes().add("Adrian");

		assertTrue(p.getIntegrantes().size() > 1);
		System.out.println(ToStringBuilder.reflectionToString(p));
	}
	
	@Ignore
	public void agregandoProcesoDeEvaluacionConResultados() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001" ,"Evaluacion 2013");
		
		Proyecto p = new Proyecto("130101","Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().put(p.getIdProyecto(), p);
		
		Map<Integer, Double> calificaciones;
		calificaciones = new TreeMap<Integer, Double>();							
		calificaciones.put(0, 9.8);
		calificaciones.put(1, 9.0);
		calificaciones.put(2, 8.0);
		calificaciones.put(3, 8.0);
		calificaciones.put(4, 9.0);									
		
		FactoryRubrica factoryRubrica = new FactoryRubrica();
		CalificacionEvaluador calificacionEvaluador = new CalificacionEvaluador(new Evaluador("1", "Noe Abelino", "TIC", "QWE123", "ZXCZ"), calificaciones, factoryRubrica.getRubrica("1301",categorias.get(0)));								
				
		System.out.println(calificacionEvaluador.calcularTotal());
		System.out.println(ToStringBuilder.reflectionToString(calificacionEvaluador));
	}
	
	@Ignore
	public void agregandoProcesoDeEvaluacionConResultadosPorRubrica() {
		/* Creando una evalucacion */
		Evaluacion evaluacion = new Evaluacion("001","Evaluacion 2013");
		
		Proyecto p = new Proyecto("130101","Desarrollo de videojuegos",
				categorias.get(0), "Isral Ochoa Paz");
		evaluacion.getProyectos().put(p.getIdProyecto(), p);
		
		Map<Integer, Double> calificaciones;
		calificaciones = new TreeMap<Integer, Double>();
		calificaciones.put(0, 9.8);
		calificaciones.put(1, 9.0);
		calificaciones.put(2, 8.0);
		calificaciones.put(3, 8.0);
		calificaciones.put(4, 9.0);
		
		Map<Integer, Double> calificaciones2;
		calificaciones2 = new TreeMap<Integer, Double>();
		calificaciones2.put(0, 9.8);
		calificaciones2.put(1, 9.0);
		calificaciones2.put(2, 8.0);
		calificaciones2.put(3, 8.0);
		calificaciones2.put(4, 10.0);
		
		FactoryRubrica factoryRubrica = new FactoryRubrica(); 
		
		CalificacionEvaluador calificacionEvaluador = new CalificacionEvaluador(new Evaluador("1", "Noe Abelino", "TIC", "QWE123", "ZXCZ"), calificaciones, factoryRubrica.getRubrica("1301",new Categoria(0, "dessarrollo web")));					
		CalificacionEvaluador calificacionEvaluador2 = new CalificacionEvaluador(new Evaluador("2", "Mario", "TIC", "QWE123", "ZXCZ"), calificaciones2, factoryRubrica.getRubrica("1301"));
		
		List<CalificacionEvaluador> calificacionEvaluadoresList = new ArrayList<CalificacionEvaluador>();		
		calificacionEvaluadoresList.add(calificacionEvaluador);
		calificacionEvaluadoresList.add(calificacionEvaluador2);
		
		ResultadoFinal resultado = new ResultadoFinal(calificacionEvaluadoresList);
		
		System.out.println("Ultima prueba");
		System.out.println(resultado.calcularTotal());
		System.out.println(resultado.calcularPorCategoria());
		System.out.println(resultado.calcularPorPresentacion());		
		System.out.println(ToStringBuilder.reflectionToString(calificacionEvaluadoresList)); 	
	}
	
	

}
