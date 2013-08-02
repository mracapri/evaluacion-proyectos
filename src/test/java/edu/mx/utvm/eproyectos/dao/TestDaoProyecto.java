package edu.mx.utvm.eproyectos.dao;

import static edu.mx.utvm.eproyectos.dao.util.TestData.generateBytes;
import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId32;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
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
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoProyecto {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	ProyectoDao proyectoDao;

	@Autowired
	EvaluacionDao evaluacionDao;

	@Autowired
	CategoriaDao categoriaDao;

	@Autowired
	Catalogos catalogos;
	
	@Autowired
	EvaluadorDao evaluadorDao;

	@Test
	public void findAll() {
		log.info("------------Test Find All----------------------");
		Assert.assertNotNull(evaluacionDao);
		Assert.assertNotNull(proyectoDao);

		String id32 = generateId32();		
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);

		List<Proyecto> all = proyectoDao.findAllByIdEvaluacion(id32);
		Assert.assertTrue(all.size() == 0);
	}

	@Test
	public void insertAndfindAll() throws Exception {
		log.info("------------Test Insert and Find All EVALUACION----------------------");
		
		Assert.assertNotNull(evaluacionDao);
		Assert.assertNotNull(proyectoDao);

		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Categoria categoria = new Categoria(1, "Desarrollo web");
		categoriaDao.create(categoria);
		
		catalogos.afterPropertiesSet();
		
		
		Proyecto proyecto = new Proyecto(generateId32(), "Proyecto de Vida",
				catalogos.getCategorias().get(1), "Mario Rivera");

		proyecto.setArchivoPresentacion(generateBytes());
		proyecto.setFoto(generateBytes());
		proyecto.setLogo(generateBytes());
		
		proyectoDao.create(proyecto,evaluacion);
		
		List<Proyecto> all = proyectoDao.findAllByIdEvaluacion(id32);
		Assert.assertTrue(all.size() == 1);
	}

	@Test
	public void updateProyecto() throws Exception {
		Assert.assertNotNull(evaluacionDao);
		Assert.assertNotNull(proyectoDao);

		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Categoria categoria = new Categoria(1, "Desarrollo web");
		categoriaDao.create(categoria);
		
		catalogos.afterPropertiesSet();
		
		Proyecto proyecto = new Proyecto(generateId32(), "Proyecto de Vida",
				catalogos.getCategorias().get(1), "Mario Rivera");

		proyecto.setArchivoPresentacion(generateBytes());
		proyecto.setFoto(generateBytes());
		proyecto.setLogo(generateBytes());
		
		proyectoDao.create(proyecto,evaluacion);
		
		log.info(ToStringBuilder.reflectionToString(proyecto));
		
		
		byte[] presentacion = generateBytes();
		byte[] foto = generateBytes();
		byte[] logo = generateBytes();
		String nombre = "1,2,3 y mas...";
		
		proyecto.setNombre(nombre);
		proyecto.setArchivoPresentacion(presentacion);
		proyecto.setFoto(foto);
		proyecto.setLogo(logo);
		
		proyectoDao.update(proyecto);
		Proyecto read = proyectoDao.read(proyecto.getIdProyecto());
		
		Assert.assertTrue(read.getNombre().equals(nombre));
		Assert.assertArrayEquals(read.getFoto(), foto);
		Assert.assertArrayEquals(read.getArchivoPresentacion(), presentacion);
		Assert.assertArrayEquals(read.getLogo(), logo);
	}

	@Test
	public void deleteProyecto() throws Exception {
		log.info("------------Test Delete Proyecto----------------------");
		Assert.assertNotNull(evaluacionDao);
		Assert.assertNotNull(proyectoDao);

		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Categoria categoria = new Categoria(1, "Desarrollo web");
		categoriaDao.create(categoria);
		
		catalogos.afterPropertiesSet();
		
		String idProyecto = generateId32();
		Proyecto proyecto = new Proyecto(idProyecto, "Proyecto de Vida",
				catalogos.getCategorias().get(1), "Mario Rivera");

		proyecto.setArchivoPresentacion(generateBytes());
		proyecto.setFoto(generateBytes());
		proyecto.setLogo(generateBytes());
		
		proyectoDao.create(proyecto,evaluacion);
		
		List<Proyecto> all = proyectoDao.findAllByIdEvaluacion(id32);
		Assert.assertTrue(all.size() == 1);
		
		proyectoDao.delete(proyecto);
		Proyecto read = proyectoDao.read(idProyecto);
		Assert.assertNull(read);
		
	}
}
