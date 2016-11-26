package testsServidor;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;
import servidor.Conector;
import servidor.Servidor;

public class TestConector {

	@Test
	public void testConexionConLaDB() {
		new Servidor();
		Servidor.main(null);

		Conector conector = new Conector();
		conector.connect();

		// Pasado este punto la conexión con la base de datos resultó exitosa

		Assert.assertEquals(1, 1);
	}

	@Test
	public void testRegistrarUsuario() {
		new Servidor();
		Servidor.main(null);

		Conector conector = new Conector();
		conector.connect();

		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setUsername("UserTest");
		pu.setPassword("test");

		conector.registrarUsuario(pu);

		pu = conector.getUsuario("UserTest");

		Assert.assertEquals("UserTest", pu.getUsername());
	}

	@Test
	public void testRegistrarPersonaje() {
		new Servidor();
		Servidor.main(null);

		Conector conector = new Conector();
		conector.connect();

		PaquetePersonaje pp = new PaquetePersonaje();
		pp.setCasta("Humano");
		pp.setDestreza(1);
		pp.setEnergiaTope(1);
		pp.setExperiencia(1);
		pp.setFuerza(1);
		pp.setInteligencia(1);
		pp.setNivel(1);
		pp.setNombre("PjTest");
		pp.setRaza("Asesino");
		pp.setSaludTope(1);

		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setUsername("UserTest");
		pu.setPassword("test");

		conector.registrarUsuario(pu);
		conector.registrarPersonaje(pp, pu);

		pp = conector.getPersonaje(pu);

		Assert.assertEquals("PjTest", pp.getNombre());
	}

	@Test
	public void testLoginUsuario() {
		new Servidor();
		Servidor.main(null);

		Conector conector = new Conector();
		conector.connect();

		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setUsername("UserTest");
		pu.setPassword("test");

		conector.registrarUsuario(pu);

		boolean resultadoLogin = conector.loguearUsuario(pu);

		Assert.assertEquals(true, resultadoLogin);
	}

	@Test
	public void testLoginUsuarioFallido() {
		new Servidor();
		Servidor.main(null);

		Conector conector = new Conector();
		conector.connect();

		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setUsername("userInventado");
		pu.setPassword("test");

		boolean resultadoLogin = conector.loguearUsuario(pu);

		Assert.assertEquals(false, resultadoLogin);
	}

}
