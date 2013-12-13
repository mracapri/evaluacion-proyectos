package edu.mx.utvm.eproyectos.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.mx.utvm.eproyectos.model.Categoria;

public class CategoriaRowMapper implements RowMapper<Categoria>{

	@Override
	public Categoria mapRow(ResultSet rs, int arg1) throws SQLException {
		Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));
		categoria.setFechaCreacion(rs.getDate("fecha_creacion"));
		return categoria;
	}

}
