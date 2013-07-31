package edu.mx.utvm.eproyectos.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Resultado;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoResultado {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private ResultadoDao resultadoDao;
	
	@Autowired
	private EvaluacionDao evaluacionDao;
	
	@Autowired
	private ProyectoDao proyectoDao;
	
	@Autowired
	private RubricaDao rubricaDao;
	
	@Autowired
	private ItemRubricaDao itemRubricaDao;
	
	@Autowired
	private Catalogos catalogos;
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Autowired
	private EscalaDao escalaDao;
	
	@Autowired
	private EvaluadorDao evaluadorDao;
	
	private Categoria categoria1;
	private Escala escala1;
	
	
	@Before
	public void cargaCatalogos(){
		/*Cragando elementos en categorias*/
		Categoria categoriaObj = new Categoria(1, "Desktop");
		categoriaDao.create(categoriaObj);

		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);
		
		categoria1 = categoriaObj;
		escala1 = escala;
	}
	
	@Test
	public void findAll() {
		log.info("-----------------Test1--------------");
		Assert.assertNotNull(resultadoDao);		
		List<Resultado> all = resultadoDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 0);
	}
	
	@Test
	public void insertAndFindAll(){
		log.info("-----------------Test2--------------");
		Assert.assertNotNull(resultadoDao);
		
		
		
		
		/*Create evaluacion*/
		Evaluacion evaluacion = new Evaluacion("1", "Evaluacion 2013");
		evaluacionDao.create(evaluacion);
		
		/*Create evaluadores*/
		Evaluador evaluador1 = new Evaluador("cd3dc8b6cffb41e4163dcbd857ca87da", "Alfredo Perez", "TIC");
		Evaluador evaluador2 = new Evaluador("68a9e49bbc88c02083a062a78ab3bf30", "Mario Rivera", "TIC");
		
		evaluadorDao.create(evaluador1, evaluacion);
		evaluadorDao.create(evaluador2, evaluacion);
		
		List<Evaluador> evalaudores = new ArrayList<Evaluador>();
		evalaudores.add(evaluador1);
		evalaudores.add(evaluador2);
		
		/*Create proyecto*/		
		Proyecto proyecto = new Proyecto("130101", "Kinect", categoria1, "Israel Paz", evalaudores);
		proyectoDao.create(proyecto, evaluacion);
		
		/*Create Rubrica*/						
		RubricaCategoria rubrica = new RubricaCategoria("1301",categoria1);
		rubricaDao.create(rubrica);
		
		/*Create Item rubrica*/
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala1);
		itemRubricaDao.create(itemRubrica, rubrica);
		
		/*
		 * Resultado
		 * */
		Resultado resultado = new Resultado(1,"130101","1301", 1, 10);
		resultadoDao.create(resultado);
		
		List<Resultado> all = resultadoDao.findAll();
		log.info("Tamano-->"+all.size());
		log.info("idEvaluacion-->"+all.get(0).getIdEvaluacion());
		log.info("idProyecto-->"+all.get(0).getIdProyecto());
		log.info("idRubrica-->"+all.get(0).getIdRubrica());
		log.info("idItemRubrica-->"+all.get(0).getIdItemRubrica());
		log.info("calificacion-->"+all.get(0).getCalificacion());
		Assert.assertTrue(all.size() == 1);
	}
	
	@Test
	public void insertAndFindAllByProyecto(){
		log.info("-----------------Test3--------------");
		Assert.assertNotNull(resultadoDao);					
		
		/*Create evaluacion*/
		Evaluacion evaluacion = new Evaluacion("1", "Evaluacion 2013");
		evaluacionDao.create(evaluacion);
		
		/*Create evaluadores*/
		Evaluador evaluador1 = new Evaluador("cd3dc8b6cffb41e4163dcbd857ca87da", "Alfredo Perez", "TIC");
		Evaluador evaluador2 = new Evaluador("68a9e49bbc88c02083a062a78ab3bf30", "Mario Rivera", "TIC");
		
		evaluadorDao.create(evaluador1, evaluacion);
		evaluadorDao.create(evaluador2, evaluacion);
		
		List<Evaluador> evalaudores = new ArrayList<Evaluador>();
		evalaudores.add(evaluador1);
		evalaudores.add(evaluador2);
		
		/*Create proyecto*/		
		Proyecto proyecto = new Proyecto("130101", "Kinect", categoria1, "Israel Paz", evalaudores);
		proyectoDao.create(proyecto, evaluacion);
		
		/*Create Rubrica*/						
		RubricaCategoria rubrica = new RubricaCategoria("1301",categoria1);
		rubricaDao.create(rubrica);
		
		/*Create Item rubrica*/
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala1);
		itemRubricaDao.create(itemRubrica, rubrica);
		
		/*
		 * Resultado
		 * */
		Resultado resultado = new Resultado(1,"130101","1301", 1, 10);
		resultadoDao.create(resultado);
		
		List<Resultado> all = resultadoDao.findAllByProyecto("130101");
		
		log.info("Tamano-->"+all.size());
		log.info("idEvaluacion-->"+all.get(0).getIdEvaluacion());
		log.info("idProyecto-->"+all.get(0).getIdProyecto());
		log.info("idRubrica-->"+all.get(0).getIdRubrica());
		log.info("idItemRubrica-->"+all.get(0).getIdItemRubrica());
		log.info("calificacion-->"+all.get(0).getCalificacion());
		Assert.assertTrue(all.size() == 1);
	}
}
