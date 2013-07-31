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

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;

@Repository
public class EvaluacionDaoImpl extends JdbcTemplate implements EvaluacionDao{

	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Autowired
	Catalogos catalogos;
	
	@Autowired
	private EvaluadorDao evaluadorDao;


	@Override
	public void create(Evaluacion newInstance) {
		this.update(
				"INSERT INTO " +
				"evaluacion(id_evaluacion, descripcion, descripcion_detallada) " +
				"VALUES(?,?,?)",
				new Object[] {
						newInstance.getIdEvaluacion(),
						newInstance.getDescripcion(),
						newInstance.getDescripcionDetallada()
				});
		
	}

	@Override
	public Evaluacion read(String id) {
		 String sql = "select * from evaluacion where id_evaluacion = ?";
			try {
				Evaluacion resultado = this.queryForObject(sql,
						new Object[] { id },
						new RowMapper<Evaluacion>() {
							@Override
							public Evaluacion mapRow(ResultSet rs, int rowNum) throws SQLException {
								Evaluacion evaluacion = new Evaluacion(rs.getString("id_evaluacion"), rs.getString("descripcion"));							
								return evaluacion;
							}
						});
				return resultado;
			} catch (EmptyResultDataAccessException accessException) {
				return null;
			}
	}

	@Override
	public void update(Evaluacion transientObject) {
		this.update(
				"UPDATE evaluacion " +
				"SET descripcion = ? " +
				"WHERE id_evaluacion = ?",
				new Object[] {
						transientObject.getDescripcion(),
						transientObject.getIdEvaluacion()
				}
			);			
	}

	@Override
	public void delete(Evaluacion persistentObject) {
		this.update(
				"DELETE FROM evaluacion " +
				"WHERE id_evaluacion = ?",
				new Object[] {
						persistentObject.getIdEvaluacion()
				}
			);	
		
	}
	
	@Override
	public List<Evaluacion> findAll() {
		String sql = "SELECT * FROM evaluacion";
		List<Evaluacion> result = this.query(sql, new RowMapper<Evaluacion>() {
			@Override
			public Evaluacion mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				List<Evaluador> evaluadores= evaluadorDao.findAllByIdEvaluacion(rs.getString("id_evaluacion"));
				List<Proyecto> proyecto= findProyectosByIdEvalaucion(rs.getString("id_evaluacion")); //Carga a la lista proyectos el id de la evaluacion
				
				Evaluacion evaluacion = new Evaluacion(rs.getString("id_evaluacion"), rs.getString("descripcion"));
					evaluacion.getProyectos().addAll(proyecto);
					evaluacion.getEvaluadores().addAll(evaluadores);
				return evaluacion;
			}
		});
		return result;
	}

	/*********************Busca proyectos por el id de evaluacion**************************/
	@Override
	public List<Proyecto> findProyectosByIdEvalaucion(String id) {
		String sql = "";
		sql += "SELECT p.id_proyecto, p.nombre, p.id_categoria, p.responsable ";
		sql += "FROM evaluacion_proyectos ep,  proyecto p ";
		sql += "WHERE ep.id_proyecto = p.id_proyecto and ep.id_evaluacion = ?";
		Object[] parametros = {id};
		List<Proyecto> result = this.query(sql, parametros, new RowMapper<Proyecto>() {
			@Override
			public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idcategoria =  rs.getInt("p.id_categoria");
				Categoria categoria = catalogos.getCategorias().get(idcategoria);
				
				Proyecto proyecto = new Proyecto(
						rs.getString("p.id_proyecto"), 
						rs.getString("p.nombre"), 
						categoria,
						rs.getString("p.responsable"));
				return proyecto;
			}
		});
		return result;
	}

	

}