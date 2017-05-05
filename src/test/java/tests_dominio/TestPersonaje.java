package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandom;
import dominio.Orco;
import dominio.Personaje;

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
  public void testAsesino() {
    Elfo a = new Elfo("elfitoChico", new Asesino(), 44);
    Assert.assertNotNull(a.getHabilidadesCasta());
    Assert.assertNotNull(a.getHabilidadesRaza());

    a.setNombreRaza("ElfitoChico");
    Assert.assertTrue(a.getNombreRaza().equals("ElfitoChico"));

    a.setNombre("Elfaso");
    Assert.assertTrue(a.getNombre().equals("Elfaso"));

    a.setMagia(33);
    Assert.assertTrue(a.getMagia() == 33);

    a.setCasta(new Hechicero());
    Assert.assertTrue(a.getCasta().getNombreCasta().equals("Hechicero"));

    a.setExperiencia(22);
    Assert.assertTrue(a.getExperiencia() == 22);

    a.setNivel(22);
    Assert.assertTrue(a.getNivel() == 22);

    a.setIdPersonaje(11);
    Assert.assertTrue(a.getIdPersonaje() == 11);

    a.setSaludTope(99);
    Assert.assertTrue(a.getSaludTope() == 99);

    a.setEnergiaTope(99);
    Assert.assertTrue(a.getEnergiaTope() == 99);

    a.setEnergia(23);
    Assert.assertTrue(a.puedeAtacar());

    a.setEnergia(5);
    Assert.assertFalse(a.puedeAtacar());

    a.despuesDeTurno();

    a.restablecerEnergia();
    Assert.assertTrue(a.getEnergiaTope() == 99);

    a.restablecerSalud();
    Assert.assertTrue(a.getSaludTope() == 99);

    Assert.assertTrue(a.serDesernegizado(1) == 0);
    // energia - daño
    int daño = 9898;
    if ((a.getEnergia() - daño) < 0) {
      a.serDesernegizado(daño);
      Assert.assertTrue(a.getEnergia() == 0);
    }

    Personaje nuevoAliado = new Elfo("Piedras", new Hechicero(), 232);
    nuevoAliado.setClan(new Alianza("Alianza Piedra"));
    boolean b = a.aliar(nuevoAliado);
    if (nuevoAliado.getClan() != null) {
      Assert.assertFalse(b);
    }
    Assert.assertTrue(nuevoAliado.distanciaCon(new Elfo("Piedras2", new Hechicero(), 232)) == 0);

    Assert.assertTrue(nuevoAliado.serRobadoSalud(0) == 0);
    Assert.assertTrue(nuevoAliado.serRobadoSalud(121212) > 0);

  }

  @Test
  public void testSerEnergizadoTopeNoTope() {
    Personaje nuevoAliado = new Elfo("Piedras", new Hechicero(), 232);
    nuevoAliado.serEnergizado(7878);
    Assert.assertTrue(nuevoAliado.getEnergia() == nuevoAliado.getEnergiaTope());
  }

  @Test
  public void testSalirDeAliaza() {
    Personaje nuevoAliado = new Elfo("Piedras", new Hechicero(), 232);
    nuevoAliado.setClan(new Alianza("Alianza Piedra"));
    nuevoAliado.salirDeAlianza();
    Assert.assertNull(nuevoAliado.getClan());

    nuevoAliado.setClan(new Alianza("Alianza Piedra"));

    double rand = MyRandom.nextDouble();
    // if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño())
    // {
    while (rand < nuevoAliado.getCasta().getProbabilidadEvitarDaño()) {
      rand = MyRandom.nextDouble();
    }
    Assert.assertTrue(nuevoAliado.serAtacado(0) == 0);

    while (rand >= nuevoAliado.getCasta().getProbabilidadEvitarDaño()) {
      rand = MyRandom.nextDouble();
    }

  }
}
