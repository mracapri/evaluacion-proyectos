package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoProyecto {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	ProyectoDao proyectoDao;
	
	@Autowired
	EvaluacionDao evaluacionDao;
	
	@Autowired
	CategoriaDao categoriaDao;
	
	@Autowired
	Catalogos catalogos;

	@Ignore
	public void findAll() {
		log.info("------------Test Find All----------------------");
		Assert.assertNotNull(evaluacionDao);
		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 0);
	}
	
	
	@Ignore
	public void insertAndfindAll(){
		log.info("------------Test Insert and Find All EVALUACION----------------------");
		Assert.assertNotNull(evaluacionDao);
		
		Evaluacion evaluacion = new Evaluacion("1", "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);	
		
		log.info("RESULT--->"+all.get(0).getDescripcion());
	}
	
	@Ignore
	public void updateProyecto(){
		log.info("--------------Update Proyecto-------------------");
		Categoria categoria = new Categoria(2, "Desarrollo web");
		categoriaDao.create(categoria);
		
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Categoria categoria1 = catalogos.getCategorias().get(2);		
		Proyecto proyecto = new Proyecto("1301Ca", "Proyecto1", categoria1, "Isidro Ramos");
		Assert.assertNotNull(proyecto);
		proyectoDao.create(proyecto);
		
		proyecto.setNombre("Proyecto Update");
		proyectoDao.update(proyecto);
		
		List<Proyecto> all = proyectoDao.findAll();
		log.info("Descripcion Actualizada--->"+all.get(1).getNombre());

	}
	
	@Test
	public void findAllProyectos(){
		
		log.info("-------------------Fin all proyectos---------------------");

		Categoria categoria = new Categoria(2, "Desarrollo web");
		categoriaDao.create(categoria);
		
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Categoria categoria1 = catalogos.getCategorias().get(2);
				
		Evaluacion evaluacion = new Evaluacion("2","Evaluacion");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Proyecto proyecto = new Proyecto("1301Ca", "Proyecto1", categoria1, "Isidro Ramos");
		Assert.assertNotNull(proyecto);

		Proyecto proyecto1 = new Proyecto("1401Ba", "Creacion de paginas", categoria1, "Alonso Marquez");
		Assert.assertNotNull(proyecto1);
	
		
		//LLenado de tabla evaluacion-proeyctos
		proyectoDao.create(proyecto, evaluacion);
		proyectoDao.create(proyecto1, evaluacion);
		
		
		log.info("Result--------->"+evaluacionDao.findAll().get(0).getProyectos().size());
		
	}
	
		
	
	
	
	
	

}
