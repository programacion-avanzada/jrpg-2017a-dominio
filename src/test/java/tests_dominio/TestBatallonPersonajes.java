package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestBatallonPersonajes {

	
	 @Test public void test_1vs1(){ Alianza a1 = new Alianza("Demacia");
	 Alianza a2 = new Alianza("Noxus");
	 
	 Humano h = new Humano("Nico",100, 100, 100, 20, 30, new Asesino(0.2, 0.3,
	 1.5), new LinkedList<Item>(), new LinkedList<Item>(), 0, 1, 1); Orco o =
	 new Orco("Hernan",100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new
	 LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1); ItemDeManos
	 excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0,
	 10, 10, 10); ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok",
	 "Manos", 50, 0, 0, 0, 0, 10, 10, 10); ItemDeTorso cotaDeMalla = new
	 ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
	 ItemDeCabeza cascoDePlatino = new ItemDeCabeza(1, 10, "cascoDePlatino",
	 "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10); ItemDePie botasDeExplorador = new
	 ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10,
	 10); Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo",
	 "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);
	 
	 h.setClan(a1); o.setClan(a2); Personaje.cargarTablaNivel();
	 h.guardarItem(excalibur); o.guardarItem(ragnarok);
	 
	 BatallonPersonajes b1= new BatallonPersonajes(h.armarBatallonPjs());
	 BatallonPersonajes b2= new BatallonPersonajes(o.armarBatallonPjs());
	 
	 b1.batallarContraPersonajes(b2);
	 Assert.assertTrue(h.getExperiencia()==40);//Tiene que ganar el humano; 
	 }
	 
	 @Test public void test_1vs2(){ 
	 Alianza a1 = new Alianza("Demacia");
	 Alianza a2 = new Alianza("Noxus");
	
	 Personaje.cargarTablaNivel(); Humano h = new Humano("Nico",100, 100,
	 100, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(), new
	 LinkedList<Item>(), 0, 1, 1); Orco o = new Orco("Hernan",100, 100, 15,
	 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new
	 LinkedList<Item>(), 0, 1, 1); Elfo e = new Elfo("Lautaro",100, 100, 15,
	 20, 30, new Hechicero(0.2, 0.3, 1.5), new LinkedList<Item>(),new
	 LinkedList<Item>(), 0, 1, 1);
	 
	 ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0,
	 0, 0, 0, 10, 10, 10); ItemDeManos excalibur = new ItemDeManos(1, 10,
	 "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
	 o.guardarItem(excalibur); e.guardarItem(excalibur);
	 h.guardarItem(ragnarok);

	 h.setClan(a1); o.setClan(a2); o.aliar(e);
	 
	 BatallonPersonajes b1= new BatallonPersonajes(h.armarBatallonPjs());
	 BatallonPersonajes b2= new BatallonPersonajes(o.armarBatallonPjs());
	 
	 b1.batallarContraPersonajes(b2);
	 
	 Assert.assertTrue(h.getExperiencia()==30);//Tiene que ganar el humano
	 Assert.assertTrue(h.getNivel()==2);
	 }
	 

	@Test
	public void test1vs3() {
		Alianza a1 = new Alianza("Demacia");
		Alianza a2 = new Alianza("Noxus");

		Personaje.cargarTablaNivel();
		Humano h = new Humano("Nico", 100, 100, 100, 20, 30, new Asesino(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1);
		Humano o = new Humano("Hernan", 100, 100, 70, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),
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

		b1.batallarContraPersonajes(b2);

		Assert.assertTrue(o.getExperiencia() == 13);// NO tiene que ganar el
													// humano
		Assert.assertTrue(e.getExperiencia() == 13);// y tienen que sobrevivir
													// los 3
		Assert.assertTrue(g.getExperiencia() == 13);
	}
}
