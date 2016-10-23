package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;


public class Test_Guerrero {
	
	@Test
	public void test_dobleGolpe()
	{
	Humano h = new Humano(100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
	Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);

	Assert.assertTrue(e.getSalud()==100);
	h.habilidadCasta1(e);
	Assert.assertTrue(e.getSalud()==70);
	}
	
	@Test
	public void test_autoDefensa()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(h.getDefensa()==20);
		h.habilidadCasta2(null);
		Assert.assertTrue(h.getDefensa()==50);

	}
	
	@Test
	public void test_ignoraDefensa()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 3, 1);
		
		Assert.assertTrue(e.getSalud()==100);
		h.habilidadCasta3(e);
		Assert.assertTrue(e.getSalud()==75);
	}
	
	
}
