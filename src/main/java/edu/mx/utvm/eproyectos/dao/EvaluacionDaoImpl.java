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
				"evaluacion(id_evaluacion, descripcion, descripcion_detallada) " +
				"VALUES(?,?,?)",
				new Object[] {
						newInstance.getIdEvaluacion(),
						newInstance.getDescripcion(),
						newInstance.getDescripcionDetallada()
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
				List<Evaluador> evaluadores= findEvaluadoresByIdEvaluacion(rs.getInt("id_evaluacion"));
				Evaluacion evaluacion = new Evaluacion(rs.getInt("id_evaluacion"), rs.getString("descripcion"));
				evaluacion.getEvaluadores().addAll(evaluadores);
				return evaluacion;
			}
		});
		return result;
	}

	@Override
	public List<Evaluador> findEvaluadoresByIdEvaluacion(Integer id) {
		String sql = "";
		sql += "SELECT ev.id_evaluador, ev.nombre, ev.especialidad ";
		sql += "FROM evaluacion_evaluadores ee,  evaluador ev ";
		sql += "WHERE ee.id_evaluador = ev.id_evaluador and ee.id_evaluacion = ?";
		Object[] parametros = {id};
		List<Evaluador> result = this.query(sql, parametros, new RowMapper<Evaluador>() {
			@Override
			public Evaluador mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluador evaluador = new Evaluador(
						rs.getInt("ev.id_evaluador"), 
						rs.getString("ev.nombre"), 
						rs.getString("ev.especialidad"));
				return evaluador;
			}
		});
		return result;
	}

	

}