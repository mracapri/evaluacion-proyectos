package edu.mx.utvm.eproyectos.bootstrap;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mx.utvm.eproyectos.dao.CategoriaDao;
import edu.mx.utvm.eproyectos.model.Categoria;
@Component
public class Catalogos implements InitializingBean{
	
	@Autowired
	private CategoriaDao categoriaDao;
	private List<Categoria> categorias;
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		categorias = categoriaDao.findAll();
	}



	public final List<Categoria> getCategorias() {
		return categorias;
	}

}
