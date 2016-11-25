package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestItem {

	@Test
	public void testEquiparItem_desequiparItem() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.equiparItem(excalibur));
		Assert.assertNotNull(h.getEquipado(0));
		Assert.assertTrue(h.desequiparItem(excalibur));
		Assert.assertNull(h.getEquipado(0));
	}

	@Test
	public void testEquiparMaximo() {
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		ItemDeCabeza cascoDePlatino = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		ItemDePie botasDeExplorador = new ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
		Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);

		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		Assert.assertTrue(h.getSalud() == 100);
		Assert.assertTrue(h.getEnergia() == 100);
		Assert.assertTrue(h.getAtaque() == 37);
		Assert.assertTrue(h.getDefensa() == 20);
		Assert.assertTrue(h.getMagia() == 45);

		h.equiparItem(excalibur);
		h.equiparItem(ragnarok);
		h.equiparItem(cotaDeMalla);
		h.equiparItem(cascoDePlatino);
		h.equiparItem(botasDeExplorador);
		h.equiparItem(anilloSupremo);

		Assert.assertTrue(h.getSaludTope() == 150);
		Assert.assertTrue(h.getEnergiaTope() == 150);
		Assert.assertTrue(h.getAtaque() == 137);
		Assert.assertTrue(h.getDefensa() == 70);
		Assert.assertTrue(h.getMagia() == 95);

		Assert.assertTrue(h.getItemsEquipados().size() == 6);
		Assert.assertFalse(h.equiparItem(cascoDePlatino));

		Assert.assertTrue(h.desequiparItem(excalibur));
		Assert.assertTrue(h.desequiparItem(ragnarok));
		Assert.assertTrue(h.desequiparItem(cotaDeMalla));
		Assert.assertTrue(h.desequiparItem(cascoDePlatino));
		Assert.assertTrue(h.desequiparItem(botasDeExplorador));
		Assert.assertTrue(h.desequiparItem(anilloSupremo));
		Assert.assertTrue(h.getItemsEquipados().size() == 0);

		Assert.assertTrue(h.getSalud() == 100);
		Assert.assertTrue(h.getEnergia() == 100);
		Assert.assertTrue(h.getAtaque() == 37);
		Assert.assertTrue(h.getDefensa() == 20);
		Assert.assertTrue(h.getMagia() == 45);
	}

	@Test
	public void testGuardarEnMochila() {
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);

		Assert.assertTrue(h.getItemsGuardados().size() == 20);
		Assert.assertFalse(h.guardarItem(excalibur));

		h.dropearItemMochila(excalibur);
		h.dropearItemMochila(excalibur);
		h.dropearItemMochila(excalibur);
		h.dropearItemMochila(excalibur);
		h.dropearItemMochila(excalibur);

		Assert.assertTrue(h.getItemsGuardados().size() == 15);
	}

	@Test
	public void testEquipoDeItemsDelMismoTipo() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		ItemDeTorso cotaDeMalla = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeEscamas = new ItemDeTorso(1, 10, "cotaDeEscamas", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);

		h.equiparItem(cotaDeMalla);
		h.equiparItem(cotaDeEscamas);

		Assert.assertEquals(1, h.getItemsEquipados().size());
	}
}
