package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Personaje;

public class TestCastaNuevo {

	@Test
	public void testSetProbabilidadGolpeCritico() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.getCasta().setProbabilidadGolpeCritico(8);
		Assert.assertEquals(8, p1.getCasta().getProbabilidadGolpeCritico(),0);
	}
	
	@Test
	public void testSetDañoCritico() {
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		p1.getCasta().setDañoCritico(8);
		Assert.assertEquals(8, p1.getCasta().getDañoCritico(),0);
	}

}
