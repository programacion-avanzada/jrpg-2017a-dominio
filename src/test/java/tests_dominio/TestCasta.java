package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import dominio.Casta;
import dominio.Humano;
import dominio.Hechicero;

public class TestCasta {

	@Test
	public void testGettersYSetters(){
    Hechicero h = new Hechicero();

		h.setProbabilidadGolpeCritico(0.5);
		Assert.assertTrue(0.5 == h.getProbabilidadGolpeCritico());

		h.setProbabilidadEvitarDaño(0.5);
		Assert.assertTrue(0.5 == h.getProbabilidadEvitarDaño());

		h.setDañoCritico(0.5);
		Assert.assertTrue(0.5 == h.getDañoCritico());

		System.out.println("------------------------------------------------");
		System.out.println(h.getHabilidadesCasta()[0]);
		System.out.println("------------------------------------------------");

		Assert.assertTrue("Hechicero" == h.getNombreCasta());
		Assert.assertTrue("Bola de Fuego" == h.getHabilidadesCasta()[0]);
	}

}
