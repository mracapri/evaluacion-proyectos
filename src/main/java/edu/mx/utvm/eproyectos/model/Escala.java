package edu.mx.utvm.eproyectos.model;

public class Escala {
	private int idEscala;	
	private int inicio;
	private int fin;
	
	public Escala(int idEscala,int inicio, int fin){
		this.idEscala = idEscala;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public int getIdEscala() {
		return idEscala;
	}	
	public int getInicio() {
		return inicio;
	}	
	public int getFin() {
		return fin;
	}	
}
