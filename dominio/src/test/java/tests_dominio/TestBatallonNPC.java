package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class TestBatallonNPC {

	@Test
	public void testBatallaPjvsNPC(){
	
		Personaje.cargarTablaNivel();
		
		Item[] item = new Item[3];
		item[0]= new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		item[1] = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		item[2] = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		BatallonNPC b2= new BatallonNPC("Lobo",1,item,2);
		BatallonPersonajes b1= new BatallonPersonajes(h.armarBatallonPjs());
		b1.batallarContraNPCs(b2);
		
		
	}
}
