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

		h.setProbabilidadEvitarDano(0.5);
		Assert.assertTrue(0.5 == h.getProbabilidadEvitarDano());

		h.setDanoCritico(0.5);
		Assert.assertTrue(0.5 == h.getDanoCritico());

		Assert.assertTrue("Hechicero" == h.getNombreCasta());
		Assert.assertTrue("Bola de Fuego" == h.getHabilidadesCasta()[0]);
	}

}
