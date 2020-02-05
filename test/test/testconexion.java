package test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestionBD.Conexion;

public class testconexion {
		
	private Connection conn = null;
	private Statement st = null;
	
	    @BeforeClass
	    public static void setUpClass() {
	    }
	    
	    @AfterClass
	    public static void tearDownClass() {
	    }
	    
	    @Before
	    public void setUp() {
	    }
	    
	    @After
	    public void tearDown() {
	    }

	@Test
	public void testconectar() {
		System.out.println("conectar la BD");
        Conexion instance = new Conexion();
        instance.conectar();
	}
	@Test
	public void testDesconectar() throws Exception {
	    System.out.println("desconectar");
	    Conexion instance = new Conexion();
	    instance.cerrarBD(conn, st);
	   }

}
