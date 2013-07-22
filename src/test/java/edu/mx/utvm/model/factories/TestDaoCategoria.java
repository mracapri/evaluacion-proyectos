package edu.mx.utvm.model.factories;

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

import edu.mx.utvm.dao.CategoriaDao;
import edu.mx.utvm.model.Categoria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoCategoria {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	CategoriaDao categoriaDao;

	@Test
	public void findAll() {
		Assert.assertNotNull(categoriaDao);
		List<Categoria> all = categoriaDao.findAll();
		Assert.assertTrue(all.size() == 0);
	}
	
	@Test
	public void insertAndfindAll() {
		Assert.assertNotNull(categoriaDao);
		
		Categoria categoria = new Categoria(1, "Desarrollo movil");
		Assert.assertNotNull(categoria);
		categoriaDao.create(categoria);

		List<Categoria> all = categoriaDao.findAll();
		Assert.assertTrue(all.size() == 1);
	}
}
