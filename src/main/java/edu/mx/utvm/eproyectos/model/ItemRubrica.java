package edu.mx.utvm.eproyectos.model;

public class ItemRubrica {
	private int idItemRubrica;
	private String descripcionCorta;
	private String descripcionLarga;
	private Escala escala;	
	
	public ItemRubrica(int idItemRubrica, String descripcionCorta, String descripcionLarga, Escala escala){
		this.idItemRubrica = idItemRubrica;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.escala = escala;
	}

	public int getIdItemRubrica() {
		return idItemRubrica;
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
