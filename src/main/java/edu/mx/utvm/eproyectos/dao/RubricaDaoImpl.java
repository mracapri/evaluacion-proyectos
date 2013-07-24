package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.eproyectos.model.Categoria;
import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Rubrica;
import edu.mx.utvm.eproyectos.model.RubricaCategoria;
import edu.mx.utvm.eproyectos.model.RubricaPresentacion;

@Repository
public class RubricaDaoImpl extends JdbcTemplate implements RubricaDao {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	ItemRubricaDao itemRubricaDao;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Rubrica newInstance) {
		String sql = "INSERT INTO rubrica ";
		sql = sql + "(id_rubrica, id_categoria) VALUES(?,?)";
		Object[] parametros = {};
		
		if(newInstance.getClass() == RubricaCategoria.class){
			RubricaCategoria rubricaCategoria = (RubricaCategoria) newInstance;
			parametros = new Object[] { newInstance.getId(), rubricaCategoria.getCategoria().getIdCategoria() };			
		}else if (newInstance.getClass() == RubricaPresentacion.class) {
			parametros = new Object[] { newInstance.getId(), null };
		}
		
		this.update(sql, parametros);
				
	}
	
	@Override
	public Rubrica read(String id) {
		String sql = "SELECT * FROM rubrica WHERE id_rubrica = ?";
		try {
			Rubrica resultado =  this.queryForObject(sql, new Object[] { id },
					new RowMapper<Rubrica>() {

						@Override
						public Rubrica mapRow(ResultSet arg0, int arg1)
								throws SQLException {
								Rubrica rubrica = null;
								if(arg0.getObject("id_categoria") != null){
									Categoria categoria = new Categoria(arg0.getInt("id_categoria"), ""); // por catalogo
									rubrica = new RubricaCategoria(arg0.getString("id_rubrica"), categoria);
								}else{
									rubrica = new RubricaPresentacion(arg0.getString("id_rubrica"));
								}								
								
								return  rubrica;
																				
						}

					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
		
	}

	@Override
	public void update(Rubrica transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Rubrica persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Rubrica> findAll() {
		String sql = "SELECT * FROM rubrica ";
		List<Rubrica> result = this.query(sql, new RowMapper<Rubrica>(){

			@Override
			public Rubrica mapRow(ResultSet arg0, int arg1) throws SQLException {							
				
				Rubrica rubrica = null;
				
				List<ItemRubrica> itemsRubrica = itemRubricaDao.findItemsRubricaByIdRubrica(arg0.getString("id_rubrica"));
				
				if(arg0.getObject("id_categoria") != null){
					Categoria categoria = new Categoria(arg0.getInt("id_categoria"), ""); // Por catalogo					
					rubrica = new RubricaCategoria(arg0.getString("id_rubrica"), categoria);										
				}else{
					rubrica = new RubricaPresentacion(arg0.getString("id_rubrica"));					
					
				}				
				rubrica.getItems().addAll(itemsRubrica);
				return rubrica;												
			}
			
		}); 
		return result;
	}

}
