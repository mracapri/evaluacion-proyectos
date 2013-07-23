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
		//RubricaPresentacion rubrica = new RubricaPresentacion();
		//Rubrica rubrica = new Rubrica("1301");
		
		Categoria categoria = new Categoria(0, "web");	
		RubricaCategoria rubrica = new RubricaCategoria("1301",categoria);
		
		//RubricaPresentacion rubrica2 = new RubricaPresentacion("as01");
		//rubricaDao.create(rubrica2, categoria);
		rubricaDao.create(rubrica);
		//Assert.assertTrue(all.size() == 0);
	}
		
}
