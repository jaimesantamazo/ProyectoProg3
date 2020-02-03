package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Usuario;

public class testusuario {
	
	Usuario u1 = new Usuario("jaime", "jaime@hotmail.com", "jaime", "santamaria", "mazo", "2000/03/28", "jaime", "1");
	Usuario u2 = u1;
	Usuario u3 = new Usuario("jaime", "jaime@hotmail.com", "jaime", "santamaria", "mazo", "2000/03/28", "jaime", "0");

	@Test
	public void testuser() {
		assertEquals(u1, u2);
	}
	@Test
	public void testadmin() {
		assertFalse(u3.isadmin());
		assertTrue(u1.isadmin());
	}

}
