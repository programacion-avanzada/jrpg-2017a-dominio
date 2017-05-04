package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.NonPlayableCharacter;
import dominio.Personaje;

public class TestNPCNuevo {

	@Test
	public void testNivelNPC1() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertEquals(5, npc.getDefensa());
		Assert.assertEquals(20, npc.getFuerza());
		Assert.assertEquals(40, npc.getSalud());
	}

	@Test
	public void testDañoMenorADef() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertEquals(0, npc.serAtacado(1));
	}
	
	@Test
	public void testGetFuerza() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertEquals(20, npc.getFuerza());
	}
	
	@Test
	public void testSetAtaque() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		npc.setAtaque(80);
		Assert.assertEquals(80, npc.getFuerza());
	}
	
	@Test
	public void testGetMagia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertEquals(0, npc.getMagia());
	}
	
	@Test
	public void testAtacar() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Pepe", 1, 1);
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		// Recordar que trunca porque es entero
		//NPC 20 - (5/2) = 18
		//P1 20 - 15 = 5
		Assert.assertEquals(18, npc.atacar(npc2));
		Assert.assertEquals(5, npc.atacar(p1));
	}
	
	@Test
	public void testSetSalud() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		npc.setSalud(80);
		Assert.assertEquals(80, npc.getSalud());
	}
	
	@Test
	public void testNivelNPCDefault() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 9);
		Assert.assertEquals(0, npc.getDefensa());
		Assert.assertEquals(0, npc.getFuerza());
		Assert.assertEquals(0, npc.getSalud());
	}
	
	

}
