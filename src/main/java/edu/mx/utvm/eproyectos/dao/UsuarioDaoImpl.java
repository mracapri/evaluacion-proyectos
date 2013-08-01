package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Usuario;

@Repository
public class UsuarioDaoImpl extends JdbcTemplate implements UsuarioDao{

	private static final int USUARIO_ACTIVO = 1;
	private static final int USUARIO_ROL_EVALUADOR = 1;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Usuario newInstance) {		
		this.update(
				"INSERT INTO " +
				"usuario(nombre_usuario, clave, fecha_creacion, activo) " +
				"VALUES(?,?,?,?)",
				new Object[] {
						newInstance.getUsuario(),
						newInstance.getClave(),
						new Date(),
						USUARIO_ACTIVO
				});
	}

	@Override
	public Usuario read(String nombreUsuario) {
		String sql = "select * from usuario where nombre_usuario = ?";
		try {
			Usuario resultado = this.queryForObject(sql,
					new Object[] { nombreUsuario },
					new RowMapper<Usuario>() {

						@Override
						public Usuario mapRow(ResultSet arg0, int arg1)
								throws SQLException {
							Usuario usuario = new Usuario(arg0.getString("nombre_usuario"), arg0.getString("clave"));
							return usuario;
						}
						
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(Usuario transientObject) {
		// modifica el usuario y relaciones
		this.update(
			"UPDATE usuario SET clave = ?, activo = ? WHERE nombre_usuario = ?",
			new Object[] {
				transientObject.getClave(),
				transientObject.getActivo(),
				transientObject.getUsuario()
			}
		);		
	}

	@Override
	public void delete(Usuario persistentObject) {
		// elimina el usuario y relaciones
		this.update(
			"DELETE FROM usuario WHERE nombre_usuario = ?",
			new Object[] {
				persistentObject.getUsuario()
			}
		);
	}

	@Override
	public List<Usuario> findAll() {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void createUsuario(Evaluador evaluador) {
		// crea el usuario
		create(evaluador);
		
		// asigna al usuario como evaluador
		this.update(
			"INSERT INTO usuario_evaluador(nombre_usuario, id_evaluador) VALUES(?,?)",
			new Object[] {
				evaluador.getUsuario(),
				evaluador.getIdEvaluador()
			}
		);
		
		// le asigna el rol al usuario
		this.update(
			"INSERT INTO usuario_roles(nombre_usuario, id_role) VALUES(?,?)",
			new Object[] {
				evaluador.getUsuario(),
				USUARIO_ROL_EVALUADOR
			}
		);
	}	
}