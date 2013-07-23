package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;

@Repository
public class EvaluacionDaoImpl extends JdbcTemplate implements EvaluacionDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(Evaluacion newInstance) {
		this.update(
				"INSERT INTO " +
				"evaluacion(id_evaluacion, descripcion) " +
				"VALUES(?,?)",
				new Object[] {
						newInstance.getIdEvaluacion(),
						newInstance.getDescripcion()
				});
		
	}

	@Override
	public Evaluacion read(Integer id) {
		 String sql = "select * from evaluacion where id_evaluacion = ?";
			try {
				Evaluacion resultado = this.queryForObject(sql,
						new Object[] { id },
						new RowMapper<Evaluacion>() {
							@Override
							public Evaluacion mapRow(ResultSet rs, int rowNum) throws SQLException {
								Evaluacion evaluacion = new Evaluacion(rs.getInt("id_evaluacion"), rs.getString("descripcion"));							
								return evaluacion;
							}
						});
				return resultado;
			} catch (EmptyResultDataAccessException accessException) {
				return null;
			}
	}

	@Override
	public void update(Evaluacion transientObject) {
		this.update(
				"UPDATE evaluacion " +
				"SET descripcion = ? " +
				"WHERE id_evaluacion = ?",
				new Object[] {
						transientObject.getDescripcion(),
						transientObject.getIdEvaluacion()
				}
			);			
	}

	@Override
	public void delete(Evaluacion persistentObject) {
		this.update(
				"DELETE FROM evaluacion " +
				"WHERE id_evaluacion = ?",
				new Object[] {
						persistentObject.getIdEvaluacion()
				}
			);	
		
	}

	@Override
	public List<Evaluacion> findAll() {
		String sql = "SELECT * FROM evaluacion";
		List<Evaluacion> result = this.query(sql, new RowMapper<Evaluacion>() {
			@Override
			public Evaluacion mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluacion evaluacion = new Evaluacion(rs.getInt("id_evaluacion"), rs.getString("descripcion"));
				return evaluacion;
			}
		});
		return result;
	}

	@Override
	public List<Evaluador> findEvaluadorByEvaluacion(int idevaluacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		
	
}