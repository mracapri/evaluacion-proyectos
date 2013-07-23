package edu.mx.utvm.eproyectos.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import edu.mx.utvm.eproyectos.model.Evaluacion;
@RunWith(MockitoJUnitRunner.class)
public class TestEvaluacionService {	
	
	@Test
	public void testComportamientoSaveDelServicio(){
		// Creacion de los mocks
		EvaluacionService service = mock(EvaluacionServiceImpl.class); 
		Evaluacion evaluacion = mock(Evaluacion.class);
		
		service.save(evaluacion);
		
		// definiendo comportamiento
		when(service.read(213460)).thenReturn(evaluacion);
		when(service.read(-1)).thenReturn(null);
		when(service.read(0)).thenReturn(null);
		
		Evaluacion read = service.read(213460);
		Evaluacion readNull = service.read(-1);
		Evaluacion readNullParamCero = service.read(0);

		// se verifica que el metodo save solo se utilize una vez
		verify(service, times(1)).save(evaluacion);

		// se verifica que el metodo save solo se utilize una vez
		verify(service, times(1)).read(213460);
		verify(service, times(1)).read(-1);
		verify(service, times(1)).read(0);
	}
}
