/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

/**
* Addition,Soustraction,Multiplication,Division
* hérite de l'interface CommandInterface.
* @author Abdelhafid
*/
public interface SpecificCommand extends CommandInterface {
	/**
     *  applique les operations
     * @param a
     * @param b
     * @return  le résultat  de l'operation
     */
	 int apply(int a, int b);

}
