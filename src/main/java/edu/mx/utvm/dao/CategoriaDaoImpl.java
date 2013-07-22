package edu.mx.utvm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.model.Categoria;

@Repository
public class CategoriaDaoImpl extends JdbcTemplate implements CategoriaDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(Categoria newInstance) {
		this.update(
				"INSERT INTO " +
				"categoria(id_categoria, descripcion) " +
				"VALUES(?,?)",
				new Object[] {
						newInstance.getIdCategoria(),
						newInstance.getDescripcion()
				});
	}

	@Override
	public Categoria read(Integer id) {
	    String sql = "select * from categoria where id_categoria = ?";
		try {
			Categoria resultado = this.queryForObject(sql,
					new Object[] { id },
					new RowMapper<Categoria>() {
						@Override
						public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
							Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));							
							return categoria;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(Categoria transientObject) {
		this.update(
			"UPDATE categoria " +
			"SET descripcion = ? " +
			"WHERE id_categoria = ?",
			new Object[] {
					transientObject.getDescripcion(),
					transientObject.getIdCategoria()
			}
		);
	}

	@Override
	public void delete(Categoria persistentObject) {
		this.update(
				"DELETE FROM categoria " +
				"WHERE id_categoria = ?",
				new Object[] {
						persistentObject.getIdCategoria()
				}
			);		
	}

	@Override
	public List<Categoria> findAll() {
		String sql = "SELECT * FROM categoria";
		List<Categoria> result = this.query(sql, new RowMapper<Categoria>() {
			@Override
			public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));
				return categoria;
			}
		});
		return result;
	}

}
