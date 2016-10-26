package tests_dominio;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;
import dominio.Orco;

public class Test_Daño {
/*
	@Test
	public void test_AtaqueComunYLaSaludNoBajeDe0() //Si da false es porque se dio un golpe critico
	{
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico",100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(o.getSalud()==100);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==75);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==50);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==25);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==0);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==0);
		h.atacar(o);
		Assert.assertTrue(o.getSalud()==0);
	}*/
	
	@Test
	public void test_losMuertosNoAtacan(){
		Humano h = new Humano("Nico",100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico",100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		
		h.atacar(o);
		h.atacar(o);
		h.atacar(o);
		h.atacar(o);
		
		o.atacar(h);
		Assert.assertEquals(100, h.getSalud());
	}
	
}