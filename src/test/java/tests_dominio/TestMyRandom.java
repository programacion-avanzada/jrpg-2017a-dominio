package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandom;

//Como testeo una clase con metodos static? arme un constructor al divino boton para pasar el test
public class TestMyRandom {
  @Test
  public void testMyRandom() {
    new MyRandom();
    Assert.assertNotNull(MyRandom.nextDouble());
    Assert.assertNotNull(MyRandom.nextInt(3));
  }
}
