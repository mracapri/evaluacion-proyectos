package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
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
	
	@Autowired
	CategoriaDao categoriaDao;
	
	@Autowired
	Catalogos catalogos;
	
	@Test
	public void createNewSinCategoria() {
		log.info("-----------------Test1--------------");
		Assert.assertNotNull(rubricaDao);
		RubricaPresentacion rubricaPresentacion = new RubricaPresentacion("3110");		
				
		rubricaDao.create(rubricaPresentacion);		
		
		List<Rubrica> all = rubricaDao.findAll();
		log.info("result-->"+all.size());		
		
		log.info("result-->"+rubricaDao.findAll().get(0).getId());		
		Assert.assertNotNull(rubricaDao);
	}
	
	@Test
	public void createNewCategoria() {
		log.info("-----------------Test2--------------");
		Assert.assertNotNull(rubricaDao);						
		
		Categoria categoriaObj = new Categoria(1, "desarrollo web");
		categoriaDao.create(categoriaObj);			
		
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Categoria categoria = catalogos.getCategorias().get(1);
		
		RubricaCategoria rubricaCategoria = new RubricaCategoria("1302",categoria);		
						
		rubricaDao.create(rubricaCategoria);				
		
		RubricaCategoria recibiRurbica = (RubricaCategoria) rubricaDao.findAll().get(0);
		Categoria categoriaRecibida = categoriaDao.read(recibiRurbica.getCategoria().getIdCategoria());
		
		log.info("result-->"+rubricaDao.findAll().get(0).getId());
		log.info("result-->"+recibiRurbica.getCategoria().getIdCategoria());
		log.info("result-->"+categoriaRecibida.getDescripcion());
		Assert.assertNotNull(rubricaDao);
	}
	
	@Test
	public void findAllSinCategoia(){
		log.info("-----------------Test3--------------");
		Assert.assertNotNull(rubricaDao);						
		RubricaPresentacion rubricaPresentacion = new RubricaPresentacion("1301");
		
		rubricaDao.create(rubricaPresentacion);
		
		List<Rubrica> all = rubricaDao.findAll();
		log.info("result-->"+all.size());
		log.info("result-->"+all.get(0).getId());			
	}
	
	@Test
	public void findAllCategoia(){
		log.info("-----------------Test4--------------");
		Assert.assertNotNull(rubricaDao);								
		
		Categoria categoriaObj = new Categoria(1, "desarrollo web");
		categoriaDao.create(categoriaObj);
		
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Categoria categoria = catalogos.getCategorias().get(1);
		
		RubricaCategoria rubricaCategoria = new RubricaCategoria("1302",categoria);		
				
		rubricaDao.create(rubricaCategoria);
		
		RubricaCategoria recibiRurbica = (RubricaCategoria) rubricaDao.findAll().get(0);
		Categoria categoriaRecibida = categoriaDao.read(recibiRurbica.getCategoria().getIdCategoria());
		
		List<Rubrica> all = rubricaDao.findAll();
		log.info("result-->"+all.size());
		log.info("result-->"+all.get(0).getId());		
		log.info("result-->"+categoriaRecibida.getDescripcion());		
	}
	
	@Test
	public void findbyId(){
		log.info("-----------------Test5--------------");
		Assert.assertNotNull(rubricaDao);								
		
		Categoria categoriaObj = new Categoria(1, "desarrollo web");
		categoriaDao.create(categoriaObj);
		
		try {
			catalogos.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Categoria categoria = catalogos.getCategorias().get(1);
		
		RubricaCategoria rubricaCategoria = new RubricaCategoria("1301",categoria);		
				
		rubricaDao.create(rubricaCategoria);		
		if(rubricaDao.read("1301").getClass() == RubricaCategoria.class){
			RubricaCategoria rubrica = (RubricaCategoria) rubricaDao.read("1301");
			log.info("id-->"+rubrica.getId());
			log.info("categoria-->"+rubrica.getCategoria().getDescripcion());
		}else{
			RubricaPresentacion rubrica = (RubricaPresentacion) rubricaDao.read("1301");
			log.info("id-->"+rubrica.getId());			
		}
		
		List<Rubrica> all = rubricaDao.findAll();
		log.info("tamano-->"+all.size());		
		
	}
		
}
