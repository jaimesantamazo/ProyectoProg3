package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Conciertos;

public class testconciertos {
	
	Conciertos cn1 = new Conciertos();
	Conciertos cn2 = new Conciertos();

	@Test
	public void testnombre() {
		cn1.setNombre("arenalsound");
		cn2.setNombre("arenalsound");
		assertEquals(cn1.getNombre(), cn2.getNombre());
	}
	@Test
	public void testfechafin() {
		cn1.setFecha_fin("2020/07/23");
		cn2.setFecha_fin("2020/07/23");
		assertEquals(cn1.getFecha_fin(),cn2.getFecha_fin());
	}

}
