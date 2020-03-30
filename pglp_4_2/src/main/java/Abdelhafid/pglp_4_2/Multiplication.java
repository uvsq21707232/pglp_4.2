/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
 * la Classe Multiplication
 * implemente l'interface SpecificCommand.
 * @author Abdelhafid
 */
public class Multiplication implements SpecificCommand {
	/**
	 * Effectue la Multiplication de a et b 
	 * @param a
	 * @param b
	 * @return la multiplication a*b
	 */
	@Override
	public int apply(int a, int b) {

		return a * b;
	}

}
