package tests_dominio;


import org.junit.Assert;
import org.junit.Test;
import dominio.*;


public class TestPersonajeNuevo {

	@Test
	public void testDistancia() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Personaje p2 = new Humano("Link",new Hechicero(),2);
		Assert.assertEquals(0, p1.distanciaCon(p2),0);
	}
	
	@Test
	public void testAliarYaTeniendoAlianza() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Personaje p2 = new Humano("Link",new Hechicero(),2);
		p1.crearAlianza("AndaPls");
		p2.crearAlianza("El 30 vuelve House of Cards");
		Assert.assertFalse(p1.aliar(p2));
	}
	
	@Test
	public void testAliarPorPrimeraVez() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.crearAlianza("AndaPls");
		Personaje p2 = new Humano("Link",new Hechicero(),2);
		Assert.assertTrue(p1.aliar(p2));
	}
	
	@Test
	public void testSalirAlianza() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.crearAlianza("AndaPls");
		Assert.assertNotNull(p1.getClan());
		p1.salirDeAlianza();
		Assert.assertNull(p1.getClan());
	}
	
	@Test
	public void testSerRobado() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		// No le hace nada porque al defensa es mayor al dano
		Assert.assertEquals(0, p1.serRobadoSalud(3));
		// 105 de vida + 15 de defensa = 130
		Assert.assertEquals(105, p1.serRobadoSalud(130));
		Assert.assertEquals(0, p1.getSalud());
	}
	
	@Test
	public void testSerDesenergizado() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		// No le hace nada porque al defensa es mayor al dano
		Assert.assertEquals(0, p1.serDesernegizado(3));
		// 105 de energia + 15 de defensa = 130
		Assert.assertEquals(105, p1.serDesernegizado(130));
		Assert.assertEquals(0, p1.getEnergia());
	}
	
	@Test
	public void testPuedoAtacar() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Assert.assertTrue(p1.puedeAtacar());
		p1.setEnergia(9);
		Assert.assertEquals(9, p1.getEnergia());
		Assert.assertFalse(p1.puedeAtacar());
	}
	
	@Test
	public void testAtacarGolpeCritico() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Personaje p2 = new Humano("Link",new Hechicero(),2);
		p1.setDestreza(1000);
		Assert.assertEquals(1000, p1.getDestreza());
		//Me aseguro golpe critico, 12 porque 22.5 truncado 
		// es 22 y la defensa de p2 es 10
		Assert.assertEquals(12, p1.atacar(p2));
	}
	
	@Test
	public void testRestablecerSalud() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setSalud(3);
		Assert.assertEquals(3, p1.getSalud());
		p1.restablecerSalud();
		Assert.assertEquals(105, p1.getSalud());
	}
	
	@Test
	public void testRestablecerEnergia() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setEnergia(3);
		Assert.assertEquals(3, p1.getEnergia());
		p1.restablecerEnergia();
		Assert.assertEquals(105, p1.getEnergia());
	}
	
	@Test
	public void testSerAtacado() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Assert.assertEquals(0, p1.serAtacado(3));
		p1.getCasta().aumentarEvitarDaño(8);
		// Le aumento evitardano y vuelvo a probar con un dano 
		// mucho mayor a la defensa y asi me devuelve 0
		// porque no entra al if
		Assert.assertEquals(0, p1.serAtacado(900));
	}
	
	@Test
	public void testSerEnergizado() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setEnergia(8);
		Assert.assertEquals(8, p1.getEnergia());
		p1.serEnergizado(900);
		Assert.assertEquals(105, p1.getEnergia());
	}
	
	@Test
	public void testNombreRaza() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Assert.assertEquals("Humano", p1.getNombreRaza());
	}
	
	@Test
	public void testSetMagia() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setMagia(20);
		Assert.assertEquals(20, p1.getMagia());
	}
	
	@Test
	public void testSetCasta() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Casta c1 = new Hechicero();
		p1.setCasta(c1);
		Assert.assertEquals(c1, p1.getCasta());
	}
	
	@Test
	public void testSetExperiencia() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setExperiencia(10);
		Assert.assertEquals(10, p1.getExperiencia());
	}
	
	@Test
	public void testSetIdPersonaje() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setIdPersonaje(1);
		Assert.assertEquals(1, p1.getIdPersonaje());
	}
	
	@Test
	public void testSetSaludTope() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setSaludTope(100);
		Assert.assertEquals(100, p1.getSaludTope());
	}
	
	@Test
	public void testSetEnergiaTope() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.setEnergiaTope(100);
		Assert.assertEquals(100, p1.getEnergiaTope());
	}
	
	@Test
	public void testGetIdPersonaje() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Assert.assertEquals(2, p1.getIdPersonaje());
	}

}
