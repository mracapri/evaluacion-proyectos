package edu.mx.utvm.eproyectos.dao;

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

import edu.mx.utvm.eproyectos.model.Escala;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoEscala {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	EscalaDao escalaDao;
	
	@Test
	public void findAll() {
		log.info("-----------------Test1--------------");
		Assert.assertNotNull(escalaDao);		
		List<Escala> all = escalaDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 0);
	}
	
	@Test
	public void insertAndFindAll(){
		log.info("-----------------Test2--------------");
		Assert.assertNotNull(escalaDao);
		
		Escala escala = new Escala(1, 0, 10);
		escalaDao.create(escala);
		
		List<Escala> all = escalaDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 1);
	}
	
	@Test
	public void readById(){
		log.info("-----------------Test3--------------");
		Assert.assertNotNull(escalaDao);
		
		Escala escala = new Escala(1, 0, 10);
		escalaDao.create(escala);
		
		List<Escala> all = escalaDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 1);
	}
}
