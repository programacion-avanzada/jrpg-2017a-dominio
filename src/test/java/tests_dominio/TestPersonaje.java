package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
	}

	@Test
	public void testElfo() {
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);
	}

	@Test
	public void testOrco() {
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 10);
		Assert.assertTrue(o2.getDestreza() == 10);
		Assert.assertTrue(o2.getInteligencia() == 15);

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);
	}
	@Test
	public void testCasta(){
		Orco o = new Orco("Hernan", new Asesino(), 3);
		o.getCasta().setDanoCritico(2.5);
		Assert.assertEquals(o.getCasta().getDanoCritico(), 2.5,0.0001);
		o.getCasta().setProbabilidadEvitarDano(0.5);
		Assert.assertEquals(o.getCasta().getProbabilidadEvitarDano(),0.5,0.0001);
		o.getCasta().setProbabilidadGolpeCritico(0.7);
		Assert.assertEquals(o.getCasta().getProbabilidadGolpeCritico(),0.7,0.0001);
		
	}
	@Test
	public void testSettersGetters(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		String [] v = new String[2];
		v[0] = "Incentivar";
		v[1] = "Golpe Fatal";
		Assert.assertArrayEquals(v, h.getHabilidadesRaza());
		Assert.assertEquals("Humano", h.getNombreRaza());
		h.setNombre("Obama");
		Assert.assertEquals("Obama", h.getNombre());
		h.setMagia(69);
		Assert.assertEquals(69, h.getMagia());
		h.setCasta(new Hechicero());
		Assert.assertEquals("Hechicero", h.getCasta().getNombreCasta());
		h.setExperiencia(1000);
		Assert.assertEquals(1000, h.getExperiencia());
		h.setNivel(25);
		Assert.assertEquals(25, h.getNivel());
		h.setIdPersonaje(33);
		Assert.assertEquals(33, h.getIdPersonaje());
		h.setSaludTope(255);
		Assert.assertEquals(255, h.getSaludTope());
		h.setEnergiaTope(255);
		Assert.assertEquals(255, h.getEnergiaTope());
		String aux [] = h.getHabilidadesCasta();
		Assert.assertEquals(aux,h.getHabilidadesCasta());
	}
	@Test
	public void testFunciones(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertTrue(h.puedeAtacar());
		h.setEnergia(0);
		Assert.assertFalse(h.puedeAtacar());
		h.setSalud(1);
		h.restablecerSalud();
		Assert.assertEquals(h.getSalud(), h.getSaludTope());
		h.setEnergia(0);
		h.restablecerEnergia();
		Assert.assertEquals(h.getEnergia(), h.getEnergiaTope());
		Assert.assertEquals(0,h.distanciaCon(h2),0.0001);
		h.setNombreRaza("Perro");
		Assert.assertEquals("Perro", h.getNombreRaza());
		
	}
	@Test
	public void testSerAtacado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h2.setSalud(200);
		h2.getCasta().setProbabilidadEvitarDano(1);
		h.atacar(h2);
		Assert.assertEquals(200, h2.getSalud());
		h2.getCasta().setProbabilidadEvitarDano(0);
		h.setAtaque(0);
		h.atacar(h);
		Assert.assertEquals(200, h2.getSalud());
		Assert.assertEquals(0, h.serRobadoSalud(0));
		h.setSalud(100);
		Assert.assertEquals(75, h.serRobadoSalud(100));
		Assert.assertEquals(0, h.serDesernegizado(0));
	}
	@Test
	public void testAtacar(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		h.getCasta().setProbabilidadGolpeCritico(1);
		Assert.assertEquals(30, h.atacar(h2),0.0001);
		
	}
	@Test
	public void serRobadoDesenergizado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		Assert.assertEquals(100, h.serRobadoSalud(150));
		Assert.assertEquals(100,h2.serDesernegizado(150));
	}
	@Test
	public void testSerEnergizado(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		h.setEnergia(0);
		h.serEnergizado(2000);
		Assert.assertEquals(h.getEnergia(), h.getEnergiaTope());
	}
	@Test
	public void testCrearAliazna(){
		Humano h = new Humano("Nico",100,100,25,25,25,new Guerrero(),0,1,1);
		Humano h2 = new Humano("Nico2",100,100,25,25,25,new Guerrero(),0,1,1);
		Alianza  a = new Alianza("Los Otros");
		h.crearAlianza("Algo Gracioso");
		Assert.assertEquals("Algo Gracioso", h.getClan().getNombre());
		h2.setClan(a);
		Assert.assertFalse(h.aliar(h2));
		
		
	}
}
