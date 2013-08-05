package edu.mx.utvm.eproyectos.util;

import java.util.Comparator;

import edu.mx.utvm.eproyectos.model.Proyecto;

public class ProyectoRankingComparator implements Comparator<Proyecto>{

	@Override
	public int compare(Proyecto p1, Proyecto p2) {
		if(p1.getResultado().calcularCalificacionGlobal() < p2.getResultado().calcularCalificacionGlobal()){
			return 1;
		}else if(p1.getResultado().calcularCalificacionGlobal() > p2.getResultado().calcularCalificacionGlobal()){
			return -1;
		}else{
			return 0;	
		}
	}

}
