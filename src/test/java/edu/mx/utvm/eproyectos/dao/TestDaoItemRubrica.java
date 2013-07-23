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
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

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
	
	@Autowired
	private RubricaDao rubricaDao;
	
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
		
		RubricaPresentacion rubrica = new RubricaPresentacion("1301");
		rubricaDao.create(rubrica);
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);
		
		itemRubricaDao.create(itemRubrica,rubrica);
		
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
		
		RubricaPresentacion rubrica = new RubricaPresentacion("1301");
		rubricaDao.create(rubrica);
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);
		
		itemRubricaDao.create(itemRubrica, rubrica);
		
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
		log.info("-----------------Test4--------------");
		Assert.assertNotNull(itemRubricaDao);
		
		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);
		
		/*Escala escala = catalogos.getEscalas().get(1);
		log.info("escalas =" + catalogos.getEscalas().size());*/
		
		RubricaPresentacion rubrica = new RubricaPresentacion("1301");
		rubricaDao.create(rubrica);
		
		RubricaPresentacion rubrica2 = new RubricaPresentacion("1302");
		rubricaDao.create(rubrica2);
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);		
		itemRubricaDao.create(itemRubrica, rubrica);
		
		ItemRubrica itemRubrica2 = new ItemRubrica(2, "Desarrollo", "Caracteristicas desarrollo", escala);		
		itemRubricaDao.create(itemRubrica2, rubrica2);		

		itemRubricaDao.findItemsRubricaByIdRubrica("1301");
	
	}
	
	@Test
	public void findAllItemRubricas(){
		log.info("-----------------Test4--------------");
		Assert.assertNotNull(itemRubricaDao);
		
		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);
		
		/*Escala escala = catalogos.getEscalas().get(1);
		log.info("escalas =" + catalogos.getEscalas().size());*/
		
		RubricaPresentacion rubrica = new RubricaPresentacion("1301");
		rubricaDao.create(rubrica);
		
		RubricaPresentacion rubrica2 = new RubricaPresentacion("1302");
		rubricaDao.create(rubrica2);
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);		
		itemRubricaDao.create(itemRubrica, rubrica);
		
		ItemRubrica itemRubrica2 = new ItemRubrica(2, "Desarrollo", "Caracteristicas desarrollo", escala);		
		itemRubricaDao.create(itemRubrica2, rubrica);		
		
		ItemRubrica itemRubrica3 = new ItemRubrica(3, "Deseño1", "Caracteristicas e implementacion del diseño", escala);		
		itemRubricaDao.create(itemRubrica3, rubrica2);
		
		ItemRubrica itemRubrica4 = new ItemRubrica(4, "Desarrollo2", "Caracteristicas desarrollo", escala);		
		itemRubricaDao.create(itemRubrica4, rubrica2);
		
		log.info(rubricaDao.findAll().get(1).getItems().get(1).getDescripcionCorta());
	}
	
}
