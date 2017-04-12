package dominio;

public class MyRandom {
	/**
	 * Clase con dos métodos estaticos, utilizados para la obtención de números de tipo int y double
	 * 
	 */
	
	
	/**
	 * El método nextDobule() retorna siempre el número 0.49
	 * @return retorna 0.49
	 */
	public static double nextDouble() {
		return 0.49;
	}
	/**
	 * El método nextInt() decrementa en 1 el argumento que se le pasó
	 * @param val número entero a decrementar
	 * @return número decrementado 
	 */
	public static int nextInt(int val) {
		return val - 1;
	}
	
}
