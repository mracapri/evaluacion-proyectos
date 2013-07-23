package edu.mx.utvm.eproyectos.model;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	private String id;		
	
	public String getId() {
		return id;
	}
	
	private List<ItemRubrica> items;

	public Rubrica(String id) {
		this.items = new ArrayList<ItemRubrica>();
		this.id = id;
	}
	
	public Rubrica(List<ItemRubrica> items) {
		this.items = items;
	}

	public List<ItemRubrica> getItems() {
		return items;
	}
}
