package edu.mx.utvm.eproyectos.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoResultado {
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private ResultadoDao resultadoDao;

	@Autowired
	private EvaluacionDao evaluacionDao;

	@Autowired
	private ProyectoDao proyectoDao;

	@Autowired
	private RubricaDao rubricaDao;

	@Autowired
	private ItemRubricaDao itemRubricaDao;

	@Autowired
	private Catalogos catalogos;

	@Autowired
	private CategoriaDao categoriaDao;

	@Autowired
	private EscalaDao escalaDao;

	@Autowired
	private EvaluadorDao evaluadorDao;

	private Categoria categoria1;
	private Escala escala1;

	@Before
	public void cargaCatalogos() throws Exception {
		/* Cragando elementos en categorias */
		Categoria categoriaObj = new Categoria(1, "Desktop");
		categoriaDao.create(categoriaObj);

		Escala escala = new Escala(1, 0, 10);
		escalaDao.create(escala);

		categoria1 = categoriaObj;
		escala1 = escala;

		catalogos.afterPropertiesSet();
	}

	@Test
	public void insertAndFindAll() {
		log.info("-----------------Test2--------------");
		Assert.assertNotNull(resultadoDao);

		/* Create evaluacion */
		Evaluacion evaluacion = new Evaluacion(
				"25bbdcd06c32d477f7fa1c3e4a91b032", "Evaluacion 2013",3);
		evaluacionDao.create(evaluacion);

		/* Create proyecto */
		Proyecto proyecto = new Proyecto("130101", "Kinect", categoria1,
				"Israel Paz");
		proyectoDao.create(proyecto, evaluacion);

		/* Create Rubrica */
		RubricaCategoria rubrica = new RubricaCategoria("1301", categoria1);
		rubricaDao.create(rubrica);
		
		RubricaPresentacion rubricaPresentacion = new RubricaPresentacion("1305");
		rubricaDao.create(rubricaPresentacion);

		/* Create Item rubrica */
		ItemRubrica itemRubrica = new ItemRubrica(1, "Desenio",
				"Caracteristicas e implementacion del disenio", escala1);
		itemRubricaDao.create(itemRubrica, rubrica);

		ItemRubrica itemRubrica2 = new ItemRubrica(2, "Desenio",
				"Caracteristicas de desarrollo de interfaces", escala1);
		itemRubricaDao.create(itemRubrica2, rubrica);

		ItemRubrica itemRubricaP1 = new ItemRubrica(3, "Ortografia",
				"Caracteristicas e implementacion del disenio", escala1);
		itemRubricaDao.create(itemRubricaP1, rubricaPresentacion);

		// agregando el item a la rubrica
		rubrica.getItems().add(itemRubrica);

		rubrica.getItems().add(itemRubrica2);
		rubricaPresentacion.getItems().add(itemRubricaP1);

		/* Evalaudor */
		Evaluador evaluador = new Evaluador("68a9e49bbc88c02083a062a78ab3bf30",
				"Emmanuel", "TIC", "mayri", "asdasd12");
		evaluadorDao.create(evaluador, evaluacion);

		Evaluador evaluador2 = new Evaluador("68a9e49bbc88c020862a78ab3bf31",
				"Ricardo", "TIC", "rica", "asdasd12");
		evaluadorDao.create(evaluador2, evaluacion);

		Evaluador evaluador3 = new Evaluador("68a9e4c02083a062a78ab3bf32",
				"Israel", "TIC", "esso", "asdasd12");
		evaluadorDao.create(evaluador3, evaluacion);

		Map<Integer, Double> resultadoPorItem = new HashMap<Integer, Double>();
		resultadoPorItem.put(1, 10d);
		resultadoPorItem.put(2, 9d);

		Map<Integer, Double> resultadoPorItemPre = new HashMap<Integer, Double>();
		resultadoPorItemPre.put(3, 8d);

		CalificacionEvaluador cal = new CalificacionEvaluador(evaluador,
				resultadoPorItem, rubrica);
		CalificacionEvaluador cal2 = new CalificacionEvaluador(evaluador2,
				resultadoPorItem, rubrica);
		CalificacionEvaluador cal3 = new CalificacionEvaluador(evaluador3,
				resultadoPorItem, rubrica);
		CalificacionEvaluador cal4 = new CalificacionEvaluador(evaluador3,
				resultadoPorItemPre, rubricaPresentacion);

		resultadoDao.create(cal, evaluacion, proyecto);
		resultadoDao.create(cal2, evaluacion, proyecto);
		resultadoDao.create(cal3, evaluacion, proyecto);

		List<CalificacionEvaluador> findAllByProyecto = resultadoDao
				.findAllByProyecto("130101");
		
		Assert.assertFalse(resultadoDao.laRubricaYaFueCapuradaParaElProyecto(proyecto, cal4));
		resultadoDao.create(cal4, evaluacion, proyecto);
		Assert.assertTrue(resultadoDao.laRubricaYaFueCapuradaParaElProyecto(proyecto, cal4));

		findAllByProyecto = resultadoDao.findAllByProyecto("130101");
		
		for (CalificacionEvaluador calEva : findAllByProyecto) {
			log.debug("TOTAL POR EVALUADOR: " + calEva.calcularTotal() + "   "
					+ calEva.getRubrica() + "   "
					+ calEva.getEvaluador().getNombre() + "   resultados: "
					+ calEva.getResultadoPorItem());
		}
		log.debug(findAllByProyecto);

		Assert.assertTrue(findAllByProyecto.size() == 4);
	}
}