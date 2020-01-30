package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clasesbasicas.Entradas;

public class Gestionentradas {
	public Entradas obtenerentradas(Entradas entra) {
		Entradas entradas = null;
		
		Conexion conexion2 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from entradas where codigo = ?";
			pst = cn2.prepareStatement(sql);
			pst.setString(1, entra.getCodigo());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				entradas = new Entradas(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener usuario");
		}
		return entradas;
	}

}
