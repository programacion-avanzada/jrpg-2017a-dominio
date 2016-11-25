package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestSubirNivel {

	@Test
	public void testSubirdeNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getNivel() == 1);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getNivel() == 2);
	}

	@Test
	public void testNivel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		h.ganarExperiencia(300000);
		Assert.assertTrue(h.getNivel() == 100);
		h.subirNivel();
		Assert.assertTrue(h.getNivel() == 100);

	}

	@Test
	public void testGanarMuchaExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getNivel() == 1);
		h.ganarExperiencia(150);
		Assert.assertTrue(h.getNivel() == 3);
	}
}
