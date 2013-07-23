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

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.ItemRubrica;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoItemRubrica {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	ItemRubricaDao itemRubricaDao;
	
	@Autowired
	private Catalogos catalogos;
	
	@Autowired
	private EscalaDao escalaDao;
	
	@Test
	public void findAll() {
		log.info("-----------------Test1--------------");
		Assert.assertNotNull(itemRubricaDao);
		List<ItemRubrica> all = itemRubricaDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 0);
	}
	 
	@Test
	public void insertAndFindAll() {
		log.info("-----------------Test2--------------");
		Assert.assertNotNull(itemRubricaDao);
					
		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);
		
		/*Escala escala = catalogos.getEscalas().get(1);
		log.info("escalas =" + catalogos.getEscalas().size());*/
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);
		
		itemRubricaDao.create(itemRubrica);
		
		List<ItemRubrica> all = itemRubricaDao.findAll();
		log.info(all.size());
		Assert.assertTrue(all.size() == 1);
	} 
	
	@Test
	public void readById(){
		log.info("-----------------Test3--------------");
		Assert.assertNotNull(itemRubricaDao);
		
		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);
		
		/*Escala escala = catalogos.getEscalas().get(1);
		log.info("escalas =" + catalogos.getEscalas().size());*/
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);
		
		itemRubricaDao.create(itemRubrica);
		
		/*Carga catalogo*/
		escalaDao.findAllMap();
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ItemRubrica itemRubricaRecibida = itemRubricaDao.read(1);
		
		log.info("id:"+itemRubricaRecibida.getIdItemRubrica());
		log.info("descripcionCorta:"+itemRubricaRecibida.getDescripcionCorta());
		log.info("descripcionLarga:"+itemRubricaRecibida.getDescripcionLarga());
		log.info("escala:"+itemRubricaRecibida.getEscala().getIdEscala());
		Assert.assertNotNull(itemRubricaRecibida);
	}
	
	@Test
	public void findAllItemRubricasByRubrica(){
		
	}
	
}
