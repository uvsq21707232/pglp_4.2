/**
 * Package de Abdelhafid.
 */
package Abdelhafid.pglp_4_2;

/**
 * Classe Addition 
 * implemente l'interface SpecificCommand.
 * @author Abdelhafid
 */
public class Addition implements SpecificCommand {
	/**
     * Effectue l'addition entre a et b.
     * @param a
     * @param b
     * @return la somme a+b
     */
	@Override
	public int apply(final int a, final int b) {

		return a + b;

	}

}
