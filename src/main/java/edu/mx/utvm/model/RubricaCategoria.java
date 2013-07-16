package edu.mx.utvm.model;

import java.util.List;

public class RubricaCategoria extends Rubrica {
	private Categoria categoria;

	public RubricaCategoria(Categoria categoria) {
		super();
		this.categoria = categoria;
	}
	
	public RubricaCategoria(Categoria categoria, List<ItemRubrica> items) {
		super(items);
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
