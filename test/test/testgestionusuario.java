package test;
import static org.junit.Assert.*;

import org.junit.Test;

import clasesbasicas.Usuario;
import gestionBD.Gestionusuario;

public class testgestionusuario {

	@Test
	public void testusuario() {
		Usuario usuario = new Usuario();
		Gestionusuario gestionusuario = new Gestionusuario();
		Usuario usuario1 = gestionusuario.obtenerusuario(usuario);
	}

}
