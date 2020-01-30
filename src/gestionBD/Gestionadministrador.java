package gestionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clasesbasicas.Administrador;

public class Gestionadministrador {
	public Administrador obteneradministrador(Administrador admin) {
		Administrador administrador = null;
		
		Conexion conexion1 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Connection cn1 = conexion1.conectar();
			String sql = "select * from administrador where contraseña = ?";
			pst = cn1.prepareStatement(sql);
			pst.setString(1, admin.getContraseña());
			rs = pst.executeQuery();
			
			while(rs.next()) {
				administrador = new Administrador(rs.getString(1));
			}
			
		}catch (Exception e) {
			System.out.println("error en obtener administrador");
		}
		return administrador;
	}

}
