package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.NonPlayableCharacter;
import dominio.Personaje;

public class TestHechieroNuevo {

	@Test
	public void testHabilidad3() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		Personaje p2 = new Humano("Batman",new Asesino(),2);
		p1.setEnergia(0);
		Assert.assertFalse(p1.habilidadCasta3(p2));
	}
	
	@Test
	public void testHabilidad2() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		Personaje p2 = new Humano("Batman",new Asesino(),2);
		p1.setEnergia(0);
		Assert.assertFalse(p1.habilidadCasta2(p2));
	}
	
	@Test
	public void testHabilidad1() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		Personaje p2 = new Humano("Batman",new Asesino(),2);
		p1.setEnergia(0);
		Assert.assertFalse(p1.habilidadCasta1(p2));
	}
	
	@Test
	public void testInstanceOfHorrible1() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		p1.setInteligencia(0);
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertFalse(p1.habilidadCasta1(npc));
	}
	
	@Test
	public void testInstanceOfHorrible2() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertFalse(p1.habilidadCasta2(npc));
	}
	
	@Test
	public void testInstanceOfHorrible3() {
		Personaje p1 = new Humano("Ben Affleck",new Hechicero(),2);
		NonPlayableCharacter npc = new NonPlayableCharacter("Pepe", 1, 1);
		Assert.assertFalse(p1.habilidadCasta3(npc));
	}

}
