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
public class EvaluadorDaoImpl extends JdbcTemplate implements EvaluadorDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Evaluador newInstance) {
		
	}

	@Override
	public Evaluador read(String id) {
		 String sql = "select * from evaluador where id_evaluador = ?";
			try {
				Evaluador resultado = this.queryForObject(sql,
						new Object[] { id },
						new RowMapper<Evaluador>() {
							@Override
							public Evaluador mapRow(ResultSet rs, int rowNum) throws SQLException {
								Evaluador evaluador = new Evaluador(rs.getString("id_evaluador"), rs.getString("nombre"), rs.getString("especialidad") );							
								return evaluador;
							}
						});
				return resultado;
			} catch (EmptyResultDataAccessException accessException) {
				return null;
			}
	}

	@Override
	public void update(Evaluador transientObject) {
		this.update(
				"UPDATE evaluador " +
				"SET especialidad = ?, nombre = ? " +
				"WHERE id_evaluador = ?",
				new Object[] {
						transientObject.getEspecialidad(),
						transientObject.getNombre(),
						transientObject.getIdEvaluador()
				}
			);	
	}
	

	@Override
	public void delete(Evaluador persistentObject) {
		this.update(
				"DELETE FROM evaluador " +
				"WHERE id_evaluador = ?",
				new Object[] {
						persistentObject.getIdEvaluador()
				}
			);	
		
	}

	@Override
	public List<Evaluador> findAll() {
		String sql = "SELECT * FROM evaluador";
		List<Evaluador> result = this.query(sql, new RowMapper<Evaluador>() {
			@Override
			public Evaluador mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluador evaluador = new Evaluador(rs.getString("id_evaluador"), rs.getString("nombre"), rs.getString("especialidad"));
				return evaluador;
			}
		});
		return result;
	}

	@Override
	public void create(Evaluador evaluador, Evaluacion evaluacion) {
		this.update(
				"INSERT INTO " +
				"evaluador(id_evaluador, nombre, especialidad) " +
				"VALUES(?,?,?)",
				new Object[] {
						evaluador.getIdEvaluador(),
						evaluador.getNombre(),
						evaluador.getEspecialidad()
				});
		
		this.update(
				"INSERT INTO " +
				"evaluacion_evaluadores(id_evaluacion, id_evaluador) " +
				"VALUES(?,?)",
				new Object[] {
						evaluacion.getIdEvaluacion(),
						evaluador.getIdEvaluador()
				});

		
	}

	@Override
	public List<Evaluador> findAllByIdEvaluacion(String idEvaluacion) {
		String sql = "SELECT e.id_evaluador, e.nombre, e.especialidad ";
		sql += "FROM evaluador e, evaluacion_evaluadores ee ";
		sql += "WHERE ee.id_evaluacion = ? AND e.id_evaluador = ee.id_evaluador";

		List<Evaluador> result = this.query(sql, new Object[]{idEvaluacion}, new RowMapper<Evaluador>() {
			@Override
			public Evaluador mapRow(ResultSet rs, int rowNum) throws SQLException {
				Evaluador evaluador = new Evaluador(rs.getString("id_evaluador"), rs.getString("nombre"), rs.getString("especialidad"));
				return evaluador;
			}
		});
		return result;
	}
	
	
	
}