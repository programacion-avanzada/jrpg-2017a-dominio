package tests_dominio;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class TestPotenciarAtributosItems {

	@Test
	public void testBonificaciones() {

		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		ItemDeCabeza cascoDePlatino = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		ItemDePie botasDeExplorador = new ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
		Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);
		Humano h = new Humano("Nicolas", new Guerrero(), 1);

		Assert.assertTrue(h.getSaludTope() == 55);
		Assert.assertTrue(h.getEnergiaTope() == 55);

		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getAtaque() == 22);// fuerza*1.5
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getDefensa() == 10);// destreza*1
		Assert.assertTrue(h.getInteligencia() == 10);
		Assert.assertTrue(h.getMagia() == 15);// inteligencia*1.5

		h.equiparItem(excalibur);
		Assert.assertTrue(h.getAtaque() == 72);

		h.equiparItem(anilloSupremo);
		Assert.assertTrue(h.getDefensa() == 60);

		h.equiparItem(cotaDeMalla);
		Assert.assertTrue(h.getMagia() == 65);

		h.equiparItem(cascoDePlatino);
		Assert.assertTrue(h.getSaludTope() == 105);

		h.equiparItem(botasDeExplorador);
		Assert.assertTrue(h.getEnergiaTope() == 105);
	}

	@Test
	public void testAlDesequiparPerderBonificacion() {

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.getAtaque() == 22);
		h.equiparItem(ragnarok);
		Assert.assertTrue(h.getAtaque() == 72);
		h.desequiparItem(ragnarok);
		Assert.assertTrue(h.getAtaque() == 22);

	}

	@Test
	public void testNoEquipar3ItemsDeManos() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeManos anduril = new ItemDeManos(1, 10, "anduril", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.getItemsEquipados().isEmpty());
		h.equiparItem(ragnarok);
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().size() == 2);
		h.equiparItem(anduril);
		Assert.assertTrue(h.getItemsEquipados().size() == 2);

	}

	@Test
	public void testNoEquiparMasDe2ItemsDelMismoTipo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);

		ItemDeTorso cotaDeMalla = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		ItemDeCabeza cascoDePlatino = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		ItemDePie botasDeExplorador = new ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
		Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeEspinas = new ItemDeTorso(1, 10, "cotaDeEspinas", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		ItemDeCabeza cascoDeOro = new ItemDeCabeza(1, 10, "cascoDeOro", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		ItemDePie botasDeCorredor = new ItemDePie(1, 10, "botasDeCorredor", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
		Accesorio anilloDePoder = new Accesorio(1, 10, "anilloDePoder", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.getItemsEquipados().isEmpty());

		h.equiparItem(cotaDeMalla);
		Assert.assertTrue(h.getItemsEquipados().size() == 1);
		h.equiparItem(cotaDeEspinas);
		Assert.assertTrue(h.getItemsEquipados().size() == 1);

		h.equiparItem(cascoDePlatino);
		Assert.assertTrue(h.getItemsEquipados().size() == 2);
		h.equiparItem(cascoDeOro);
		Assert.assertTrue(h.getItemsEquipados().size() == 2);

		h.equiparItem(botasDeCorredor);
		Assert.assertTrue(h.getItemsEquipados().size() == 3);
		h.equiparItem(botasDeExplorador);
		Assert.assertTrue(h.getItemsEquipados().size() == 3);

		h.equiparItem(anilloDePoder);
		Assert.assertTrue(h.getItemsEquipados().size() == 4);
		h.equiparItem(anilloSupremo);
		Assert.assertTrue(h.getItemsEquipados().size() == 4);

	}

}
