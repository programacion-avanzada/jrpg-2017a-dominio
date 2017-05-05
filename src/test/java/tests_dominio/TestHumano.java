package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHumano {

  @Test
  public void testIncentivar() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getAtaque() == 37);
    h.habilidadRaza1(e);
    Assert.assertTrue(e.getAtaque() > 37);
  }

  @Test
  public void testGolpeFatal() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(h.getEnergia() == 100);
    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadRaza2(e)) {
      Assert.assertTrue(e.getSalud() == 70);
      Assert.assertTrue(h.getEnergia() == 50);
    } else {
      Assert.assertTrue(h.getEnergia() == 90);
      Assert.assertTrue(e.getSalud() == 100);
    }
  }

  @Test
  public void misTestSobreHumano() {
    Humano a = new Humano("humanito", 55, 2, 55, 55, 55, new Hechicero(), 55, 55, 55);
    Humano b = new Humano("humanito2", 55, 424, 55, 55, 55, new Hechicero(), 55, 55, 55);
    Assert.assertFalse(a.habilidadRaza1(b));

    Humano c = new Humano("humanito", 55, 90, 55, 55, 55, new Hechicero(), 55, 55, 55);
    Assert.assertFalse(c.habilidadRaza2(b));

  }
}
