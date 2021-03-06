/*
 * Prueba de unidad de comportamiento 
 * para el servicio pertinente a Evaluacion
 * 
 * @author Mario Rivera
 */
package edu.mx.utvm.eproyectos.services;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.mx.utvm.eproyectos.dao.EvaluacionDao;
import edu.mx.utvm.eproyectos.model.Evaluacion;

@RunWith(MockitoJUnitRunner.class)
public class TestEvaluacionService {	
	
	@Mock
	private EvaluacionDao dao;
	
	@InjectMocks
	private EvaluacionService service = new EvaluacionServiceImpl();

	@Test
	public void testComportamientoFindAllDelServicio(){
		List<Evaluacion> findAll = service.findAll();
		verify(dao, times(1)).findAll();
	}
	
	@Test
	public void testComportamientoSaveDelServicio(){

		Evaluacion evaluacion = (Evaluacion) anyObject();
		
		// invocacion		
		service.create(evaluacion);
		
		// comprobacion de interaccion
		verify(dao, times(1)).create(evaluacion);
	}
	
	@Test
	public void testComportamientoReadDelServicio(){

		// Clase falsa del tipo evaluacion
		Evaluacion evaluacion = Mockito.mock(Evaluacion.class);
		
		// resultado esperado
		when(dao.read(anyString())).thenReturn(evaluacion);
		
		// invocacion		
		Evaluacion read = service.read("1ZX34EDc12");
		
		// comprobacion de resultado
		Assert.assertNotNull(read);
		
		// comprobacion de interaccion
		verify(dao, times(1)).read(anyString());
	}
}
