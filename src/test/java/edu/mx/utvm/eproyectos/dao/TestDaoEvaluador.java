package edu.mx.utvm.eproyectos.dao;

import static edu.mx.utvm.eproyectos.dao.util.TestData.*;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoEvaluador {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	EvaluadorDao evaluadorDao;
	@Autowired
	EvaluacionDao evaluacionDao;

	@Test
	public void findAll() {
		log.info("------------Test Find All----------------------");
		Assert.assertNotNull(evaluadorDao);
		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 0);
		
	}
	
	@Test
	public void insertAndfindAll(){
		log.info("------------Test Insert and Find All----------------------");
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluador evaluador = new Evaluador(id32Evaluador, "Jose Perez Aguirre", "Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		
		evaluadorDao.create(evaluador, evaluacion);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);		
	}

	@Test
	public void insertAndfindByUsername(){
		log.info("------------Test Insert and Find All----------------------");
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluador evaluador = new Evaluador(id32Evaluador, "Jose Perez Aguirre", "Desarrollo Mobile", "mracapri", "123456");
		Assert.assertNotNull(evaluador);
		
		evaluadorDao.create(evaluador, evaluacion);

		Evaluador readByNombreUsuario = evaluadorDao.readByNombreUsuario("mracapri");
		Assert.assertNotNull(readByNombreUsuario);
	}
	
	@Test
	public void inserTwoId(){
		log.info("------------Test Insert two IDS----------------------");
		
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador1 = generateId32();
		String id32Evaluador2 = generateId32();
		
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
				
		
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);

		Evaluador evaluador1 = new Evaluador(id32Evaluador2, "Nacho Camacho","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador1);
		evaluadorDao.create(evaluador1, evaluacion);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 2);
	}
	
	@Test(expected=DataAccessException.class)
	public void insertDuplicate(){
		log.info("------------Test Insert two IDS----------------------");
		
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador1 = generateId32();
		
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
				
		
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);

		Evaluador evaluador1 = new Evaluador(id32Evaluador1, "Nacho Camacho","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador1);
		evaluadorDao.create(evaluador1, evaluacion);
	}
	
	@Test
	public void readById(){
		log.info("------------Test Read by ID ----------------------");

		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador1 = generateId32();
		
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
				
		
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);
		
		Evaluador read = evaluadorDao.read(id32Evaluador1);
		Assert.assertNotNull(read);
	}
	
		
	@Test
	public void updateById(){
		log.info("------------Test Update by ID ----------------------");

		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador1 = generateId32();
		
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
				
		
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);
		
		String nombre = "Mario Rivera";
		String especialidad = "Mario Rivera";
		evaluador.setNombre(nombre);
		evaluador.setEspecialidad(especialidad);
		
		evaluadorDao.update(evaluador);
		
		Evaluador read = evaluadorDao.read(id32Evaluador1);
		
		Assert.assertTrue(read.getNombre().equals(nombre));
		Assert.assertTrue(read.getEspecialidad().equals(especialidad));
		
		
	}
	

	@Test
	public void deleteById(){
		log.info("------------Test Delete by ID ----------------------");
		
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador1 = generateId32();
		
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
				
		
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);
		
		Evaluador read = evaluadorDao.read(id32Evaluador1);		
		Assert.assertNotNull(read);
		
		evaluadorDao.delete(read);
		read = evaluadorDao.read(id32Evaluador1);
		Assert.assertNull(read);
		
		

	}
	
	@Test
	public void findAllEvaluadores(){
		
		log.info("-------------------Fin all evaluadores--------------");
		Assert.assertNotNull(evaluadorDao);
		
		
		String id32Evaluacion = generateId32();
		String id32Evaluacion2 = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluacion evaluacion2 = new Evaluacion(id32Evaluacion2,"Evaluacion",3);
		Assert.assertNotNull(evaluacion2);
		evaluacionDao.create(evaluacion2);
		
		Evaluador evaluador = new Evaluador(generateId32(), "Jose Perez Aguirre", "Desarrollo Mobile", generateId10(), "123456");		
		Evaluador evaluador2 = new Evaluador(generateId32(), "Yasser Cabrera", "Desarrollo Mobile", generateId10(), "123456");		
		Evaluador evaluador3 = new Evaluador(generateId32(), "Noe Montoya", "Desarrollo Mobile", generateId10(), "123456");
		
		evaluadorDao.create(evaluador, evaluacion);
		evaluadorDao.create(evaluador2, evaluacion);
		evaluadorDao.create(evaluador3, evaluacion2);
		
		Map<String, Evaluador> list1 = evaluadorDao.findAllByIdEvaluacion(id32Evaluacion);
		Map<String, Evaluador> list2 = evaluadorDao.findAllByIdEvaluacion(id32Evaluacion2);
		
		
		Assert.assertTrue(list1.size() == 2);
		Assert.assertTrue(list2.size() == 1);
	}
	
	
	
}
