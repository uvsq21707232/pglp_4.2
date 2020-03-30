/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
* Undo et Quit.
* hérite de l'interface CommandInterface.
* @author Abdelhafid.
*/
public interface GeneriqueCommand extends CommandInterface {
	/**
	 * applique les commandes.
	 */
	void apply();

}
