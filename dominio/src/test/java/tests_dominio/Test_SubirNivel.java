package tests_dominio;

import org.junit.Assert;
import org.junit.Test;


import dominio.*;

public class Test_SubirNivel {

	@Test
	public void test_SubirdeNivel()
	{
		Personaje.cargar_tabla_nivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getNivel()==1);
		h.ganarExperiencia(50);
		Assert.assertTrue(h.getNivel()==2);
	}
	
	@Test
	public void test_Nivel100(){
		Personaje.cargar_tabla_nivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		h.ganarExperiencia(300000);
		Assert.assertTrue(h.getNivel()==100);
		h.subirNivel();
		Assert.assertTrue(h.getNivel()==100);

	}
	
	@Test
	public void test_GanarMuchaExp(){
		Personaje.cargar_tabla_nivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertTrue(h.getNivel()==1);
		h.ganarExperiencia(150);
		Assert.assertTrue(h.getNivel()==3);
	}
	
	
}
