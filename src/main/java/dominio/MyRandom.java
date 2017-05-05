package dominio;

public class MyRandom {

  public MyRandom() {
    // SOLO PARA SILENCIAR EL COVERAGE TEST
  }

  public static double nextDouble() {
    return 0.49;
  }

  public static int nextInt(int val) {
    return val - 1;
  }

}
