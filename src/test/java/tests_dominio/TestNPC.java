package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;
import dominio.Elfo;
import dominio.Asesino;

public class TestNPC {

	private NonPlayableCharacter npc;

	@Before
	public void initialize(){
		npc = new NonPlayableCharacter("Perro", 1, 1);

		MyRandomStub mrs = new MyRandomStub(0.49, 2);
		npc.setRandomGenerator(mrs);
	}

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertTrue(30 == npc2.otorgarExp());
	}

	@Test
	public void testCrearConDificultadUno() {
		Assert.assertTrue(20 == npc.getFuerza());
		Assert.assertTrue(40 == npc.getSalud());
		Assert.assertTrue(5 == npc.getDefensa());
	}

	@Test
	public void testGettersySetters() {
		Assert.assertTrue(20 == npc.getFuerza());

		npc.setNombre("nombre");
		Assert.assertTrue("nombre" == npc.getNombre());

		Assert.assertTrue(1 == npc.getNivel());

		npc.setDefensa(123);
		Assert.assertTrue(123 == npc.getDefensa());

		Assert.assertTrue(40 == npc.getSalud());

		npc.setAtaque(123);
		Assert.assertTrue(123 == npc.getAtaque());
	}

	@Test
	public void testAtacarNormal() {
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Otro", 2, 2);
		Elfo e = new Elfo("Elfo", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(20 == npc2.atacar(e));
	}

	@Test
	public void testAtacarPotenciado() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(0 == npc.atacar(e));
	}

	@Test
	public void testSerAtacadoConBuenaDefensa() {
		npc.setDefensa(200);
		Assert.assertTrue(npc.serAtacado(99) == 0);
	}

	@Test
	public void testSerDesenergizadoORobadoSalud() {
		Assert.assertTrue(npc.serDesenergizado(99) == 0);
		Assert.assertTrue(npc.serRobadoSalud(99) == 0);
	}
}
