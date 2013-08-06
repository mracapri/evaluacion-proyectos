package edu.mx.utvm.eproyectos.controllers.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.mx.utvm.eproyectos.controllers.formbeans.FormProyecto;

@Component
public class ArchivoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(FormProyecto.class);
	}

	@Override
	public void validate(Object object, Errors error) {
		FormProyecto register = (FormProyecto) object;
		if(register.getFilePdf().getSize() == 0){
			error.rejectValue("archivo", "archivo.empty.validation");
		}
	}
	
	
}
