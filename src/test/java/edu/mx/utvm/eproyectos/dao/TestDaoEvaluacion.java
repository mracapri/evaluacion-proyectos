package edu.mx.utvm.eproyectos.dao;

import static edu.mx.utvm.eproyectos.dao.util.TestData.*;
import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId32;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoEvaluacion {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	EvaluadorDao evaluadorDao;
	
	@Autowired
	EvaluacionDao evaluacionDao;	
	
	@Autowired
	ProyectoDao proyectoDao;
	
	@Autowired
	Catalogos catalogos;

	@Autowired
	CategoriaDao categoriaDao;
	
	@Test
	public void findAll() {
		log.info("------------Test Find All----------------------");
		Assert.assertNotNull(evaluacionDao);
		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 0);
	}
	
	
	@Test
	public void insertAndfindAll(){
		log.info("------------Test Insert and Find All EVALUACION----------------------");
		Assert.assertNotNull(evaluacionDao);
		
		Evaluacion evaluacion = new Evaluacion(generateId32(), "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);	
		
		log.info("RESULT--->"+all.get(0).getDescripcion());
	}
	
	
		
	
	@Test
	public void readById(){
		log.info("------------Test Read by ID ----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		String id = generateId32();
		Evaluacion evaluacion = new Evaluacion(id, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);	
		

		Assert.assertNotNull(evaluacionDao.read(id));		
		log.info("RESULT--->"+evaluacionDao.read(id).getDescripcion());
	}
	
	
	@Test
	public void updateById(){
		log.info("------------Test Update by ID Evalaucion ----------------------");

		Assert.assertNotNull(evaluacionDao);
		String id = generateId32();
		Evaluacion evaluacion = new Evaluacion(id, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		log.info("RESULT--->"+all.get(0).getDescripcion());
		
		evaluacion.setDescripcion("Update Evaluacion Uno");
		evaluacionDao.update(evaluacion);
		
		
		Evaluacion read = evaluacionDao.read(id);
		Assert.assertTrue(read.getDescripcion().equals(evaluacion.getDescripcion()));
		
		
		List<Evaluacion> all1 = evaluacionDao.findAll();
		Assert.assertTrue(all1.size() == 1);
		
		log.info("RESULT UPDATE--->"+all1.get(0).getDescripcion());
	}
	
	
	@Test
	public void deleteById(){
		log.info("------------Test Delete by ID Evaluacion ----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		log.info("RESUL--->"+evaluacionDao.read(id32).getDescripcion());
		
		evaluacionDao.delete(evaluacion);
		
		System.out.println("RESUL AFTER DELETE--->"+evaluacionDao.read(id32));
		
		Assert.assertNull(evaluacionDao.read(id32));

	}
	
	
	@Test
	public void deleteByIdConEvaluadoresYProyectos() throws Exception{
		log.info("------------Test Delete by ID Evaluacion ----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		log.info("RESUL--->"+evaluacionDao.read(id32).getDescripcion());
		
		// creando evaluador
		String id32Evaluador1 = generateId32();
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);
		
		// creando proyecto
		Categoria categoria = new Categoria(1, "Desarrollo web");
		categoriaDao.create(categoria);
		
		catalogos.afterPropertiesSet();
		
		Evaluador evaluador1 = new Evaluador("cd3dc8b6cffb41e4163dcbd857ca87da", "Alfredo Perez", "TIC", "qweqwe", "asdasdasd");
		Evaluador evaluador2 = new Evaluador("68a9e49bbc88c02083a062a78ab3bf30", "Mario Rivera", "TIC", "qweqwe", "asdasdasd");
		evaluadorDao.create(evaluador1, evaluacion);
		evaluadorDao.create(evaluador2, evaluacion);
		
		List<Evaluador> evalaudores = new ArrayList<Evaluador>();
		evalaudores.add(evaluador1);
		evalaudores.add(evaluador2);
		
		Proyecto proyecto = new Proyecto(generateId32(), "Proyecto de Vida",
				catalogos.getCategorias().get(1), "Mario Rivera", evalaudores);

		proyecto.setArchivoPresentacion(generateBytes());
		proyecto.setFoto(generateBytes());
		proyecto.setLogo(generateBytes());
		
		proyectoDao.create(proyecto,evaluacion);
		
		
		// borrando evaluacion
		evaluacionDao.delete(evaluacion);
		
		System.out.println("RESUL AFTER DELETE--->"+evaluacionDao.read(id32));
		
		Assert.assertNull(evaluacionDao.read(id32));

	}
	
	
	

}
