package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestRequisitosItems {

	@Test
	public void testManipularMejoresItems() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 120, 0, 0, 0, 0, 20, 20, 20);
		ItemDeManos espadaComun = new ItemDeManos(1, 10, "espadaComun", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		Assert.assertTrue(h.getItemsEquipados().isEmpty());
		h.equiparItem(espadaComun);
		Assert.assertTrue(h.getItemsEquipados().size() == 1);
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().size() == 1);
		h.AsignarPuntosSkills(10, 10, 10);
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().size() == 2);
	}

	@Test
	public void testFuerzaInsuficiente() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 120, 0, 0, 0, 0, 20, 10, 10);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
	}

	@Test
	public void testInteligenciaInsuficiente() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 120, 0, 0, 0, 0, 10, 20, 10);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
	}

	@Test
	public void testDestrezaInsuficiente() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 120, 0, 0, 0, 0, 10, 10, 20);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
		h.equiparItem(excalibur);
		Assert.assertTrue(h.getItemsEquipados().isEmpty());
	}
}
