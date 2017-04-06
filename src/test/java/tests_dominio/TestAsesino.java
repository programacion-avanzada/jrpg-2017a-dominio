package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;

public class TestAsesino {

	@Test
	public void testRobar(){ }
	
	@Test
	public void testCritico(){
		Humano h = new Humano("Nicolas",new Asesino(),1);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2);
		
		Assert.assertEquals(105, h2.getSalud());
		if	(h.habilidadCasta1(h2))
			Assert.assertTrue(93==h2.getSalud());
		else
			Assert.assertEquals(105, h2.getSalud());
	}
	
	@Test
	public void testProbEvasion(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		
		Assert.assertTrue(0.3==h.getCasta().getProbabilidadEvitarDaño());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5==h.getCasta().getProbabilidadEvitarDaño());
	}
}
