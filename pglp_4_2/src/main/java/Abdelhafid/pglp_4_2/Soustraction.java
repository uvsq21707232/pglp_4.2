/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
 * la Classe Soustraction
 * implemente l'interface SpecificCommand.
 * @author Abdelhafid
 */
public class Soustraction implements SpecificCommand {
	/**
	 * Effectue la Soustraction entre a et b 
	 * @param a
	 * @param b
	 * @return la différence a-b
	 */
	@Override
	public int apply(final int a, final int b) {

		return a - b;
	}

}
