package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Administrador;

public class testadministrador {
	
	Administrador a1 = new Administrador();
	Administrador a2 = new Administrador();
	
	@Test
	public void testcontrase�a() {
		a1.setContrase�a("hola");
		a2.setContrase�a("hola");
		assertEquals(a1.getContrase�a(), a2.getContrase�a());
	}
	@Test
	public void testusuario() {
		a1.setNombre("admin");
		a2.setNombre("admin");
		assertEquals(a1.getNombre(),a2.getNombre());
	}

}
