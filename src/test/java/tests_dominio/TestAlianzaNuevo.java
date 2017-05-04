package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Personaje;

public class TestAlianzaNuevo {

	@Test
	public void testSetAliados() {
		LinkedList<Personaje> aliados = new LinkedList<Personaje>();
		Personaje p1 = new Humano("Ben Affleck",new Asesino(),2);
		Personaje p2 = new Humano("Link",new Hechicero(),2);
		aliados.add(p1);
		aliados.add(p2);
		Alianza ali = new Alianza("Los Isotopos");
		ali.setAliados(aliados);
		Assert.assertEquals(aliados, ali.getAliados());
	}
	
	@Test
	public void testGetNombre() {
		Alianza ali = new Alianza("Los Isotopos");
		Assert.assertEquals("Los Isotopos", ali.obtenerNombre());
	}

}
