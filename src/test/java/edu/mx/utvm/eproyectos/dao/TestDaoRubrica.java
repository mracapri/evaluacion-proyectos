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

import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoRubrica {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	RubricaDao rubricaDao;
	
	@Test
	public void createNew() {
		log.info("Test........................");
		Assert.assertNotNull(rubricaDao);
		RubricaPresentacion rubricaPresentacion = new RubricaPresentacion("1301");
		Rubrica rubrica = new Rubrica("1301");
		
		Categoria categoria = new Categoria(0, "desarrollo web");	
		RubricaCategoria rubricaCategoria = new RubricaCategoria("1301",categoria);		
		
		rubricaDao.create(rubrica);
		rubricaDao.create(rubricaPresentacion);
		rubricaDao.create(rubricaCategoria);
		
		log.info("xxxxxxxxxxxxx"+rubricaDao);
		
		//Assert.assertTrue(all.size() == 0);
	}
	
	@Test
	public void findAll(){
		log.info("Test2........................");
		Assert.assertNotNull(rubricaDao);
				
		Assert.assertNotNull(rubricaDao);
		RubricaPresentacion rubricaPresentacion = new RubricaPresentacion("1301");
		//Rubrica rubrica = new Rubrica("1301");
		
		Categoria categoria = new Categoria(0, "desarrollo web");	
		RubricaCategoria rubricaCategoria = new RubricaCategoria("1302",categoria);		
		
		//rubricaDao.create(rubrica);
		rubricaDao.create(rubricaPresentacion);
		rubricaDao.create(rubricaCategoria);
		
		List<Rubrica> all = rubricaDao.findAll();
		log.info("xxxxxxxxxxxxx"+all.size());
		log.info("xxxxxxxxxxxxx"+all.get(0).getId());
		log.info("xxxxxxxxxxxxx"+all.get(1).getId());
		
	}
		
}
