package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 10);
		Assert.assertTrue(o2.getDestreza() == 10);
		Assert.assertTrue(o2.getInteligencia() == 15);

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);
	}

	@Test
	public void testDistanciaCon() {
		Orco o1 = new Orco("Maxi", new Guerrero(), 1);
		Orco o2 = new Orco("Nico", new Guerrero(), 1);

		Assert.assertTrue(o2.distanciaCon(o1) == 0);
	}

	@Test
	public void testElAliadoYaTieneUnClan() {
		Orco o1 = new Orco("Maxi", new Guerrero(), 1);
		Orco o2 = new Orco("Nico", new Guerrero(), 1);
		Orco o3 = new Orco("Otro", new Guerrero(), 1);

		Assert.assertTrue(o2.aliar(o3) == true);
		Assert.assertTrue(o1.aliar(o2) == false);
	}

	@Test
	public void testManipularAlianza() {
		Orco o1 = new Orco("Maxi", new Guerrero(), 1);
		Orco o2 = new Orco("Nico", new Guerrero(), 1);
		Orco o3 = new Orco("Otro", new Guerrero(), 1);

    o1.crearAlianza("el clan");

		Assert.assertTrue("el clan" == o1.getClan().obtenerNombre());
    Assert.assertTrue(o1.getClan().getAliados().getFirst() == o1);

    o1.salirDeAlianza();
		Assert.assertTrue(o1.getClan() == null);
		o1.salirDeAlianza();
	}

	@Test
	public void testGettersYSetters() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		Guerrero g = new Guerrero();
		o.setNombre("Roberto");
		o.setNombreRaza("Enano");
		o.setCasta(g);
		o.setMagia(10);
		o.setNivel(10);
		o.setExperiencia(10);
		o.setIdPersonaje(10);
		o.setSaludTope(10);
		o.setEnergiaTope(10);
		Assert.assertTrue(o.getNombre() == "Roberto");
		Assert.assertTrue(o.getNombreRaza() == "Enano");
		Assert.assertTrue(o.getCasta() == g);
		Assert.assertTrue(o.getNivel() == 10);
		Assert.assertTrue(o.getExperiencia() == 10);
		Assert.assertTrue(o.getIdPersonaje() == 10);
		Assert.assertTrue(o.getSaludTope() == 10);
		Assert.assertTrue(o.getEnergiaTope() == 10);
		Assert.assertTrue(o.getHabilidadesCasta()[0] == "Ataque Doble");
		Assert.assertTrue(o.getHabilidadesRaza()[0] == "Golpe Defensa");
	}

	@Test
	public void testPuedeAtacar() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		Assert.assertTrue(o.puedeAtacar() == true);
		o.setEnergia(9);
		Assert.assertTrue(o.puedeAtacar() == false);
	}

	@Test
	public void testRestablecerEnergiaYSalud() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		o.setEnergia(9);
		o.setSalud(9);
		o.restablecerEnergia();
		o.restablecerSalud();
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getSalud() == 110);
	}

	@Test
	public void testTenerBuenaDefensa() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		o.setDefensa(100);
		Assert.assertTrue(o.serAtacado(99) == 0);
		Assert.assertTrue(o.serRobadoSalud(99) == 0);
		Assert.assertTrue(o.serDesernegizado(99) == 0);
	}

	@Test
	public void testSerRobadoSaludYMorir() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		o.setSalud(10);
		o.setDefensa(10);
		Assert.assertTrue(o.serRobadoSalud(100) == 10);
		Assert.assertTrue(o.getSalud() == 0);
	}

	@Test
	public void testSerDesenergizadoYMorir() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		o.setEnergia(10);
		o.setDefensa(10);
		Assert.assertTrue(o.serDesernegizado(100) == 10);
		Assert.assertTrue(o.getEnergia() == 0);
	}

	@Test
	public void serEnergizadoAlMaximo() {
		Orco o = new Orco("Maxi", new Hechicero(), 1);
		o.setEnergia(99);
		o.serEnergizado(10000);

		System.out.println("--------------------------------------------");
		System.out.println(o.serRobadoSalud(100));
		System.out.println(o.getSalud());
		System.out.println("--------------------------------------------");

		Assert.assertTrue(o.getEnergia() == 100);
	}
}
