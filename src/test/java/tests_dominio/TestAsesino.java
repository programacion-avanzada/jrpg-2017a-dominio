package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Item;
import dominio.MyRandomStub;

public class TestAsesino {

	private ArrayList<Item> l;
	
	@Before
	public void initialize(){
		l = new ArrayList<Item>();
	}
	
	@Test
	public void testRobar(){ }

	@Test
	public void testCritico(){
		Humano h = new Humano("Nicolas",new Asesino(0.2, 0.3, 1.5),1,l);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2,l);

		Assert.assertEquals(105, h2.getSalud());
		if	(h.habilidadCasta1(h2))
			Assert.assertTrue(93==h2.getSalud());
		else
			Assert.assertEquals(105, h2.getSalud());
	}

	@Test
	public void testCriticoPorDefecto(){
		Humano h = new Humano("Nicolas",new Asesino(),1,l);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2,l);

		Assert.assertEquals(105, h2.getSalud());
		if	(h.habilidadCasta1(h2))
			Assert.assertTrue(93==h2.getSalud());
		else
			Assert.assertEquals(105, h2.getSalud());
	}

	@Test
	public void testCriticoSinEnergia() {
		Humano h = new Humano("Nicolas",new Asesino(0.2, 0.3, 1.5),1,l);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2,l);

		MyRandomStub mrs = new MyRandomStub(0.49, 2);
		h.setRandomGenerator(mrs);
		h2.setRandomGenerator(mrs);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(120);
		Assert.assertFalse(h.habilidadCasta1(h2));
		Assert.assertEquals(105, h2.getSalud());
	}

	@Test
	public void testCriticoSinEnergiaPorDefecto() {
		Humano h = new Humano("Nicolas",new Asesino(),1,l);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2,l);

		MyRandomStub mrs = new MyRandomStub(0.49, 2);
		h.setRandomGenerator(mrs);
		h2.setRandomGenerator(mrs);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(120);
		Assert.assertFalse(h.habilidadCasta1(h2));
		Assert.assertEquals(105, h2.getSalud());
	}

	@Test
	public void testProbEvasion(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,l);

		Assert.assertTrue(0.3==h.getCasta().getProbabilidadEvitarDano());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDano(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5==h.getCasta().getProbabilidadEvitarDano());
	}

	@Test
	public void testProbEvasionSinEnergia() {
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta2(null));
	}

	@Test
	public void testProbEvasionSinEnergiaPorDefecto() {
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(), 0, 1, 1,l);

		Assert.assertTrue(h.getEnergia() > 3);
		h.usarHabilidad(98);
		Assert.assertFalse(h.habilidadCasta2(null));
	}

}
