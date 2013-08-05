/*
 * Prueba de unidad de comportamiento 
 * para el servicio pertinente a Proyecto
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import static edu.mx.utvm.eproyectos.dao.util.TestData.generateBytes;
import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId10;
import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId32;
import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.dao.CategoriaDao;
import edu.mx.utvm.eproyectos.dao.EscalaDao;
import edu.mx.utvm.eproyectos.dao.EvaluacionDao;
import edu.mx.utvm.eproyectos.dao.EvaluadorDao;
import edu.mx.utvm.eproyectos.dao.ItemRubricaDao;
import edu.mx.utvm.eproyectos.dao.ProyectoDao;
import edu.mx.utvm.eproyectos.dao.RubricaDao;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestRubricaService {	
	
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	EvaluadorDao evaluadorDao;
	
	@Autowired
	EvaluacionDao evaluacionDao;	
	
	@Autowired
	ProyectoDao proyectoDao;
	
	@Autowired
	Catalogos catalogos;

	@Autowired
	CategoriaDao categoriaDao;
	
	@Autowired
	RubricaService rubricaService;
	
	@Autowired
	ItemRubricaDao itemRubricaDao;

	@Autowired
	RubricaDao rubricaDao;

	@Autowired
	EscalaDao escalaDao;
	
	@Test
	public void obtenerRubricaPorCategoriaDeProyecto() throws Exception{		
						
		log.info("------------Test obtenerRubricaPorCategoriaDeProyecto ----------------------");				
		
		////////////// Cargando evaluacion, evaluadores y proyectos
		
		Assert.assertNotNull(evaluacionDao);
		String id32 = generateId32();
		Evaluacion evaluacion = new Evaluacion(id32, "Evaluacion UNO",3);
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		log.info("RESUL--->"+evaluacionDao.read(id32).getDescripcion());
		
		// creando evaluador
		String id32Evaluador1 = generateId32();
		Evaluador evaluador = new Evaluador(id32Evaluador1, "Jose Perez Aguirre","Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		evaluadorDao.create(evaluador, evaluacion);
		
		////////////Cargando categorias
		
		Categoria categoria = new Categoria(1, "Desarrollo web");
		categoriaDao.create(categoria);
						
		////////////// Cargando rubricas
		
		Assert.assertNotNull(itemRubricaDao);
		
		Escala escala = new Escala(1, 0, 10);		
		escalaDao.create(escala);		
		
		RubricaPresentacion rubrica = new RubricaPresentacion("1301");
		rubricaDao.create(rubrica);
		
		RubricaCategoria rubrica2 = new RubricaCategoria("1302", new Categoria(1, "Desarrollo web"));
		rubricaDao.create(rubrica2);
		
		ItemRubrica itemRubrica = new ItemRubrica(1, "Deseño", "Caracteristicas e implementacion del diseño", escala);		
		itemRubricaDao.create(itemRubrica, rubrica);
		
		ItemRubrica itemRubrica2 = new ItemRubrica(2, "Desarrollo", "Caracteristicas desarrollo", escala);		
		itemRubricaDao.create(itemRubrica2, rubrica);		
		
		ItemRubrica itemRubrica3 = new ItemRubrica(3, "Deseño1", "Caracteristicas e implementacion del diseño", escala);		
		itemRubricaDao.create(itemRubrica3, rubrica2);
		
		ItemRubrica itemRubrica4 = new ItemRubrica(4, "Desarrollo2", "Caracteristicas desarrollo", escala);		
		itemRubricaDao.create(itemRubrica4, rubrica2);		
		
		catalogos.afterPropertiesSet();
		
		Proyecto proyecto = new Proyecto(generateId32(), "Proyecto de Vida",
				catalogos.getCategorias().get(1), "Mario Rivera");

		proyecto.setArchivoPresentacion(generateBytes());
		proyecto.setFoto(generateBytes());
		proyecto.setLogo(generateBytes());
		
		proyectoDao.create(proyecto,evaluacion);
		
		
		Evaluacion readByIdEvalauador = evaluacionDao.readByIdEvalauador(id32Evaluador1);
		
		Assert.assertNotNull(readByIdEvalauador);
		
		/////////////// Validacion del servicio
		
		RubricaCategoria cp = (RubricaCategoria) rubricaService
				.obtenerRubricaPorCategoriaDeProyecto(proyecto);

		Assert.assertNotNull(cp);
		Assert.assertTrue(cp.getCategoria().getIdCategoria() == categoria.getIdCategoria());
	}
}