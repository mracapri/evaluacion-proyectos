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
public class EvaluadorDaoImpl extends JdbcTemplate implements EvaluadorDao {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(Evaluador newInstance) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public Evaluador read(String id) {
		String sql = "";
		sql += "SELECT e.id_evaluador, e.nombre, e.especialidad, u.nombre_usuario, u.clave ";
		sql += "FROM evaluador e, usuario u, usuario_evaluador eu ";
		sql += "WHERE eu.id_evaluador = ? and u.nombre_usuario = eu.nombre_usuario";
		try {
			Evaluador resultado = this.queryForObject(sql, new Object[] { id },
					new RowMapper<Evaluador>() {
						@Override
						public Evaluador mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Evaluador evaluador = new Evaluador(
									rs.getString("e.id_evaluador"), rs.getString("e.nombre"),
									rs.getString("e.especialidad"), rs.getString("u.nombre_usuario"), rs.getString("u.clave"));
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
		// actualizar usuario
		usuarioDao.update(transientObject);
		
		// actualizar evaluador
		this.update(
				"UPDATE evaluador " + "SET especialidad = ?, nombre = ? "
						+ "WHERE id_evaluador = ?",
				new Object[] { transientObject.getEspecialidad(),
						transientObject.getNombre(),
						transientObject.getIdEvaluador() });
	}

	@Override
	public void delete(Evaluador persistentObject) {
		// elimina el usuario
		usuarioDao.delete(persistentObject);
		
		// elimina al evaluador
		this.update("DELETE FROM evaluador " + "WHERE id_evaluador = ?",
				new Object[] { persistentObject.getIdEvaluador() });

	}

	@Override
	public List<Evaluador> findAll() {
		String sql = "SELECT e.id_evaluador, e.nombre, e.especialidad, u.nombre_usuario, u.clave ";
		sql += "FROM evaluador e, usuario u, usuario_evaluador eu ";
		sql += "WHERE eu.id_evaluador = e.id_evaluador and u.nombre_usuario = eu.nombre_usuario";
		List<Evaluador> result = this.query(sql, new RowMapper<Evaluador>() {
			@Override
			public Evaluador mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Evaluador evaluador = new Evaluador(
						rs.getString("e.id_evaluador"), rs.getString("e.nombre"),
						rs.getString("e.especialidad"), rs.getString("u.nombre_usuario"), rs.getString("u.clave"));
				return evaluador;
			}
		});
		return result;
	}

	@Override
	public void create(Evaluador evaluador, Evaluacion evaluacion) {
		// crea el evaluador
		this.update(
				"INSERT INTO " +
				"evaluador(id_evaluador, nombre, especialidad) " +
				"VALUES(?,?,?)",
				new Object[] {
						evaluador.getIdEvaluador(),
						evaluador.getNombre(),
						evaluador.getEspecialidad()
				});
		
		// asigna el evaluador a la evaluacion
		this.update(
				"INSERT INTO " +
				"evaluacion_evaluadores(id_evaluacion, id_evaluador) " +
				"VALUES(?,?)",
				new Object[] {
						evaluacion.getIdEvaluacion(),
						evaluador.getIdEvaluador()
				});
		
		// crea un usuario para el evaluador
		usuarioDao.createUsuario(evaluador);
	}

	@Override
	public List<Evaluador> findAllByIdEvaluacion(String idEvaluacion) {
		String sql = "";
		sql += "SELECT e.id_evaluador, e.nombre, e.especialidad, u.nombre_usuario, u.clave ";
		sql += "FROM evaluador e, usuario u, usuario_evaluador eu, evaluacion_evaluadores ee ";
		sql += "WHERE e.id_evaluador = eu.id_evaluador ";
		sql += 		"and u.nombre_usuario = eu.nombre_usuario ";
		sql += 		"and ee.id_evaluacion = ? ";
		sql += 		"and e.id_evaluador = ee.id_evaluador";

		List<Evaluador> result = this.query(sql, new Object[] { idEvaluacion },
				new RowMapper<Evaluador>() {
					@Override
					public Evaluador mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Evaluador evaluador = new Evaluador(
								rs.getString("e.id_evaluador"), rs.getString("e.nombre"),
								rs.getString("e.especialidad"), rs.getString("u.nombre_usuario"), rs.getString("u.clave"));
						return evaluador;
					}
				});
		return result;
	}
}