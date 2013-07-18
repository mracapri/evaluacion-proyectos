package edu.mx.utvm.model;

public class ItemRubrica {
	private String descripcionCorta;
	private String descripcionLarga;
	private Escala escala;	
	
	public ItemRubrica(String descripcionCorta, String descripcionLarga, Escala escala){
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.escala = escala;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public Escala getEscala() {
		return escala;
	}	
	
}
