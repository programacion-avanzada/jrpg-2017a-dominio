package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_Batallon {

	@Test
	public void test_1vs1()
	{
	Alianza a1 = new Alianza("Demacia");
	Alianza a2 = new Alianza("Noxus");
	
	Humano h = new Humano(100, 100, 100, 20, 30, new Asesino(0.2, 0.3, 1.5),  new LinkedList<Item>(),  new LinkedList<Item>(), 0, 1, 1);
	Orco o = new Orco(100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),new LinkedList<Item>(), 0, 1, 1);
	ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
	ItemDeManos ragnarok = new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
	ItemDeTorso cotaDeMalla = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
	ItemDeCabeza cascoDePlatino = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
	ItemDePie botasDeExplorador = new ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
	Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);
	
	h.setClan(a1);
	o.setClan(a2);
	Personaje.cargar_tabla_nivel();
	h.guardarItem(excalibur);
	o.guardarItem(ragnarok);
	
	BatallonPersonajes b1= new BatallonPersonajes(h.armarBatallonPjs());
	BatallonPersonajes b2= new BatallonPersonajes(o.armarBatallonPjs());
	
	b1.batallarContraPersonajes(b2);
	System.out.println(h.listaItemsGuardados());
	
	
	}
}
