package tests_dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Item;
import dominio.Personaje;

public class TestNivelExp {

	private ArrayList<Item> l;
	
	@Before
	public void initialize(){
		l = new ArrayList<Item>();
	}
	
	@Test
	public void testGanarExp() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,l);
		h.ganarExperiencia(45);
		Assert.assertTrue(h.getExperiencia() == 45);
	}

	@Test
	public void testSubirNivel() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,l);
		h.ganarExperiencia(300);
		Assert.assertTrue(h.getNivel() == 4);
		Assert.assertTrue(h.getExperiencia() == 0);
	}

	@Test
	public void testLevel100() {
		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 99, 1,l);
		h.ganarExperiencia(10000);
		Assert.assertTrue(h.getNivel() == 100);
	}
}
