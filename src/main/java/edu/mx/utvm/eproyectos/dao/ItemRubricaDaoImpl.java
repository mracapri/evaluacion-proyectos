package edu.mx.utvm.eproyectos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.mx.utvm.eproyectos.bootstrap.Catalogos;
import edu.mx.utvm.eproyectos.model.Escala;
import edu.mx.utvm.eproyectos.model.ItemRubrica;

public class ItemRubricaDaoImpl extends JdbcTemplate implements ItemRubricaDao {

	@Autowired
	private Catalogos catalogos;
	
	@Override
	public void create(ItemRubrica newInstance) {
		String sql = "INSERT INTO item_rubrica ";
		sql = sql + "(id_item_rubrica, descripcion_corta, descripcion_larga, id_escala) VALUES(?,?,?,?)";		
		
		this.update(sql, new Object[]{
				newInstance.getIdItemRubrica(),
				newInstance.getDescripcionCorta(),
				newInstance.getDescripcionLarga(),
				newInstance.getEscala().getIdEscala()
		});		
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

}
