package test;
import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import gestionBD.Conexion;

public class testconexion {

	@Test
	public void test() {
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
	}

}
