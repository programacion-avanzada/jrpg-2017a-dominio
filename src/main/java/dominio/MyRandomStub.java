package dominio;

/**
 * La clase MyRandomStub devuelve lo mismo que recibe en el constructor
 */

public class MyRandomStub extends RandomGenerator {

  private double nextDouble;
  private int nextInt;

  public MyRandomStub(final double nextDouble, final int nextInt){
    this.nextDouble = nextDouble;
    this.nextInt = nextInt;
  }

	/**
	 * @return el mismo valor que recibe en el constructor
	 */

  @Override
	public double nextDouble() {
		return this.nextDouble;
	}

  /**
	 * @return el mismo valor que recibe en el constructor
	 */

  @Override
	public int nextInt(final int val) {
		return this.nextInt;
	}

}
