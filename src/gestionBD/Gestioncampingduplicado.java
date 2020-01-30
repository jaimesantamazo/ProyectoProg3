package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clasesbasicas.Camping;

public class Gestioncampingduplicado {
	public Camping obtenercampingduplicado(Camping camp) {
		Camping camping1 = null;
		
		Conexion conexion2 = new Conexion();
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;
		
		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from camping where codigo = ?";
			pst1 = cn2.prepareStatement(sql);
			pst1.setString(1, camp.getCodigo());
			rs1 = pst1.executeQuery();
			
			while(rs1.next()) {
				camping1 = new Camping(rs1.getString(1), rs1.getString(2), rs1.getInt(3), rs1.getString(4), rs1.getString(5), rs1.getInt(6));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener usuario");
		}
		return camping1;
	}

}
