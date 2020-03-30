/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
 * la Classe Division 
 * implemente l'interface SpecificCommand.
 * @author Abdelhafid
 */
public class Division implements SpecificCommand {
	/**
	 * Effectue la Division de a sur b 
	 * @param a
	 * @param b different de 0
	 * @return la Division entière a/b
	 */
	@Override
	public int apply(final int a, final int b) {

		if (b == 0) {
			System.out.println("division par zéro");

		}

		return a / b;
	}

}
