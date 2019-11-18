package br.com.controledepresenca.mvc.model.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;

public class CRUDParticipante extends AbstractCRUD{

	private DataSource datasource;
	
	public CRUDParticipante(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AbstractPersistentObject> read(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getparticipante(int o) {
		int result = 0;
		try {
			if (o > 0) {				
				String sql = "SELECT idPalestra FROM participante WHERE codigo = ?";
				PreparedStatement stm = this.datasource.getConnection().prepareStatement(sql);
				stm.setInt(1, o);
				ResultSet rs = stm.executeQuery();			
				if(rs.next()) {
					result = rs.getInt("idpalestra");
				}else {
					throw new RuntimeException("Participante não existe");
				}
				stm.close();
				rs.close();
				return result;
			}else {
				throw new RuntimeException("Participante sem Palestra");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar Palestra "+ex.getMessage());
		}
		return result;
	}

}
