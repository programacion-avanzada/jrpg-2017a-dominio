package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Item;
import dominio.ItemDeManos;
import dominio.ItemDeTorso;
import dominio.Orco;

public class Test_Asesino {

	@Test
	public void test_Robar()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla", "Manos", 0, 20, 0, 0, 0, 10, 10, 10);
		
		o.equiparItem(excalibur);
		o.guardarItem(cotaDeMalla);
		Assert.assertNotNull(o.getEquipado(0));
		Assert.assertNotNull(o.getMochila(0));
		h.habilidadCasta3(o);
		//Assert.assertNull(o.getEquipado(0));
		
		
	}
	
	/*@Test
	public void test_Critico()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertEquals(200, o.getSalud());
		h.habilidadCasta1(o);
		Assert.assertTrue(183==o.getSalud());
	}*/
	
	@Test
	public void test_ProbEvasion()
	{
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		
		Assert.assertTrue(0.3==h.getCasta().getProbabilidadEvitarDaño());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5==h.getCasta().getProbabilidadEvitarDaño());
	}
	
	@Test
	public void test_robarNoSupereCantMaxDeItemsGuardados(){
		Humano h = new Humano(100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
		
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
