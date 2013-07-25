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

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoEvaluacion {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	EvaluadorDao evaluadorDao;
	
	@Autowired
	EvaluacionDao evaluacionDao;	

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
		
		Evaluacion evaluacion = new Evaluacion(1, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);	
		
		log.info("RESULT--->"+all.get(0).getDescripcion());
	}
	
	
		
	
	@Ignore
	public void readById(){
		log.info("------------Test Read by ID ----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		
		Evaluacion evaluacion = new Evaluacion(1, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);	
		

		Assert.assertNotNull(evaluacionDao.read(1));		
		log.info("RESULT--->"+evaluacionDao.read(1).getDescripcion());
	}
	
	
	@Ignore
	public void updateById(){
		log.info("------------Test Update by ID Evalaucion ----------------------");

		Assert.assertNotNull(evaluacionDao);

		Evaluacion evaluacion = new Evaluacion(1, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		List<Evaluacion> all = evaluacionDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		log.info("RESULT--->"+all.get(0).getDescripcion());
		
		evaluacion.setDescripcion("Update Evaluacion Uno");		
		evaluacionDao.update(evaluacion);
		
		List<Evaluacion> all1 = evaluacionDao.findAll();
		Assert.assertTrue(all1.size() == 1);
		
		log.info("RESULT UPDATE--->"+all1.get(0).getDescripcion());
	}
	
	
	@Ignore//(expected=DataAccessException.class)
	public void DeleteById(){
		log.info("------------Test Delete by ID Evaluacion ----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		Evaluacion evaluacion = new Evaluacion(1, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		log.info("RESUL--->"+evaluacionDao.read(1).getDescripcion());
		
		evaluacionDao.delete(evaluacion);
		System.out.println("RESUL AFTER DELETE--->"+evaluacionDao.read(1));

	}
	
	
	
	
	
	

}
