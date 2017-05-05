package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;

public class TestCasta {

  @Test
  public void testGetNombreIsNull() {
    Asesino a = new Asesino(1, 2, 3);
    Assert.assertTrue(a.getNombreCasta().equals("Asesino"));
    // Assert.assertNotNull(a.getAliados());
  }

  @Test
  public void testSetProbabilidadGolpeCriticoTrue() {
    Asesino a = new Asesino(1, 2, 3);
    a.setProbabilidadGolpeCritico(55);
    Assert.assertTrue(a.getProbabilidadGolpeCritico() == 55);
  }

  @Test
  public void testSetProbabilidadEvitarDañoTrue() {
    Asesino a = new Asesino(1, 2, 3);
    a.setProbabilidadEvitarDaño(55);
    Assert.assertTrue(a.getProbabilidadEvitarDaño() == (55));
  }

  @Test
  public void testSetDañoCriticoTrue() {
    Asesino a = new Asesino(1, 2, 3);
    a.setDañoCritico(55);
    Assert.assertTrue(a.getDañoCritico() == (55));
  }

}
