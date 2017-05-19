package tests_dominio;

import org.junit.Test;
import org.junit.Before;

import dominio.*;
import org.junit.Assert;

public class TestAtributos {

	private Humano h;

	@Before
	public void initialize() {
		h = new Humano("Nicolas", new Guerrero(), 1);
	}

	@Test
	public void testIncrementarFuerza() {
		Assert.assertTrue(h.getAtaque() == 22);
		h.asignarPuntosSkills(10, 0, 0);
		Assert.assertTrue(h.getAtaque() > 22);
	}

	@Test
	public void testIncrementarDestreza() {
		Assert.assertTrue(h.getDefensa() == 10);
		h.asignarPuntosSkills(0, 10, 0);
		Assert.assertTrue(h.getDefensa() > 10);
	}

	@Test
	public void testIncrementarInteligencia() {
		Assert.assertTrue(h.getMagia() == 15);
		h.asignarPuntosSkills(0, 0, 10);
		Assert.assertTrue(h.getMagia() > 15);
	}

	@Test
	public void testIncrementarMasDelMaximo() {
		int max = 201;

		Assert.assertTrue(h.getAtaque() == 22);
		Assert.assertTrue(h.getDefensa() == 10);
		Assert.assertTrue(h.getMagia() == 15);

		h.asignarPuntosSkills(max, max, max);
		Assert.assertTrue(h.getAtaque() == 22);
		Assert.assertTrue(h.getDefensa() == 10);
		Assert.assertTrue(h.getMagia() == 15);
	}
}
