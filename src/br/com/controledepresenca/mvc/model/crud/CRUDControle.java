package br.com.controledepresenca.mvc.model.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;
import br.com.controledepresenca.mvc.model.persistent_object.POControle;
public class CRUDControle extends AbstractCRUD{

	private DataSource datasource;

	public CRUDControle(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public void insert(Object o) {

		try {
			if(o instanceof POControle) {
				POControle controle = (POControle)o;
				String sql = "INSERT INTO controle (id, data_entrada, data_saida, idParticipante, idPalestra) SELECT NULL, NOW(), NOW(), ?, ? FROM DUAL WHERE NOT EXISTS (SELECT idParticipante FROM controle WHERE idParticipante = ?)";
				PreparedStatement stm = this.datasource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stm.setInt(1, controle.getIdParticipante());
				stm.setInt(2, controle.getIdPalestra());
				stm.setInt(3, controle.getIdParticipante());
				int res = stm.executeUpdate();
				if(res != 0) {
					ResultSet rs = stm.getGeneratedKeys();
					if(rs.next()) {
						controle.setIdControle(rs.getInt(1));
					}
					rs.close();
				}
				stm.close();
			}else {
				throw new RuntimeException("Objeto Inválido");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao criar controle "+ex.getMessage());
		}
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		try {
			if (o instanceof POControle) {
				POControle incompleto = (POControle)o;
				String sql = "UPDATE controle SET data_saida = now() WHERE id = ?";
				PreparedStatement stm = this.datasource.getConnection().prepareStatement(sql);
				stm.setInt(1, incompleto.getIdControle());
				stm.executeUpdate();			
				stm.close();
				
			}else {
				throw new RuntimeException("Objeto Invalido");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar o controle "+ex.getMessage());
		}
	}

	@Override
	public List<AbstractPersistentObject> read(Object o) {

		try {
			if (o instanceof POControle) {
				POControle incompleto = (POControle)o;
				String sql = "SELECT * FROM controle WHERE idPalestra = ?";
				PreparedStatement stm = this.datasource.getConnection().prepareStatement(sql);
				stm.setInt(1, incompleto.getIdPalestra());
				ResultSet rs = stm.executeQuery();
				ArrayList<AbstractPersistentObject> result = new ArrayList<AbstractPersistentObject>();
				if(rs.next()) {
					POControle controle = new POControle();
					controle.setIdControle(rs.getInt("id"));
					controle.setData_entrada(rs.getString("data_entrada"));
					controle.setData_saida(rs.getString("data_saida"));
					controle.setIdParticipante(rs.getInt("idParticipante"));
					controle.setIdPalestra(rs.getInt("idPalestra"));
					result.add(controle);
				}
				stm.close();
				rs.close();
				return result;
			}else {
				throw new RuntimeException("Objeto Invalido");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar lista de controle"+ex.getMessage());
		}
		return null;
	}

	public int getcontrole(int o) {
		int result = 0;
		try {
			if (o > 0) {				
				String sql = "SELECT id FROM controle WHERE idParticipante = ?";
				PreparedStatement stm = this.datasource.getConnection().prepareStatement(sql);
				stm.setInt(1, o);
				ResultSet rs = stm.executeQuery();			
				if(rs.next()) {
					result = rs.getInt("id");
				}
				stm.close();
				rs.close();
				return result;
			}else {
				throw new RuntimeException("Participante não registrou entrada ");
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar controle "+ex.getMessage());
		}
		return result;
	}

}
