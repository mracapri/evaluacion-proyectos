package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.model.Evaluador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoEvaluador {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	EvaluadorDao evaluadorDao;

	@Ignore
	public void findAll() {
		log.info("------------Test Find All----------------------");
		Assert.assertNotNull(evaluadorDao);
		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 0);
		
	}
	
	@Ignore
	public void insertAndfindAll(){
		log.info("------------Test Insert and Find All----------------------");
		Assert.assertNotNull(evaluadorDao);
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);		
	}
	
	@Ignore//(expected=DataAccessException.class)
	public void inserTwoId(){
		log.info("------------Test Insert two IDS----------------------");
		
		Assert.assertNotNull(evaluadorDao);
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre","Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);

		Evaluador evaluador1 = new Evaluador(1, "Nacho Camacho","Desarrollo Mobile");
		Assert.assertNotNull(evaluador1);
		evaluadorDao.create(evaluador1);

		List<Evaluador> all = evaluadorDao.findAll();
	}
	
	@Ignore
	public void readById(){
		log.info("------------Test Read by ID ----------------------");
		
		Assert.assertNotNull(evaluadorDao);
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);
		
		evaluadorDao.read(2);
	}
	
		
	@Ignore
	public void updateById(){
		log.info("------------Test Update by ID ----------------------");

		Assert.assertNotNull(evaluadorDao);

		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre","Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);
		
		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		evaluadorDao.update(evaluador);		
		
	}
	

	@Test(expected=DataAccessException.class)
	public void DeleteById(){
		log.info("------------Test Delete by ID ----------------------");
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);
		
		log.info("RESUL--->"+evaluadorDao.read(1).getEspecialidad());
		
		evaluadorDao.delete(evaluador);
		System.out.println("RESUL--->"+evaluadorDao.read(1));

	}
	

}
