package edu.mx.utvm.eproyectos.bootstrap;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mx.utvm.eproyectos.dao.CategoriaDao;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Rubrica;
@Component
public final class Catalogos implements InitializingBean{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/* daos */
	@Autowired
	private CategoriaDao categoriaDao;
	
	/* listas  */
	private List<Categoria> categorias;
	private List<Rubrica> rubricas;
	private List<Escala> escala;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("CARGANDO CATALOGOS");
		categorias = categoriaDao.findAll();
	}

	public final List<Categoria> getCategorias() {
		return categorias;
	}
	
	public final List<Rubrica> getRubricas() {
		return rubricas;
	}	
	
	public final List<Escala> getEscalas(){
		return escala;
		
	}
}
