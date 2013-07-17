package edu.mx.utvm.model.factories;

import edu.mx.utvm.model.Categoria;
import edu.mx.utvm.model.Rubrica;
import edu.mx.utvm.model.RubricaCategoria;

public class FactoryRubrica {
	public Rubrica getRubrica(Categoria categoria){
		//TODO: Implementar logica para enviar la rubrica por categoria
		return new RubricaCategoria(new Categoria(0,"Desarrollo Web"));
	}
	
	public Rubrica getRubrica(){
		//TODO: Retorna la rubrica por presentacion ya precargada
		return null;
	}
}
