/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
* Quit.
* implemente l'interface GeneriqueCommand.
* @author Abdelhafid.
*/
public class Quit implements GeneriqueCommand {
	/**
     *  arrêter la calcultrice.
     */
	@Override
	public void apply() {
		System.out.println("Vous venez de quitté le programme.");
		System.exit(0);

	}

}
