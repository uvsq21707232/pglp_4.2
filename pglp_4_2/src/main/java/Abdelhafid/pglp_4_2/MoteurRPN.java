/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
* Classe MoteurRPN.
*/
public class MoteurRPN {
	/**
	* les commandes.
	*/
	private Map<String, SpecificCommand> Operation;
	/**
     * Pile  des operandes.
     */
	private Stack<Integer> pile;
	/**
     * revenir en arriére
     */
	private Undo undo;
	/**
     * Constructeur de la classe.
     * @param pile  Pile  des operandes
     * @param undo Le undo Retour en arriere
     */
public MoteurRPN(Stack<Integer> pile, Undo undo) {

		this.Operation = new HashMap<String, SpecificCommand>();
		this.pile = pile;
		this.undo = undo;

	}
   /**
   * enregister l'operande dans la pile.
   * @param a L'opérande 
   */
	void enregistrer_op(final int a) {
		pile.push(a);
		undo.addHist();
	}
	/**
     * Fonction qui ajoute une commande à la liste Operation .
     * @param commandName de la commande
     * @param command Classe de la commande
     */
	public void Add_cmd(final String commandName, final SpecificCommand command) {
		this.Operation.put(commandName, command);
	}
	/**
     * Fonction qui execute la commande.
     * @param command Nom de la commande
     * @throws Exception
     */
	void execComd(final String command) throws Exception {

		if (Operation.containsKey(command)) {

			if (pile.size() >= 2) {

				int a = pile.pop();
				int b = pile.pop();
				try {

					pile.push(Operation.get(command).apply(a, b));
					undo.addHist();
				} catch (Exception exept) {
					pile.push(a);
					pile.push(b);
					throw exept;
				}
			} else {
				System.out.println("le nombre d'operande est insuffisant");
				throw new Exception();
			}
		} else {

			throw new Exception();
		}

	}
	   /**
	   * Affichage des operandes
	   *
	   */
	void affichage() {

		System.out.printf(" résultat :");
		for (int operande : pile) {
			System.out.printf(" " + operande + " ");
		}

		System.out.println("");
	}
	/**
	   * Getter de la pile
	   * @return La pile
	   */
	public Stack<Integer> getStack() {
		return pile;

	}
	/**
     * Initialisation du MoteurRPN
     * avec des fonctions prédéfinis
     * @param pile la pile
     * @param undo Retourner en arrière
     * @return L'interpreteur
     */
	public static MoteurRPN initialiser(final Stack<Integer> pile, final Undo undo) {

		MoteurRPN moteur = new MoteurRPN(pile, undo);

		moteur.Add_cmd("*", new Multiplication());
		moteur.Add_cmd("/", new Division());
		moteur.Add_cmd("+", new Addition());
		moteur.Add_cmd("-", new Soustraction());

		return moteur;
	}

}
