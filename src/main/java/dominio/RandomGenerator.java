package dominio;

/**
* Clase utilizada para heredar las implementaciones de Random
*/

public abstract class RandomGenerator {

	/**
	* @param val un valor maximo
	* @return un entero aleatorio
	*/

	public abstract int nextInt(int val);

	/**
	* @return un double aleatorio
	*/

	public abstract double nextDouble();
}
