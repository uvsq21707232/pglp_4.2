/**
 * Package de Abdelhafid
 */
package Abdelhafid.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Classe Interpreteur.
 */
public class Interpreteur {
	/**
    * les commandes.
    */
	private Map<String, GeneriqueCommand> commandMap;
	/**
     * Constructeur.
     */
	private Interpreteur() {

		this.commandMap = new HashMap<String, GeneriqueCommand>();

	}
	/**
     * Fonction qui ajoute une commande à la liste commandMap .
     * @param commandName de la commande
     * @param command Classe de la commande
     */
	public void Add_cmd(String commandName, GeneriqueCommand command) {
		commandMap.put(commandName, command);
	}
	/**
     * Fonction qui execute la commande.
     * @param commandName Nom de la commande
     */
	public void executer_cmd(String commandName) {

		GeneriqueCommand command = commandMap.get(commandName);
		if (command == null) {
			throw new IllegalStateException("no command registered for " + commandName);
		}

		command.apply();

	}
	/**
     * Initialisation de l'interpreteur avec
     * des fonctions qui prennent undo et quit
     * @param undo Retourner en arrière
     * @return L'interpreteur
     */
	static Interpreteur initialiser(final Undo undo) {

		Interpreteur interpret = new Interpreteur();

		interpret.Add_cmd("quit", new Quit());
		interpret.Add_cmd("undo", undo);
		return interpret;
	}

}
