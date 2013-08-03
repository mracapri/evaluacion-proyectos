package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Resultado;
@Repository
public class ResultadoDaoImpl extends JdbcTemplate implements ResultadoDao {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(CalificacionEvaluador newInstance) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public CalificacionEvaluador read(Integer id) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void update(CalificacionEvaluador transientObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void delete(CalificacionEvaluador persistentObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
		
	}

	@Override
	public List<CalificacionEvaluador> findAll() {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void create(CalificacionEvaluador newInstance, Evaluacion evaluacion, Proyecto proyecto) {
		for(Integer idItemRubrica : newInstance.getResultadoPorItem().keySet()){
			this.update(
					"INSERT INTO " +
					"resultado(id_evaluacion, id_proyecto, id_evaluador, id_rubrica, id_item_rubrica, calificacion) " +
					"VALUES(?,?,?,?,?,?)",
					new Object[] {
							evaluacion.getIdEvaluacion(),
							proyecto.getIdProyecto(),
							newInstance.getEvaluador().getIdEvaluador(),
							newInstance.getRubrica().getId(),
							idItemRubrica,
							newInstance.getResultadoPorItem().get(idItemRubrica)
					});	
		}
	}
	



}
