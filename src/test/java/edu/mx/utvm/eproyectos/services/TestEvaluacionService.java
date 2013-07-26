package edu.mx.utvm.eproyectos.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
	public void testComportamientoSaveDelServicio(){

		Evaluacion evaluacion = Mockito.mock(Evaluacion.class);
		
		// resultado esperado
		when(dao.read(1)).thenReturn(evaluacion);
		when(dao.read(0)).thenReturn(null);
		
		// invocacion
		/*Evaluacion read = service.read(-1);		
		Assert.assertNull(read);*/
		
		Evaluacion read = service.read(0);
		Assert.assertNull(read);
		read = service.read(1);
		Assert.assertNotNull(read);
		
		// comprobacion
		verify(dao, times(1)).read(1);
		verify(dao, times(1)).read(0);
	}
}
