package test;
import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Usuario;
import gestionBD.Gestionusuarioduplicado;

public class testgestionusuario2 {

	@Test
	public void test() {
		Usuario usuario = new Usuario();
		Gestionusuarioduplicado gestionusuarioduplicado = new Gestionusuarioduplicado();
		Usuario usuario1 = gestionusuarioduplicado.obtenerusuarioduplicado(usuario);
	}

}
