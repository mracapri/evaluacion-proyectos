package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Escala;

@Repository
public class EscalaDaoImpl extends JdbcTemplate implements EscalaDao {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Escala newInstance) {
		this.update(
				"INSERT INTO " +
				"escala(id_escala, inicio, fin) " +
				"VALUES(?,?,?)",
				new Object[] {
						newInstance.getIdEscala(),
						newInstance.getInicio(),
						newInstance.getFin()
				});		
	}

	@Override
	public Escala read(Integer id) {
		String sql = "select * from escala where id_escala = ?";
		try {
			Escala resultado = this.queryForObject(sql,
					new Object[] { id },
					new RowMapper<Escala>() {

						@Override
						public Escala mapRow(ResultSet arg0, int arg1)
								throws SQLException {
							Escala escala = new Escala(arg0.getInt("id_escala"), arg0.getInt("inicio"), arg0.getInt("fin"));
							return escala;
						}
						
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(Escala transientObject) {
		this.update(
				"UPDATE escala " +				
				"SET inicio = ?, " +
				"fin = ? " +
				"WHERE id_escala = ?",
				new Object[] {						
						transientObject.getInicio(),
						transientObject.getFin(),
						transientObject.getIdEscala()
				}
			);
		
	}

	@Override
	public void delete(Escala persistentObject) {
		this.update(
				"DELETE FROM escala " +
				"WHERE id_escala = ?",
				new Object[] {
						persistentObject.getIdEscala()
				}
			);
		
	}

	@Override
	public List<Escala> findAll() {
		String sql = "SELECT * FROM escala";
		List<Escala> result = this.query(sql, new RowMapper<Escala>() {

			@Override
			public Escala mapRow(ResultSet arg0, int arg1) throws SQLException {
				Escala escala = new Escala(arg0.getInt("id_escala"), arg0.getInt("inicio"), arg0.getInt("fin"));
				return escala;				
			}
			
		});
		return result;
	}

	@Override
	public Map<Integer, Escala> findAllMap() {
		Map<Integer, Escala> findAllMap = new HashMap<Integer, Escala>();
		List<Escala> findAll = findAll();
		for(Escala escala : findAll){
			findAllMap.put(escala.getIdEscala(), escala);
		}
		return findAllMap;
	}

}
