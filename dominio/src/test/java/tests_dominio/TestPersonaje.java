package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class test_Personaje {

	
	@Test
	public void test_Humano(){
	
		
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getSalud()==55);
		Assert.assertTrue(h.getEnergia()==55);
		Assert.assertTrue(h.getFuerza()==15);
		Assert.assertTrue(h.getDestreza()==10);
		Assert.assertTrue(h.getInteligencia()==10);
		
		Humano h2 = new Humano("Lautaro",new Hechicero(),2);
		Assert.assertTrue(h2.getSalud()==55);
		Assert.assertTrue(h2.getEnergia()==55);
		Assert.assertTrue(h2.getFuerza()==10);
		Assert.assertTrue(h2.getDestreza()==10);
		Assert.assertTrue(h2.getInteligencia()==15);
		
		Humano h3 = new Humano("Hernan",new Asesino(),3);
		Assert.assertTrue(h3.getSalud()==55);
		Assert.assertTrue(h3.getEnergia()==55);
		Assert.assertTrue(h3.getFuerza()==10);
		Assert.assertTrue(h3.getDestreza()==15);
		Assert.assertTrue(h3.getInteligencia()==10);
	}
	
	
	@Test
	public void test_Elfo(){
		Elfo e = new Elfo("Nicolas",new Guerrero(),1);
		Assert.assertTrue(e.getSalud()==50);
		Assert.assertTrue(e.getEnergia()==60);
		Assert.assertTrue(e.getFuerza()==15);
		Assert.assertTrue(e.getDestreza()==10);
		Assert.assertTrue(e.getInteligencia()==10);
		
		Elfo e2 = new Elfo("Lautaro",new Hechicero(),2);
		Assert.assertTrue(e2.getSalud()==50);
		Assert.assertTrue(e2.getEnergia()==60);
		Assert.assertTrue(e2.getFuerza()==10);
		Assert.assertTrue(e2.getDestreza()==10);
		Assert.assertTrue(e2.getInteligencia()==15);
		
		Elfo e3 = new Elfo("Hernan",new Asesino(),3);
		Assert.assertTrue(e3.getSalud()==50);
		Assert.assertTrue(e3.getEnergia()==60);
		Assert.assertTrue(e3.getFuerza()==10);
		Assert.assertTrue(e3.getDestreza()==15);
		Assert.assertTrue(e3.getInteligencia()==10);
	}
	
	@Test
	public void test_Orco(){
		Orco o = new Orco("Nicolas",new Guerrero(),1);
		Assert.assertTrue(o.getSalud()==60);
		Assert.assertTrue(o.getEnergia()==50);
		Assert.assertTrue(o.getFuerza()==15);
		Assert.assertTrue(o.getDestreza()==10);
		Assert.assertTrue(o.getInteligencia()==10);
		
		Orco o2 = new Orco("Lautaro",new Hechicero(),2);
		Assert.assertTrue(o2.getSalud()==60);
		Assert.assertTrue(o2.getEnergia()==50);
		Assert.assertTrue(o2.getFuerza()==10);
		Assert.assertTrue(o2.getDestreza()==10);
		Assert.assertTrue(o2.getInteligencia()==15);
		
		
		Orco o3 = new Orco("Hernan",new Asesino(),3);
		Assert.assertTrue(o3.getSalud()==60);
		Assert.assertTrue(o3.getEnergia()==50);
		Assert.assertTrue(o3.getFuerza()==10);
		Assert.assertTrue(o3.getDestreza()==15);
		Assert.assertTrue(o3.getInteligencia()==10);
	}
}
