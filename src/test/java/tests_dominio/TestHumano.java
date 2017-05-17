package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getAtaque() == 37);
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque() > 37);
	}

	@Test
	public void testIncentivarSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertTrue(e.getAtaque() == 37);
		h.setEnergia(2);
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque() == 37);
	}

	@Test
	public void testGolpeFatal() {
		Humano h = new Humano("Humano", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Elfo", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		MyRandomStub mrs = new MyRandomStub(0.49, 2);
		h.setRandomGenerator(mrs);
		e.setRandomGenerator(mrs);

		Assert.assertTrue(h.getEnergia() == 100);
		Assert.assertTrue(e.getSalud() == 100);
		if (h.habilidadRaza2(e)) {
			Assert.assertTrue(e.getSalud() == 70);
			Assert.assertTrue(h.getEnergia() == 50);
		} else {
			Assert.assertTrue(h.getEnergia() == 90);
			Assert.assertTrue(e.getSalud() == 100);
		}
	}

	@Test
	public void testGolpeFatalSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		h.setEnergia(2);
		h.habilidadRaza2(e);
		Assert.assertTrue(h.getEnergia() == 0);
	}
}
