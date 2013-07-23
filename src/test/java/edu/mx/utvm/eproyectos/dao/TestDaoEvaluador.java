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
		Assert.assertNotNull(evaluadorDao);
		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 0);
		
	}
	
	@Ignore
	public void insertAndfindAll(){
		Assert.assertNotNull(evaluadorDao);
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);		
	}
	
	@Test
	public void redById(){
		
		Assert.assertNotNull(evaluadorDao);
		
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);

		evaluadorDao.read(1);		
		System.out.println("RESULTADOS"+ evaluador.getNombre());

	}
	
	@Test
	public void updateById(){

			
		Evaluador evaluador = new Evaluador(1, "Jose Perez Aguirre", "Desarrollo Mobile");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador);
		
		List<Evaluador> all = evaluadorDao.findAll();
		System.out.println("RESULTADOS"+ all.size());
		System.out.println("RESULTADOS"+ all.get(0).getEspecialidad());
		
		evaluador.setEspecialidad("prueba");
		
		evaluadorDao.update(evaluador);
		List<Evaluador> all2 = evaluadorDao.findAll();
		System.out.println("RESULTADOS"+ all2.get(0).getEspecialidad());

		
	}
}
