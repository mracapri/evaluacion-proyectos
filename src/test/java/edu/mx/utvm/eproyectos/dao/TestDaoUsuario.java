package edu.mx.utvm.eproyectos.dao;

import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId10;
import static edu.mx.utvm.eproyectos.dao.util.TestData.generateId32;

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

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Usuario;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/AppCtx-Spring-Test.xml")
@Transactional
public class TestDaoUsuario {
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	EvaluadorDao evaluadorDao;
	
	@Autowired
	EvaluacionDao evaluacionDao;	
	
	@Test
	public void crearUsarioEvaluador() {
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluador evaluador = new Evaluador(id32Evaluador, "Jose Perez Aguirre", "Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		
		evaluadorDao.create(evaluador, evaluacion);
		Evaluador read = evaluadorDao.read(id32Evaluador);
		Assert.assertNotNull(read);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		Usuario usuario = new Usuario(generateId10(), "123456");
		usuarioDao.create(usuario);
		
		
		Usuario read2 = usuarioDao.read(usuario.getUsuario());
		Assert.assertNotNull(read2);
	}
	
	
	@Test
	public void eliminaUsarioEvaluador() {
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluador evaluador = new Evaluador(id32Evaluador, "Jose Perez Aguirre", "Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		
		evaluadorDao.create(evaluador, evaluacion);
		Evaluador read = evaluadorDao.read(id32Evaluador);
		Assert.assertNotNull(read);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		Usuario usuario = new Usuario(generateId10(), "123456");
		usuarioDao.create(usuario);
		
		
		Usuario read2 = usuarioDao.read(usuario.getUsuario());
		Assert.assertNotNull(read2);
		
		usuarioDao.delete(read2);
		read2 = usuarioDao.read(usuario.getUsuario());
		Assert.assertNull(read2);
	}
	
	@Test
	public void modificaUsarioEvaluador() {
		Assert.assertNotNull(evaluadorDao);
		
		String id32Evaluacion = generateId32();
		String id32Evaluador = generateId32();
		
		Evaluacion evaluacion = new Evaluacion(id32Evaluacion,"Evaluacion");
		Assert.assertNotNull(evaluacion);
		evaluacionDao.create(evaluacion);
		
		Evaluador evaluador = new Evaluador(id32Evaluador, "Jose Perez Aguirre", "Desarrollo Mobile", generateId10(), "123456");
		Assert.assertNotNull(evaluador);
		
		evaluadorDao.create(evaluador, evaluacion);
		Evaluador read = evaluadorDao.read(id32Evaluador);
		Assert.assertNotNull(read);

		List<Evaluador> all = evaluadorDao.findAll();
		Assert.assertTrue(all.size() == 1);
		
		Usuario usuario = new Usuario(generateId10(), "123456");
		usuarioDao.create(usuario);
		
		String nuevaClave = "rapidoYFurioso";
		usuario.setClave(nuevaClave);
		usuarioDao.update(usuario);
		Usuario read2 = usuarioDao.read(usuario.getUsuario());
		
		Assert.assertNotNull(read2);
		Assert.assertTrue(read2.getClave().equals(nuevaClave));
		
		

	}
}
