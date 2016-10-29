package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Item;
import dominio.ItemDeManos;
import dominio.ItemDeTorso;
import dominio.Orco;

public class TestAsesino {

	@Test
	public void testRobar(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico",200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla", "Manos", 0, 20, 0, 0, 0, 10, 10, 10);
		
		o.equiparItem(excalibur);
		o.guardarItem(cotaDeMalla);
		if(h.habilidadCasta3(o))
			Assert.assertTrue(h.getItemsGuardados().size()==1);
		else 
			Assert.assertTrue(h.getItemsGuardados().size()==0);
	}
	
	@Test
	public void testCritico(){
		Humano h = new Humano("Nicolas",new Asesino(),1);
		Humano h2 = new Humano("Lautaro",new Hechicero(),2);
		
		Assert.assertEquals(55, h2.getSalud());
		if	(h.habilidadCasta1(h2))
			Assert.assertTrue(43==h2.getSalud());
		else
			Assert.assertEquals(55, h2.getSalud());
	}
	
	@Test
	public void testProbEvasion(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico",200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(0.3==h.getCasta().getProbabilidadEvitarDaño());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5==h.getCasta().getProbabilidadEvitarDaño());
	}
	
	@Test
	public void testrobarNoSupereCantMaxDeItemsGuardados(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Nico",200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla", "Manos", 0, 20, 0, 0, 0, 10, 10, 10);
		
		o.equiparItem(excalibur);
		o.guardarItem(cotaDeMalla);
		
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		h.guardarItem(excalibur);
		
		Assert.assertTrue(h.getItemsGuardados().size() == 20);
		h.habilidadCasta3(o);
		Assert.assertTrue(h.getItemsGuardados().size() == 20);
	}
}
