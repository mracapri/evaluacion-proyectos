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
		this.update(
				"INSERT INTO " +
				"evaluador(id_evaluador, nombre, especialidad) " +
				"VALUES(?,?,?)",
				new Object[] {
						newInstance.getIdEvaluador(),
						newInstance.getNombre(),
						newInstance.getEspecialidad()
				});
		
	}

	@Override
	public Evaluador read(Integer id) {
		 String sql = "select * from evaluador where id_evaluador = ?";
			try {
				Evaluador resultado = this.queryForObject(sql,
						new Object[] { id },
						new RowMapper<Evaluador>() {
							@Override
							public Evaluador mapRow(ResultSet rs, int rowNum) throws SQLException {
								Evaluador evaluador = new Evaluador(rs.getInt("id_evaluador"), rs.getString("nombre"), rs.getString("especialidad") );							
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
				"SET especialidad = ? " +
				"WHERE id_evaluador = ?",
				new Object[] {
						transientObject.getEspecialidad(),
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
				Evaluador evaluador = new Evaluador(rs.getInt("id_evaluador"), rs.getString("nombre"), rs.getString("especialidad"));
				return evaluador;
			}
		});
		return result;
	}
	
	
	
}