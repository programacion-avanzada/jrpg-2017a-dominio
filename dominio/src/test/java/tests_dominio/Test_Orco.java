package tests_dominio;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;


public class Test_Orco {

	@Test
	public void test_superGolpe()
	{
		
	}
	
	@Test
	public void test_MordiscoDeVida()
	{
		Humano h = new Humano(100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco(100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(h.getSalud()==100);
		o.setSalud(50);
		o.habilidadRaza2(h);
		Assert.assertTrue(h.getSalud()==40);
		Assert.assertTrue(o.getSalud()==100);

		
	}
	
}
