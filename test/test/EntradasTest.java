package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Entradas;

public class testentradas {
	
	Entradas e1 = new Entradas();
	Entradas e2 = new Entradas();

	@Test
	public void testcodigo() {
		e1.setCodigo("1234");
		e2.setCodigo("1234");
		assertEquals(e1.getCodigo(), e2.getCodigo());
	}
	@Test
	public void testprecio() {
		e1.setPrecio(30);
		e2.setPrecio(30);
		assertEquals(e1.getPrecio(),e2.getPrecio());
	}

}
