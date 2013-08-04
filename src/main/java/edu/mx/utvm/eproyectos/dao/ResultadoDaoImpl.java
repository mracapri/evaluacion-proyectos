package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.CalificacionEvaluador;
import edu.mx.utvm.eproyectos.model.Evaluacion;
import edu.mx.utvm.eproyectos.model.Evaluador;
import edu.mx.utvm.eproyectos.model.Proyecto;
import edu.mx.utvm.eproyectos.model.Resultado;
import edu.mx.utvm.eproyectos.model.Rubrica;

@Repository
public class ResultadoDaoImpl extends JdbcTemplate implements ResultadoDao {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private EvaluadorDao evaluadorDao;

	@Autowired
	private RubricaDao rubricaDao;
	
 	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public boolean laRubricaYaFueCapuradaParaElProyecto(Proyecto proyecto, CalificacionEvaluador calificacion) {
		String sql = "select count(1) from resultado where id_proyecto = ? and id_rubrica = ? and id_evaluador = ?";

		int queryForInt = this.queryForInt(sql,new Object[] { 
				proyecto.getIdProyecto(),
				calificacion.getRubrica().getId(),
				calificacion.getEvaluador().getIdEvaluador() 
		});
		
		if(queryForInt > 0){
			return true;
		}else{
			return false;
		}
	}
 	
	@Override
	public void create(CalificacionEvaluador newInstance,
			Evaluacion evaluacion, Proyecto proyecto) {
		for (Integer idItemRubrica : newInstance.getResultadoPorItem().keySet()) {
			this.update(
					"INSERT INTO "
							+ "resultado(id_evaluacion, id_proyecto, id_evaluador, id_rubrica, id_item_rubrica, calificacion) "
							+ "VALUES(?,?,?,?,?,?)",
					new Object[] {
							evaluacion.getIdEvaluacion(),
							proyecto.getIdProyecto(),
							newInstance.getEvaluador().getIdEvaluador(),
							newInstance.getRubrica().getId(),
							idItemRubrica,
							newInstance.getResultadoPorItem()
									.get(idItemRubrica) });
		}
	}

	@Override
	public List<CalificacionEvaluador> findAllByProyecto(String idProyecto) {
		String sql = "SELECT * FROM resultado WHERE id_proyecto = ?";
		List<Resultado> result = this.query(sql, new Object[] { idProyecto },
				new RowMapper<Resultado>() {
					@Override
					public Resultado mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Resultado resultado = new Resultado(rs
								.getString("id_evaluacion"), rs
								.getString("id_proyecto"), rs
								.getString("id_evaluador"), rs
								.getString("id_rubrica"), rs
								.getInt("id_item_rubrica"), rs
								.getDouble("calificacion"));

						return resultado;
					}

				});

		List<CalificacionEvaluador> calificaciones = new ArrayList<CalificacionEvaluador>();

		Set<String> idsEvaluadores = new HashSet<String>();
		for (Resultado resultado : result) {
			idsEvaluadores.add(resultado.getIdEvaluador());
		}

		log.debug("idEvaluadores: " + idsEvaluadores);

		for (String idEvaluador : idsEvaluadores) {
			Evaluador evaluador = evaluadorDao.read(idEvaluador);
			CalificacionEvaluador calificacionEvaluador = null;
			Map<Integer, Double> resultados = null;

			Set<String> idsRubrica = new HashSet<String>();
			for (Resultado resultado : result) {
				if (resultado.getIdEvaluador().equals(idEvaluador)) {
					idsRubrica.add(resultado.getIdRubrica());
				}
			}

			for (String idRubrica : idsRubrica) {
				Rubrica rubrica = rubricaDao.read(idRubrica);
				resultados = new HashMap<Integer, Double>();
				for (Resultado resultado : result) {
					if (idEvaluador.equals(resultado.getIdEvaluador())
							&& idRubrica.equals(resultado.getIdRubrica())) {
						resultados.put(resultado.getIdItemRubrica(),
								resultado.getCalificacion());
					}
				}
				calificacionEvaluador = new CalificacionEvaluador(evaluador,
						resultados, rubrica);
				calificaciones.add(calificacionEvaluador);
			}
		}

		return calificaciones;
	}

	@Override
	public void create(CalificacionEvaluador newInstance) {
		throw new UnsupportedOperationException("Metodo no implementado");

	}

	@Override
	public CalificacionEvaluador read(Integer id) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void update(CalificacionEvaluador transientObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public void delete(CalificacionEvaluador persistentObject) {
		throw new UnsupportedOperationException("Metodo no implementado");
	}

	@Override
	public List<CalificacionEvaluador> findAll() {
		throw new UnsupportedOperationException("Metodo no implementado");
	}
}
