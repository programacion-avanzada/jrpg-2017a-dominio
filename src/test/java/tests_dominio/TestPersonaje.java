package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import dominio.*;

public class TestPersonaje {

	private Orco o;
	private Orco o1;
	private Orco o2;
	private Orco o3;

	private ArrayList<Item> l;

	
	@Before
	public void initialize() {
		l = new ArrayList<Item>();
		o  = new Orco("Maxi", new Hechicero(), 1,l);
		o1 = new Orco("Maxi", new Guerrero(), 1,l);
		o2 = new Orco("Nico", new Guerrero(), 1,l);
		o3 = new Orco("Otro", new Guerrero(), 1,l);

		MyRandomStub mrs = new MyRandomStub(0.49, 2);
		o.setRandomGenerator(mrs);
		o1.setRandomGenerator(mrs);
		o2.setRandomGenerator(mrs);
		o3.setRandomGenerator(mrs);
	}

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1,l);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 25);
		Assert.assertTrue(h.getDestreza() == 20);
		Assert.assertTrue(h.getInteligencia() == 20);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2,l);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 20);
		Assert.assertTrue(h2.getDestreza() == 20);
		Assert.assertTrue(h2.getInteligencia() == 25);

		Humano h3 = new Humano("Hernan", new Asesino(), 3,l);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 20);
		Assert.assertTrue(h3.getDestreza() == 25);
		Assert.assertTrue(h3.getInteligencia() == 20);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1,l);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 25);
		Assert.assertTrue(e.getDestreza() == 20);
		Assert.assertTrue(e.getInteligencia() == 20);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2,l);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 20);
		Assert.assertTrue(e2.getDestreza() == 20);
		Assert.assertTrue(e2.getInteligencia() == 25);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3,l);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 20);
		Assert.assertTrue(e3.getDestreza() == 25);
		Assert.assertTrue(e3.getInteligencia() == 20);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1,l);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 25);
		Assert.assertTrue(o.getDestreza() == 20);
		Assert.assertTrue(o.getInteligencia() == 20);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2,l);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 20);
		Assert.assertTrue(o2.getDestreza() == 20);
		Assert.assertTrue(o2.getInteligencia() == 25);

		Orco o3 = new Orco("Hernan", new Asesino(), 3,l);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 20);
		Assert.assertTrue(o3.getDestreza() == 25);
		Assert.assertTrue(o3.getInteligencia() == 20);
	}

	@Test
	public void testDistanciaCon() {
		Assert.assertTrue(o2.distanciaCon(o1) == 0);
	}

	@Test
	public void testElAliadoYaTieneUnClan() {
		Assert.assertTrue(o2.aliar(o3) == true);
		Assert.assertTrue(o1.aliar(o2) == false);
	}

	@Test
	public void testManipularAlianza() {
    o1.crearAlianza("el clan");

		Assert.assertTrue("el clan" == o1.getClan().obtenerNombre());
    Assert.assertTrue(o1.getClan().getAliados().getFirst() == o1);

    o1.salirDeAlianza();
		Assert.assertTrue(o1.getClan() == null);
		o1.salirDeAlianza();
	}

	@Test
	public void testGettersYSetters() {
		o.setNombre("Roberto");
		o.setNombreRaza("Enano");
		o.setMagia(10);
		Assert.assertTrue(o.getNombre() == "Roberto");
		Assert.assertTrue(o.getNombreRaza() == "Enano");
		Assert.assertTrue(o.getCasta().getClass().getName() == "dominio.Hechicero");
		Assert.assertTrue(o.getNivel() == 1);
		Assert.assertTrue(o.getExperiencia() == 0);
		Assert.assertTrue(o.getIdPersonaje() == 1);
		Assert.assertTrue(o.getHabilidadesCasta()[0] == "Bola de Fuego");
		Assert.assertTrue(o.getHabilidadesRaza()[0] == "Golpe Defensa");
	}

	@Test
	public void testPuedeAtacar() {
		Assert.assertTrue(o.puedeAtacar() == true);
		o.usarHabilidad(91);
		Assert.assertTrue(o.puedeAtacar() == false);
	}

	@Test
	public void testRestablecerEnergiaYSalud() {
		o.usarHabilidad(91);
		o.serAtacado(50);
		Assert.assertTrue(o.getEnergia() == 9);
		Assert.assertTrue(o.getSalud() == 80);
		o.restablecerEnergia();
		o.restablecerSalud();
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getSalud() == 110);
	}

	@Test
	public void testTenerBuenaDefensa() {
		o.aumentarDefensa(100);
		Assert.assertTrue(o.serAtacado(99) == 0);
		Assert.assertTrue(o.serRobadoSalud(99) == 0);
		Assert.assertTrue(o.serDesenergizado(99) == 0);
	}

	@Test
	public void testSerRobadoSaludYMorir() {
		o.serAtacado(90);
		o.aumentarDefensa(-90);
		Assert.assertTrue(o.serRobadoSalud(100) == 40);
		Assert.assertTrue(o.getSalud() == 0);
	}

	@Test
	public void testSerDesenergizadoYMorir() {
		o.usarHabilidad(90);
		o.aumentarDefensa(-90);
		Assert.assertTrue(o.serDesenergizado(100) == 10);
		Assert.assertTrue(o.getEnergia() == 0);
	}

	@Test
	public void serEnergizadoAlMaximo() {
		o.usarHabilidad(1);
		o.serEnergizado(10000);
		Assert.assertTrue(o.getEnergia() == 100);
	}

	@Test
	public void testToDo() {
		o.despuesDeTurno();
	}
}
