package tests_dominio;

import java.util.LinkedList;

import org.junit.Test;

import dominio.*;
import junit.framework.Assert;

public class Test_BatallonNPC {

	@Test
	public void test_BatallaPjvsNPC(){
	
		Personaje.cargar_tabla_nivel();
		
		Item[] i = new Item[3];
		i[0]= new ItemDeManos(1, 10, "ragnarok", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		i[1] = new ItemDeTorso(1, 10, "cotaDeMalla", "Torso", 0, 0, 50, 0, 0, 10, 10, 10);
		i[2] = new ItemDeCabeza(1, 10, "cascoDePlatino", "Cabeza", 0, 0, 0, 50, 0, 10, 10, 10);
		ItemDePie botasDeExplorador = new ItemDePie(1, 10, "botasDeExplorador", "Pies", 0, 0, 0, 0, 50, 10, 10, 10);
		Accesorio anilloSupremo = new Accesorio(1, 10, "anilloSupremo", "Accesorio", 0, 50, 0, 0, 0, 10, 10, 10);
		
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		h.guardarItem(i[0]);
		h.guardarItem(i[1]);
		System.out.println(h.listaItemsGuardados());
		System.out.println();
		
		BatallonNPC b2= new BatallonNPC("Lobo",100,i,3);
		System.out.println();
		
		h.guardarItem(b2.getEquipo().get(0).dropearItemAleatorio());
		h.guardarItem(b2.getEquipo().get(1).dropearItemAleatorio());
		h.guardarItem(b2.getEquipo().get(2).dropearItemAleatorio());
		//BatallonPersonajes b1= new BatallonPersonajes(h.armarBatallonPjs());
		
		//b1.batallarContraNPCs(b2);
		System.out.println(h.listaItemsGuardados());
		
	}
}
