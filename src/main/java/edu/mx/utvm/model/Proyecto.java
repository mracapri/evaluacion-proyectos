package edu.mx.utvm.model;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String idProyecto;
	private String nombre;
	private Categoria categoria;
	private byte[] logo;
	private byte[] archivoPresentacion;
	private byte[] foto;
	private String responsable;
	private List<String> integrantes;
	private ResultadoFinal resultado;
	
	
	public Proyecto(String idProyecto, String nombre, Categoria categoria, String responsable) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.responsable = responsable;
		integrantes = new ArrayList<String>();
	}


	public String getIdProyecto() {
		return idProyecto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public byte[] getLogo() {
		return logo;
	}


	public void setLogo(byte[] logo) {
		this.logo = logo;
	}


	public byte[] getArchivoPresentacion() {
		return archivoPresentacion;
	}


	public void setArchivoPresentacion(byte[] archivoPresentacion) {
		this.archivoPresentacion = archivoPresentacion;
	}


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public String getResponsable() {
		return responsable;
	}


	public List<String> getIntegrantes() {
		return integrantes;
	}


	public ResultadoFinal getResultado() {
		return resultado;
	}


	public void setResultado(ResultadoFinal resultado) {
		this.resultado = resultado;
	}
	
}
