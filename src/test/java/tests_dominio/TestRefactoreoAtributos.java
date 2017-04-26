package tests_dominio;

import dominio.*;

import org.junit.Assert;
import org.junit.Test;

public class TestRefactoreoAtributos {

	@Test
	public void testDestrezaAsesino() {
		Personaje p = new Humano("Ben Affleck", new Asesino(), 1);
		System.out.println(p.getDestreza());
		Assert.assertEquals(15, p.getDestreza());
	}
	
	@Test
	public void testFuerzaGuerrero() {
		Personaje p = new Humano("Ben Affleck", new Guerrero(), 1);
		System.out.println(p.getFuerza());
		Assert.assertEquals(15, p.getFuerza());
	}
	
	@Test
	public void testInteligenciaHechicero() {
		Personaje p = new Humano("Ben Affleck", new Hechicero(), 1);
		System.out.println(p.getInteligencia());
		Assert.assertEquals(15, p.getInteligencia());
	}

}
