package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Item;
import dominio.Personaje;
import junit.framework.Assert;

public class Test_Nivel_y_Exp {

	@Test
	public void test_ganarExp()
	{
		Personaje.cargar_tabla_nivel();
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		h.ganarExperiencia(45);
		Assert.assertTrue(h.getExperiencia()==45);
	}
	
	@Test
	public void test_SubirNivel()
	{
		Personaje.cargar_tabla_nivel();
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
		h.ganarExperiencia(300);
		Assert.assertTrue(h.getNivel()==4);
		//System.out.println(h.getNivel());
		Assert.assertTrue(h.getExperiencia()==0);
		
	}
	
	@Test
	public void test_Level100()
	{
		Personaje.cargar_tabla_nivel();
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 99, 1);
		h.ganarExperiencia(10000);
		Assert.assertTrue(h.getNivel()==100);
	}
	
}
