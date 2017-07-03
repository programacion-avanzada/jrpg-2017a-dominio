package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.Item;

public class TestElfo {

	private ArrayList<Item> l;
	
	@Before
	public void initialize(){
		l = new ArrayList<Item>();
	}
	
	@Test
	public void testGolpeLevel() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, l);

		Assert.assertTrue(h.getSalud() == 100);
		if (e.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertTrue(h.getSalud() == 100);
	}

	@Test
	public void testGolpeLevelSinEnergia() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, l);

		h.usarHabilidad(98);
		e.habilidadRaza1(h);
		Assert.assertTrue(h.getEnergia() == 2);
	}

	@Test
	public void testAtaqueBosque() {
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, l);

		Assert.assertTrue(h.getSalud() == 100);
		if (e.habilidadRaza2(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertTrue(h.getSalud() == 100);
	}

	@Test
	public void testAtaqueBosqueSinEnergia() {
		Elfo e = new Elfo("Elfo", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);
		Humano h = new Humano("Humano", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, l);

		h.usarHabilidad(98);
		e.habilidadRaza2(h);
		Assert.assertTrue(h.getEnergia() == 2);
	}
}
