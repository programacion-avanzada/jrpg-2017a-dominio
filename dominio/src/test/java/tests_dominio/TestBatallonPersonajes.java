package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class TestBatallonPersonajes {

	@Test
	public void test1vs3() {
		Alianza a1 = new Alianza("Demacia");
		Alianza a2 = new Alianza("Noxus");

		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Orco o = new Orco("Hernan", 100, 100, 70, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Elfo e = new Elfo("Lautaro", 100, 100, 70, 20, 30, new Hechicero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Orco g = new Orco("Leonel", 100, 100, 70, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);

		ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);

		h.guardarItem(ragnarok);

		h.setClan(a1);
		o.setClan(a2);
		o.aliar(e);
		o.aliar(g);

		BatallonPersonajes b1 = new BatallonPersonajes(h.armarBatallonPjs());
		BatallonPersonajes b2 = new BatallonPersonajes(o.armarBatallonPjs());

		//b1.batallarContraPersonajes(b2);

		Assert.assertTrue(b1.getEquipo().getFirst().getNombre() == h.getNombre());// NO tiene que ganar el
													// humano
		Assert.assertTrue(b2.getEquipo().getFirst().getNombre() == o.getNombre());// y tienen que sobrevivir
													// los 3
		


	}
}
