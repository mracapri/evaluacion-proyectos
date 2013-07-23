package edu.mx.utvm.eproyectos.model;

import java.util.List;

public class RubricaPresentacion extends Rubrica {
	public RubricaPresentacion(String idRubrica) {
		super(idRubrica);
	}
	
	public RubricaPresentacion(List<ItemRubrica> items) {
		super(items);
	}
}
