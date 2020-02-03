package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Camping;

public class testcamping {
	
	Camping c1 = new Camping();
	Camping c2 = new Camping();

	@Test
	public void testaforo() {
		c1.setCantidad(100);
		c2.setCantidad(100);
		assertEquals(c1.getAforo(), c2.getAforo());
	}
	@Test
	public void testfechaini() {
		c1.setFecha_ini("2020/07/07");
		c2.setFecha_ini("2020/07/07");
		assertEquals(c1.getFecha_ini(), c2.getFecha_ini());
	}

}
