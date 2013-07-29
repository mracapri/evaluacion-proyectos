package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Proyecto;

@Repository
public class ProyectoDaoImpl extends JdbcTemplate implements ProyectoDao{
	
		
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Autowired
	private Catalogos catalogos;
	

	@Override
	public void create(Proyecto newInstance) {

	}

	@Override
	public Proyecto read(String id) {
		return null;
	
	}

	@Override
	public void update(Proyecto transientObject) {
		this.update(
				"UPDATE proyecto " +
				"SET nombre = ? " +
				"WHERE id_proyecto = ?",
				new Object[] {
						transientObject.getNombre(),
						transientObject.getIdProyecto()
				}
			);	
		
	}

	@Override
	public void delete(Proyecto persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Proyecto> findAll() {
		String sql = "SELECT * FROM proyecto";
		List<Proyecto> result = this.query(sql, new RowMapper<Proyecto>() {
			@Override
			public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idcategoria =  rs.getInt("p.id_categoria");
				Categoria categoria = catalogos.getCategorias().get(idcategoria);
				Proyecto proyecto = new Proyecto(rs.getString("id_proyecto"), rs.getString("nombre"), categoria, rs.getString("responsable"));
				return proyecto;
			}
		});
		return result;
	}

	@Override
	public void create(Proyecto proyecto, Evaluacion evaluacion) {
		this.update(
				"INSERT INTO " +
				"proyecto(id_proyecto, nombre, id_categoria, responsable, logo, archivo_presentacion, foto) " +
				"VALUES(?,?,?,?,?,?,?)",
				new Object[] {
						proyecto.getIdProyecto(),
						proyecto.getNombre(),
						proyecto.getCategoria().getIdCategoria(),
						proyecto.getResponsable(),
						proyecto.getLogo(),
						proyecto.getArchivoPresentacion(),
						proyecto.getFoto()
				});
	
		this.update(
				"INSERT INTO " +
				"evaluacion_proyectos(id_evaluacion, id_proyecto) " +
				"VALUES(?,?)",
				new Object[] {
						evaluacion.getIdEvaluacion(),
						proyecto.getIdProyecto()
				});

		
	}


	
}