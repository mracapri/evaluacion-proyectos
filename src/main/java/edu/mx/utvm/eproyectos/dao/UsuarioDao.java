package edu.mx.utvm.eproyectos.dao;

import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Usuario;

public interface UsuarioDao extends Dao<Usuario, String>{	
	void createUsuario(Evaluador evaluador);
}
