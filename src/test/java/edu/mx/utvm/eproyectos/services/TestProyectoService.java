/*
 * Prueba de unidad de comportamiento 
 * para el servicio pertinente a Proyecto
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

import edu.mx.utvm.eproyectos.dao.ProyectoDao;
import edu.mx.utvm.eproyectos.model.Proyecto;

@RunWith(MockitoJUnitRunner.class)
public class TestProyectoService {	
	
	@Mock
	private ProyectoDao dao;
	
	@InjectMocks
	private ProyectoService service = new ProyectoServiceImpl();

	@Test
	public void testComportamientoFindAllDelServicio(){
		List<Proyecto> findAll = service.findAll();
		verify(dao, times(1)).findAll();
	}
	
	@Test
	public void testComportamientoSaveDelServicio(){

		Proyecto Proyecto = (Proyecto) anyObject();
		
		// invocacion		
		service.create(Proyecto);
		
		// comprobacion de interaccion
		verify(dao, times(1)).create(Proyecto);
	}
	
	@Test
	public void testComportamientoReadDelServicio(){

		// Clase falsa del tipo Proyecto
		Proyecto Proyecto = Mockito.mock(Proyecto.class);
		
		// resultado esperado
		when(dao.read(anyString())).thenReturn(Proyecto);
		
		// invocacion		
		Proyecto read = service.read("1ZX34EDc12");
		
		// comprobacion de resultado
		Assert.assertNotNull(read);
		
		// comprobacion de interaccion
		verify(dao, times(1)).read(anyString());
	}
}
