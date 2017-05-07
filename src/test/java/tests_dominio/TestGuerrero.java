package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;

public class TestGuerrero {

	@Test
	public void testDobleGolpe() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta1(e))
			Assert.assertTrue(e.getSalud() < 100);

		else
			Assert.assertTrue(e.getSalud() == 100);
		h.setEnergia(0);
		Assert.assertFalse(h.habilidadCasta1(e));
	}
	
	@Test
	public void testDobleGolpeFallido(){
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h.setEnergia(0);
		Assert.assertTrue(e.getSalud() == 100);
		h.habilidadCasta1(e);
		Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertTrue(h.getDefensa() == 20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 65);
		h.setEnergia(0);
		Assert.assertFalse(h.habilidadCasta2(h));
	}
	
	@Test
	public void testAutoDefensaFallido() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		h.setEnergia(0);
		Assert.assertTrue(h.getDefensa() == 20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 20);
	}

	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta3(e))
			Assert.assertTrue(e.getSalud() < 100);
		else
			Assert.assertTrue(e.getSalud() == 100);
		h.setEnergia(0);
		Assert.assertFalse(h.habilidadCasta3(e));
	}
	
	@Test
	public void testIgnoraDefensaFallido() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		h.setEnergia(0);
		Assert.assertTrue(e.getSalud() == 100);
		h.habilidadCasta3(e);
		Assert.assertTrue(e.getSalud() == 100);
	}
	
}
