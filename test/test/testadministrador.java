package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Administrador;

public class testadministrador {
	
	Administrador a1 = new Administrador();
	Administrador a2 = new Administrador();
	
	@Test
	public void testcontraseña() {
		a1.setContraseña("hola");
		a2.setContraseña("hola");
		assertEquals(a1.getContraseña(), a2.getContraseña());
	}
	@Test
	public void testusuario() {
		a1.setNombre("admin");
		a2.setNombre("admin");
		assertEquals(a1.getNombre(),a2.getNombre());
	}

}
