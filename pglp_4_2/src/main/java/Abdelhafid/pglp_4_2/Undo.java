/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

import java.util.Stack;

/**
* Undo.
* implemente l'interface GeneriqueCommand.
* @author Abdelhafid
*/
public class Undo implements GeneriqueCommand {
	/**
     * Pile stockant tout les états 
     * de pileCourante
     */
	private static Stack<Stack<Integer>> historique;
	/**
     * Pile  stockant l'état courant.
     */
	private static Stack<Integer> pileCourante;
	/**
     * Constructeur.
     * @param pile La pile
     */
	public Undo(final Stack<Integer> pile) {
		historique = new Stack<Stack<Integer>>();
		this.pileCourante = pile;
	}
	/**
     * Ajout du dernier état de pileCourante dans historique.
     */
	public static void addHist() {
		@SuppressWarnings("unchecked")
		Stack<Integer> copie = (Stack<Integer>) pileCourante.clone();
		historique.push(copie);

	}
	/**
     * Copie le dernier état de historique dans pileCourante.
     */
	private void copiehist() {
		for (int elm : historique.lastElement()) {
			pileCourante.push(elm);
		}
	}
	/**
     * Executer le retour  en arriére
     */
	@Override
	public void apply() {
		if (!pileCourante.isEmpty()) {
			while (!pileCourante.isEmpty()) {
				pileCourante.pop();
			}
			historique.pop();
			copiehist();
		}
	}

}
