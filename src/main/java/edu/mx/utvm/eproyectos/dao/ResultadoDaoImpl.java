package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Resultado;
@Repository
public class ResultadoDaoImpl extends JdbcTemplate implements ResultadoDao {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Resultado newInstance) {
		this.update(
				"INSERT INTO " +
				"resultado(id_evaluacion, id_proyecto, id_evaluador, id_rubrica, id_item_rubrica, calificacion) " +
				"VALUES(?,?,?,?,?,?)",
				new Object[] {
						newInstance.getIdEvaluacion(),
						newInstance.getIdProyecto(),
						newInstance.getIdEvaluador(),
						newInstance.getIdRubrica(),
						newInstance.getIdItemRubrica(),
						newInstance.getCalificacion()
				});	
		
	}

	@Override
	public Resultado read(Integer id) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void update(Resultado transientObject) {		
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void delete(Resultado persistentObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public List<Resultado> findAll() {
		String sql = "SELECT * FROM resultado";
		List<Resultado> result = this.query(sql, new RowMapper<Resultado>() {

			@Override
			public Resultado mapRow(ResultSet arg0, int arg1)
					throws SQLException {
					Resultado resultado = new Resultado(arg0.getString("id_evaluacion"), arg0.getString("id_proyecto"), arg0.getString("id_evaluador"), arg0.getString("id_rubrica"), arg0.getInt("id_item_rubrica"), arg0.getDouble("calificacion"));
				return resultado;
			}
			
			
		});
		return result;
	}

	@Override
	public List<Resultado> findAllByProyecto(String id) {
		String sql = "SELECT * FROM resultado WHERE id_proyecto = ?";
		List<Resultado> result = this.query(sql, new Object[] { id },
				new RowMapper<Resultado>() {
					@Override
					public Resultado mapRow(ResultSet arg0, int arg1)
							throws SQLException {
						Resultado resultado = new Resultado(
								arg0.getString("id_evaluacion"), 
								arg0.getString("id_proyecto"), 
								arg0.getString("id_evaluador"),
								arg0.getString("id_rubrica"), 
								arg0.getInt("id_item_rubrica"), 
								arg0.getDouble("calificacion"));
						return resultado;
					}

				});
		return result;
	}

}
