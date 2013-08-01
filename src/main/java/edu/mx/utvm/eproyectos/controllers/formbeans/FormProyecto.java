package edu.mx.utvm.eproyectos.controllers.formbeans;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormProyecto {
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String lider;
	
	@NotEmpty
	private String integrantes;
	
	@Min(1)
	private int idCategoria;	
	
	private CommonsMultipartFile logo;
	private CommonsMultipartFile filePdf;
	private CommonsMultipartFile fotoEquipo;
		
	private int noPresentacion;	
	private int noCategoria;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLider() {
		return lider;
	}
	public void setLider(String lider) {
		this.lider = lider;
	}
	public String getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public CommonsMultipartFile getLogo() {
		return logo;
	}
	public void setLogo(CommonsMultipartFile logo) {
		this.logo = logo;
	}
	public CommonsMultipartFile getFilePdf() {
		return filePdf;
	}
	public void setFilePdf(CommonsMultipartFile filePdf) {
		this.filePdf = filePdf;
	}
	public CommonsMultipartFile getFotoEquipo() {
		return fotoEquipo;
	}
	public void setFotoEquipo(CommonsMultipartFile fotoEquipo) {
		this.fotoEquipo = fotoEquipo;
	}
	public int getNoPresentacion() {
		return noPresentacion;
	}
	public void setNoPresentacion(int noPresentacion) {
		this.noPresentacion = noPresentacion;
	}
	public int getNoCategoria() {
		return noCategoria;
	}
	public void setNoCategoria(int noCategoria) {
		this.noCategoria = noCategoria;
	}	
}
