package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clasesbasicas.Usuario;

public class Gestionusuarioduplicado {
	public Usuario obtenerusuarioduplicado(Usuario usu1) {
		Usuario usuario1 = null;
		
		Conexion conexion2 = new Conexion();
		PreparedStatement pst1 = null;
		ResultSet rs1 = null;
		
		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from usuario where username = ?";
			pst1 = cn2.prepareStatement(sql);
			pst1.setString(1, usu1.getUsername());
			rs1 = pst1.executeQuery();
			
			while(rs1.next()) {
				usuario1 = new Usuario(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener usuario");
		}
		return usuario1;
	}

}
