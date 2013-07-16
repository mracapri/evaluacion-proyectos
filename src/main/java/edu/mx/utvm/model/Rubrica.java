package edu.mx.utvm.model;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	private List<ItemRubrica> items;

	public Rubrica() {
		this.items = new ArrayList<ItemRubrica>();
	}
	
	public Rubrica(List<ItemRubrica> items) {
		this.items = items;
	}

	public List<ItemRubrica> getItems() {
		return items;
	}
}
