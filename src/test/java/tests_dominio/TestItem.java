package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Item;
import dominio.NonPlayableCharacter;
import dominio.Orco;

public class TestItem {

	@Test
	public void testCrearItem() {
		@SuppressWarnings("unused")
		Item item = new Item(100, "Chromatic Sword", "Los colores de esta espada son infinitos", 10, 10, 10, 10, 10, 10, 10, 10);
	}
	
	@Test
	public void testEquiparNPC() {
		Item item = new Item(100, "Espada Cromática", "Los colores de esta espada son infinitos", 10, 10, 10, 10, 10, 10, 10, 10);
		NonPlayableCharacter npc = new NonPlayableCharacter("Ezequiel", 1, 2);
		
		int fuerzaInicial = npc.getFuerza();
		int defensaInicial = npc.getDefensa();

		npc.equiparItem(item);
		Assert.assertEquals(fuerzaInicial + 10, npc.getFuerza());
		Assert.assertEquals(defensaInicial + 10, npc.getDefensa());
	}
	
	@Test
	public void testDesequiparNPC() {
		Item item = new Item(100, "Espada Cromática", "Los colores de esta espada son infinitos", 10, 10, 10, 10, 10, 10, 10, 10);
		NonPlayableCharacter npc = new NonPlayableCharacter("Ezequiel", 1, 2);
		
		npc.equiparItem(item);
		int fuerzaInicial = npc.getFuerza();
		int defensaInicial = npc.getDefensa();
		
		npc.eliminarItem(item);
		Assert.assertEquals(fuerzaInicial - 10, npc.getFuerza());
		Assert.assertEquals(defensaInicial - 10, npc.getDefensa());
	}
	
	@Test
	public void testEquiparPersonaje() {
		Item item = new Item(100, "Espada Cromática", "Los colores de esta espada son infinitos", 10, 10, 10, 10, 10, 10, 10, 10);
		Orco orco = new Orco("Hernan", new Guerrero(), 1);
		
		int fuerzaInicial = orco.getFuerza();
		int defensaInicial = orco.getDefensa();
		int energiaTopeInicial = orco.getEnergiaTope();
		int saludTopeInicial = orco.getSaludTope();
		int ataqueInicial = orco.getAtaque();
		int magiaInicial = orco.getMagia();
		int inteligenciaInicial = orco.getInteligencia();
		int destrezaInicial = orco.getDestreza();
		
		orco.equiparItem(item);
		Assert.assertEquals(fuerzaInicial + 10, orco.getFuerza());
		Assert.assertEquals(defensaInicial + 10, orco.getDefensa());
		Assert.assertEquals(energiaTopeInicial + 10, orco.getEnergiaTope());
		Assert.assertEquals(saludTopeInicial + 10, orco.getSaludTope());
		Assert.assertEquals(ataqueInicial + 10, orco.getAtaque());
		Assert.assertEquals(magiaInicial + 10, orco.getMagia());
		Assert.assertEquals(inteligenciaInicial + 10, orco.getInteligencia());
		Assert.assertEquals(destrezaInicial + 10, orco.getDestreza());
	}
	
	@Test
	public void testDesequiparPersonaje() {
		Item item = new Item(100, "Espada Cromática", "Los colores de esta espada son infinitos", 10, 10, 10, 10, 10, 10, 10, 10);
		Orco orco = new Orco("Hernan", new Guerrero(), 1);
		
		orco.equiparItem(item);
		int fuerzaInicial = orco.getFuerza();
		int defensaInicial = orco.getDefensa();
		int energiaTopeInicial = orco.getEnergiaTope();
		int saludTopeInicial = orco.getSaludTope();
		int ataqueInicial = orco.getAtaque();
		int magiaInicial = orco.getMagia();
		int inteligenciaInicial = orco.getInteligencia();
		int destrezaInicial = orco.getDestreza();
		
		orco.eliminarItem(item);
		Assert.assertEquals(fuerzaInicial - 10, orco.getFuerza());
		Assert.assertEquals(defensaInicial - 10, orco.getDefensa());
		Assert.assertEquals(energiaTopeInicial - 10, orco.getEnergiaTope());
		Assert.assertEquals(saludTopeInicial - 10, orco.getSaludTope());
		Assert.assertEquals(ataqueInicial - 10, orco.getAtaque());
		Assert.assertEquals(magiaInicial - 10, orco.getMagia());
		Assert.assertEquals(inteligenciaInicial - 10, orco.getInteligencia());
		Assert.assertEquals(destrezaInicial - 10, orco.getDestreza());
	}
}
