package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestHechicero {

	@Test
	public void testCurar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		e.setSalud(65);
		Assert.assertTrue(e.getSalud() == 65);
		h.habilidadCasta2(e);
		Assert.assertTrue(e.getSalud() > 65);

	}

	@Test
	public void testBolaDeFuego() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta1(e))
			Assert.assertTrue(e.getSalud() < 100);
		else
			Assert.assertTrue(e.getSalud() == 100);

	}

	@Test
	public void testRobarEnergia_y_Salud() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		h.setSalud(50);
		h.setEnergia(50);
		if (h.habilidadCasta3(e)) {
			Assert.assertTrue(e.getSalud() < 100);
			Assert.assertTrue(h.getEnergia() > 50);
			Assert.assertTrue(h.getSalud() > 50);
		} else {
			Assert.assertTrue(h.getSalud() == 50);
			Assert.assertTrue(h.getEnergia() < 50);
			Assert.assertTrue(e.getSalud() == 100);
		}

	}
}
