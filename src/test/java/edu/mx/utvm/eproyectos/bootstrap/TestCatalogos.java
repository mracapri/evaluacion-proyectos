package edu.mx.utvm.eproyectos.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestCatalogos {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private Catalogos catalogos;

	@Test
	public void testComponenteCatalogo() {
		Assert.assertNotNull(catalogos);
	}	
	
	@Test
	public void testCatalogoCategorias() {
		Assert.assertNotNull(catalogos.getCategorias());		
		Assert.assertTrue(catalogos.getCategorias().size() == 0);
	}	
	
	@Test
	public void testCatalogoRubricas() {
		Assert.assertNotNull(catalogos.getRubricas());
		log.info("tamano-->"+catalogos.getCategorias().size());
		Assert.assertTrue(catalogos.getCategorias().size() == 0);
	}
}
