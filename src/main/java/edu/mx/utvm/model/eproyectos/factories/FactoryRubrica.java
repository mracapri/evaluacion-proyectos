package edu.mx.utvm.model.eproyectos.factories;

import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

public class FactoryRubrica {
	public Rubrica getRubrica(String idRubrica,Categoria categoria){
		//TODO: Implementar logica para enviar la rubrica por categoria
		return new RubricaCategoria(idRubrica,categoria);		
	}
	
	public Rubrica getRubrica(String idRubrica){
		//TODO: Retorna la rubrica por presentacion ya precargada
		return new RubricaPresentacion(idRubrica);
	}
}
