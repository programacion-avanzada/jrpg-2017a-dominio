package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.NonPlayableCharacter;
import dominio.Elfo;
import dominio.Asesino;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertTrue(30 == npc.otorgarExp());
	}

	@Test
	public void testCrearConDificultadUno() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Perro", 1, 1);
		Assert.assertTrue(20 == npc.getFuerza());
		Assert.assertTrue(40 == npc.getSalud());
		Assert.assertTrue(5 == npc.getDefensa());
	}

	@Test
	public void testGettersySetters() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Otro", 2, 2);

		npc.setFuerza(123);
		Assert.assertTrue(123 == npc.getFuerza());

		npc.setNombre("nombre");
		Assert.assertTrue("nombre" == npc.getNombre());

		npc.setNivel(123);
		Assert.assertTrue(123 == npc.getNivel());

		npc.setDefensa(123);
		Assert.assertTrue(123 == npc.getDefensa());

		npc.setSalud(123);
		Assert.assertTrue(123 == npc.getSalud());

		npc.setAtaque(123);
		Assert.assertTrue(123 == npc.getAtaque());
	}

	@Test
	public void testAtacar() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Otro", 2, 2);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertTrue(20 == npc.atacar(e));
	}

	@Test
	public void testSerAtacadoConBuenaDefensa() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Otro", 2, 2);
		npc.setDefensa(200);
		Assert.assertTrue(npc.serAtacado(99) == 0);
	}

	@Test
	public void testSerDesenergizadoORobadoSalud() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Otro", 2, 2);
		Assert.assertTrue(npc.serDesenergizado(99) == 0);
		Assert.assertTrue(npc.serRobadoSalud(99) == 0);
	}
}
