package edu.mx.utvm.eproyectos.controllers.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mx.utvm.eproyectos.controllers.formbeans.FormEvaluacion;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormEvaluador;
import edu.mx.utvm.eproyectos.controllers.formbeans.FormProyecto;
import edu.mx.utvm.eproyectos.dao.UsuarioDao;

@Component
public class UserUniqueValidator implements Validator {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public void validate(Object target, Errors errors) {

		if(target.getClass() == FormEvaluador.class){
			FormEvaluador formEvaluador = (FormEvaluador) target;
			String usuario = formEvaluador.getUsuario();

			if (usuarioDao.read(usuario) != null) {
				errors.rejectValue("usuario", "usuario.ya.existente");
			}	
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FormEvaluador.class)
				|| clazz.isAssignableFrom(FormEvaluacion.class)
				|| clazz.isAssignableFrom(FormProyecto.class);
	}
}
