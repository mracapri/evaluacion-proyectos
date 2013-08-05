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
	
	@Autowired
	private EvaluadorDao evaluadorDao;

	@Override
	public void create(Proyecto newInstance) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public Proyecto read(String id) {
		String sql = "select * from proyecto where id_proyecto = ?";		
		try {
			Proyecto resultado = this.queryForObject(sql,
					new Object[] { id },
					new RowMapper<Proyecto>() {

						@Override
						public Proyecto mapRow(ResultSet rs, int arg1)
								throws SQLException {
							int idcategoria =  rs.getInt("id_categoria");
							Categoria categoria = catalogos.getCategorias().get(idcategoria);										
							
							Proyecto proyecto = new Proyecto(rs.getString("id_proyecto"), rs.getString("nombre"), categoria, rs.getString("responsable"));			
							proyecto.setLogo(rs.getBytes("logo"));
							proyecto.setArchivoPresentacion(rs.getBytes("archivo_presentacion"));
							proyecto.setFoto(rs.getBytes("foto"));
							proyecto.setIntegrantes(rs.getString("integrantes"));
							return proyecto;
						}
						
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}	
	}

	@Override
	public void update(Proyecto transientObject) {
		this.update(
				"UPDATE proyecto " +
				"SET nombre = ?, responsable = ?, logo = ?, archivo_presentacion = ?, foto = ?, integrantes = ? " +
				"WHERE id_proyecto = ?",
				new Object[] {
						transientObject.getNombre(),
						transientObject.getResponsable(),
						transientObject.getLogo(),
						transientObject.getArchivoPresentacion(),
						transientObject.getFoto(),
						transientObject.getIntegrantes(),
						transientObject.getIdProyecto()
				}
			);
	}

	@Override
	public void delete(Proyecto persistentObject) {
		this.update(
				"DELETE FROM proyecto " +
				"WHERE id_proyecto = ?",
				new Object[] {
						persistentObject.getIdProyecto()
				}
			);	
	}

	@Override
	public List<Proyecto> findAll() {
		String sql = "SELECT * FROM proyecto";
		List<Proyecto> result = this.query(sql, new RowMapper<Proyecto>() {
			@Override
			public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idcategoria =  rs.getInt("id_categoria");
				Categoria categoria = catalogos.getCategorias().get(idcategoria);				
				
				Proyecto proyecto = new Proyecto(rs.getString("id_proyecto"), rs.getString("nombre"), categoria, rs.getString("responsable"));			
				proyecto.setLogo(rs.getBytes("logo"));
				proyecto.setArchivoPresentacion(rs.getBytes("archivo_presentacion"));
				proyecto.setFoto(rs.getBytes("foto"));
				proyecto.setIntegrantes(rs.getString("integrantes"));
				return proyecto;
			}
		});
		return result;
	}

	@Override
	public void create(Proyecto proyecto, Evaluacion evaluacion) {
		this.update(
				"INSERT INTO " +
				"proyecto(id_proyecto, nombre, id_categoria, responsable, logo, archivo_presentacion, foto, integrantes) " +
				"VALUES(?,?,?,?,?,?,?,?)",
				new Object[] {
						proyecto.getIdProyecto(),
						proyecto.getNombre(),
						proyecto.getCategoria().getIdCategoria(),
						proyecto.getResponsable(),
						proyecto.getLogo(),
						proyecto.getArchivoPresentacion(),
						proyecto.getFoto(),
						proyecto.getIntegrantes() // TODO: Cambiar por string por que guarda el toString de la lista
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

	@Override
	public Map<String, Proyecto> findAllByIdEvaluacion(String idEvaluacion) {
		String sql = "";
		sql+= "SELECT p.id_proyecto, p.nombre, p.id_categoria, p.responsable, p.logo, p.archivo_presentacion, p.foto, p.integrantes ";
		sql+= "FROM proyecto p, evaluacion_proyectos ep ";
		sql+= "WHERE ep.id_evaluacion = ? and p.id_proyecto = ep.id_proyecto";
		List<Proyecto> result = this.query(sql, new Object[]{idEvaluacion},new RowMapper<Proyecto>() {
			@Override
			public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idcategoria =  rs.getInt("id_categoria");
				Categoria categoria = catalogos.getCategorias().get(idcategoria);
				
				Proyecto proyecto = new Proyecto(rs.getString("id_proyecto"), rs.getString("nombre"), categoria, rs.getString("responsable"));			
				proyecto.setLogo(rs.getBytes("logo"));
				proyecto.setArchivoPresentacion(rs.getBytes("archivo_presentacion"));
				proyecto.setFoto(rs.getBytes("foto"));
				proyecto.setIntegrantes(rs.getString("integrantes"));
				return proyecto;
			}
		});
		
		// transforma a mapa
		Map<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
		for(Proyecto proyecto : result){
			proyectos.put(proyecto.getIdProyecto(), proyecto);
		}
		return proyectos;
	}


	
}