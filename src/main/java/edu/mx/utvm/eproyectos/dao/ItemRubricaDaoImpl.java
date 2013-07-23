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
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.ItemRubrica;
import edu.mx.utvm.eproyectos.model.Rubrica;

@Repository
public class ItemRubricaDaoImpl extends JdbcTemplate implements ItemRubricaDao {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Autowired
	private Catalogos catalogos;
	
	@Override
	public void create(ItemRubrica newInstance) {
		
	}

	@Override
	public ItemRubrica read(Integer id) {
		String sql = "select * from item_rubrica where id_item_rubrica = ?";
		try {
			ItemRubrica resultado = this.queryForObject(sql,
					new Object[] { id },
					new RowMapper<ItemRubrica>() {

						@Override
						public ItemRubrica mapRow(ResultSet arg0, int arg1)
								throws SQLException {
								/*Revisar si el constructor necesita solo el id e implementar seters*/
								int idEscala = arg0.getInt("id_escala");
								Escala escala = catalogos.getEscalas().get(idEscala);								
								ItemRubrica itemRubrica = new ItemRubrica(arg0.getInt("id_item_rubrica"), arg0.getString("descripcion_corta"), arg0.getString("descripcion_larga"), escala);
							return itemRubrica;
						}
						
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}		
	}

	@Override
	public void update(ItemRubrica transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ItemRubrica persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemRubrica> findAll() {
		String sql = "SELECT * FROM item_rubrica";
		List<ItemRubrica> result = this.query(sql, new RowMapper<ItemRubrica>() {

			@Override
			public ItemRubrica mapRow(ResultSet arg0, int arg1)
					throws SQLException {
					/*Revisar si el constructor necesita solo el id e implementar seters*/
					int idEscala = arg0.getInt("id_escala");
					Escala escala = catalogos.getEscalas().get(idEscala);		
					
					ItemRubrica itemRubrica = new ItemRubrica(arg0.getInt("id_item_rubrica"), arg0.getString("descripcion_corta"), arg0.getString("descripcion_larga"), escala);
				return itemRubrica;
			}
			
		});
		return result;
	}

	@Override
	public void create(ItemRubrica newInstance, Rubrica rubrica) {
		String sql = "INSERT INTO item_rubrica ";
		sql = sql + "(id_item_rubrica, descripcion_corta, descripcion_larga, id_escala) VALUES(?,?,?,?)";		
		
		this.update(sql, new Object[]{
				newInstance.getIdItemRubrica(),
				newInstance.getDescripcionCorta(),
				newInstance.getDescripcionLarga(),
				newInstance.getEscala().getIdEscala()
		});		
		
		sql = "INSERT INTO rubrica_items_rubrica(id_rubrica, id_item_rubrica) VALUES(?,?)";
		this.update(sql, new Object[]{
				rubrica.getId(),
				newInstance.getIdItemRubrica()
		});
		
	}

	@Override
	public List<ItemRubrica> findItemsRubricaByIdRubrica(String id) {
		String sql = "";
		sql += "SELECT ir.id_item_rubrica, ir.descripcion_corta, ir.descripcion_larga, ir.id_escala ";
		sql += "FROM rubrica_items_rubrica rir, item_rubrica ir ";
		sql += "WHERE ir.id_item_rubrica = rir.id_item_rubrica and rir.id_rubrica = ?";
		Object[] parametros = {id};
		List<ItemRubrica> result = this.query(sql, parametros, new RowMapper<ItemRubrica>() {
			@Override
			public ItemRubrica mapRow(ResultSet rs, int rowNum) throws SQLException {
				int idEscala = rs.getInt("ir.id_escala");
				Escala escala = catalogos.getEscalas().get(idEscala);
				ItemRubrica itemRubrica = new ItemRubrica(
						rs.getInt("ir.id_item_rubrica"), 
						rs.getString("ir.descripcion_corta"), 
						rs.getString("ir.descripcion_larga"), escala);
				return itemRubrica;
			}
		});
		return result;
	}

	
}
