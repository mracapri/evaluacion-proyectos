package edu.mx.utvm.eproyectos.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.dao.mapper.CategoriaRowMapper;
import edu.mx.utvm.eproyectos.model.Categoria;

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
				"categoria(id_categoria, descripcion, fecha_creacion) " +
				"VALUES(?,?,now())",
				new Object[] {
						newInstance.getIdCategoria(),
						newInstance.getDescripcion()
				});
	}

	@Override
	public Categoria read(Integer id) {
	    String sql = "select * from categoria where id_categoria = ?";
		try {
			Categoria resultado = this.queryForObject(sql,new Object[] { id }, new CategoriaRowMapper());
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(Categoria transientObject) {
		this.update(
			"UPDATE categoria " +
			"SET descripcion = ?, fecha_creacion = now() " +
			"WHERE id_categoria = ?",
			new Object[] {
					transientObject.getDescripcion(),
					transientObject.getIdCategoria()
			}
		);
	}

	@Override
	public void delete(Categoria persistentObject) throws DataIntegrityViolationException{
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
		List<Categoria> result = this.query(sql, new CategoriaRowMapper());
		return result;
	}

	@Override
	public Map<Integer, Categoria> findAllMap() {
		Map<Integer, Categoria> findAllMap = new HashMap<Integer, Categoria>();
		List<Categoria> findAll = findAll();
		for(Categoria categoria : findAll){
			findAllMap.put(categoria.getIdCategoria(), categoria);
		}
		return findAllMap;
	}

	@Override
	public Integer getId() {
		return this.queryForInt("select coalesce(max(id_categoria)+1,1) from categoria");
	}

}
