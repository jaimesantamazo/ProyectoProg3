package test;
import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Administrador;
import gestionBD.Gestionadministrador;

public class testgestionadministrador {
	
	@Test
	public void testobteneradministrador() {
		Administrador admin1 = new Administrador();
		Gestionadministrador gestionadministracion = new Gestionadministrador();
		Administrador admin = gestionadministracion.obteneradministrador(admin1);
	}

}
