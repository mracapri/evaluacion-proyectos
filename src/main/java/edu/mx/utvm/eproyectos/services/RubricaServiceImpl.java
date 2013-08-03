package edu.mx.utvm.eproyectos.services;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;
/*
 * Implementacion del servicio para Rubrica
 * 
 * @author Mario Rivera
 */
@Service
public class RubricaServiceImpl implements RubricaService{

	@Autowired
	private Catalogos catalogos;
	
	@Override
	public Rubrica obtenerRubricaPorCategoriaDeProyecto(Proyecto proyecto) {
		Map<String, Rubrica> rubricas = catalogos.getRubricas();
		Set<String> keySet = rubricas.keySet();
		for(String key : keySet){
			Rubrica rubrica = rubricas.get(key);
			if(rubrica.getClass() == RubricaCategoria.class){
				RubricaCategoria rubricaCategoria = (RubricaCategoria) rubrica;
				if (proyecto.getCategoria().getIdCategoria() == rubricaCategoria
						.getCategoria().getIdCategoria()) {
					return rubricaCategoria;
				}
			}
		}
		return null;
	}

	@Override
	public Rubrica obtenerRubricaPorPresentacion() {
		Map<String, Rubrica> rubricas = catalogos.getRubricas();
		Set<String> keySet = rubricas.keySet();
		for(String key : keySet){
			Rubrica rubrica = rubricas.get(key);
			if(rubrica.getClass() == RubricaPresentacion.class){
				return rubrica;
			}
		}
		return null;
	}

	
}