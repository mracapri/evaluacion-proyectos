package edu.mx.utvm.eproyectos.bootstrap;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mx.utvm.eproyectos.dao.CategoriaDao;
import edu.mx.utvm.eproyectos.dao.EscalaDao;
import edu.mx.utvm.eproyectos.dao.RubricaDao;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.Rubrica;
@Component
public final class Catalogos implements InitializingBean{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/* daos */
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Autowired
	private EscalaDao escalaDao;
	
	@Autowired
	private RubricaDao rubricaDao;
	
	/* listas  */
	private Map<Integer, Categoria> categorias;
	private Map<String, Rubrica> rubricas;
	private Map<Integer, Escala> escalas;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("CARGANDO CATALOGOS");
		categorias = categoriaDao.findAllMap();
		escalas = escalaDao.findAllMap();
		rubricas = rubricaDao.findAllMap();
	}

	public final Map<Integer, Categoria> getCategorias() {
		return categorias;
	}
	
	public final Map<String, Rubrica> getRubricas() {
		return rubricas;
	}	
	
	public final Map<Integer, Escala> getEscalas(){
		return escalas;
	}
}
