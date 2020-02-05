package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Administrador;

public class testadministrador {
	
	Administrador a1 = new Administrador();
	Administrador a2 = new Administrador();
	
	@Test
	public void testcontraseńa() {
		a1.setContraseńa("hola");
		a2.setContraseńa("hola");
		assertEquals(a1.getContraseńa(), a2.getContraseńa());
	}
	@Test
	public void testusuario() {
		a1.setNombre("admin");
		a2.setNombre("admin");
		assertEquals(a1.getNombre(),a2.getNombre());
	}

}
