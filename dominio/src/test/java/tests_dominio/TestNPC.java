package tests_dominio;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestNPC {

	@Test
	public void testPelea() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, null, -1);
		Humano h = new Humano("Nico", 100, 100, 1000, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		
			Assert.assertTrue(npc.estaVivo());

	}

	@Test
	public void testDropearItem() {
		Item[] it = new Item[3];
		it[0] = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		it[1] = new ItemDeTorso(2, 10, "Cota de Malla", "Torso", 0, 20, 0, 0, 0, 10, 10, 10);
		it[2] = new ItemDeCabeza(3, 10, "Randuim Shield", "Manos", 0, 50, 0, 0, 0, 10, 10, 10);

		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, it, -1);
		Assert.assertNotNull(npc.dropearItemAleatorio());
	}

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, null, -1);
		Assert.assertTrue(30 == npc.otorgarExp());
	}

}
