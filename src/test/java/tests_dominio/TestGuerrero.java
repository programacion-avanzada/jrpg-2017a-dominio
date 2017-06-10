package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;
import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;

public class TestGuerrero {

	private ArrayList<Item> l;
	
	@Before
	public void initialize(){
		l = new ArrayList<Item>();
	}
	
	@Test
	public void testDobleGolpe() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta1(e))
			Assert.assertTrue(e.getSalud() < 100);

		else
			Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testDobleGolpeSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta1(e));
		Assert.assertEquals(100, e.getSalud());

	}

	@Test
	public void testDobleGolpeSinEnergiaPorDefecto() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta1(e));
		Assert.assertEquals(100, e.getSalud());

	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);

		Assert.assertTrue(h.getDefensa() == 20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 65);
	}

	@Test
	public void testAutoDefensaPorDefecto() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(), 0, 1, 1, l);

		Assert.assertTrue(h.getDefensa() == 20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa() == 65);
	}


	@Test
	public void testAutoDefensaSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta2(e));
		Assert.assertEquals(100, e.getSalud());
	}

	@Test
	public void testAutoDefensaSinEnergiaPorDefecto() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta2(e));
		Assert.assertEquals(100, e.getSalud());
	}

	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta3(e))
			Assert.assertTrue(e.getSalud() < 100);
		else
			Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testIgnoraDefensaPorDefecto() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadCasta3(e))
			Assert.assertTrue(e.getSalud() < 100);
		else
			Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testIgnorarDefensaSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta3(e));
		Assert.assertEquals(100, e.getSalud());
	}

	@Test
	public void testIgnorarDefensaSinEnergiaPorDefecto() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(), 0, 1, 1, l);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1, l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta3(e));
		Assert.assertEquals(100, e.getSalud());
	}

}
