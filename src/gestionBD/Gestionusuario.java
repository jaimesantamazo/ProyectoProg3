package gestionBD;
import java.sql.Connection;
import java.sql.ResultSet;

import clasesbasicas.Usuario;

import java.sql.PreparedStatement;


public class Gestionusuario {
	
	public Usuario obtenerusuario(Usuario usu) {
		Usuario usuario = null;
		
		Conexion conexion2 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Connection cn2 = conexion2.conectar();
			String sql = "select * from usuario where username = ? and contraseña = ?";
			pst = cn2.prepareStatement(sql);
			pst.setString(1, usu.getUsername());
			pst.setString(2, usu.getContraseña());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener usuario");
		}
		return usuario;
	}

}
