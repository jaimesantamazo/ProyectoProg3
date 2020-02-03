package gestionBD;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class Conexion {
	
	private Connection conn = null;
	private static Exception lastError = null; 
	
	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:database/bd_pagina");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
			e.printStackTrace();
		}
		return conn;
	}
	public static void cerrarBD( Connection conn, Statement st ) {
		try {
			if (st!=null) st.close();
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			lastError = e;
			e.printStackTrace();
		}
	}

}
