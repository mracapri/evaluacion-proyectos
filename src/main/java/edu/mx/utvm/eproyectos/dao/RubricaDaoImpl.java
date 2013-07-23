package edu.mx.utvm.eproyectos.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

@Repository
public class RubricaDaoImpl extends JdbcTemplate implements RubricaDao {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Rubrica newInstance) {
		String sql = "INSERT INTO rubrica ";
		sql = sql + "(id_rubrica, id_categoria) VALUES(?,?)";
		Object[] parametros = {};
		
		log.info("-----------"+newInstance.getClass());
		
		if(newInstance.getClass() == RubricaCategoria.class){
			RubricaCategoria rubricaCategoria = (RubricaCategoria) newInstance;
			parametros = new Object[] { newInstance.getId(), rubricaCategoria.getCategoria().getIdCategoria() };			
		}else if (newInstance.getClass() == RubricaPresentacion.class) {
			parametros = new Object[] { newInstance.getId(), null };
		}
		
		this.update(sql, parametros);
	}
	
	@Override
	public Rubrica read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Rubrica transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Rubrica persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rubrica> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
