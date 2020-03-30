/**
 * Package de Abdelhafid.
 */
package Abdelhafid.pglp_4_2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Classe Interpreteur.
 */
public class SaisieRPN {
	/**
     * Pile d'opérande.
     */
	private Stack<Integer> operandes;
	/**
     * MoteurRPN.
     */
	private MoteurRPN moteur;
	/**
     * Interpréteur.
     */
	private Interpreteur interpreteur;
	/**
     * Scanner pour taper dans le clavier.
     */
	private Scanner clavier;
	/**
     * Constructeur de la classe.
     */
	public SaisieRPN() {
		this.operandes = new Stack<Integer>();
		Undo undo = new Undo(operandes);
		this.moteur = MoteurRPN.initialiser(operandes, undo);
		this.interpreteur = Interpreteur.initialiser(undo);

	}
	/**
     * Fait le calcul.
     * affiche les operandes et le résultat
     * @throws Exception
     */
	public void calculer() throws Exception {

		clavier = new Scanner(System.in);

		int input;
		boolean yes = true;
		String entree = "";

		System.out.println("entrer soit des entiers , soit un eoperation , soit quit  \n ");

		while (yes) {
			try {
				input = clavier.nextInt();
				moteur.enregistrer_op(input);

			} catch (java.util.InputMismatchException e) {

				entree = clavier.nextLine();
				try {
					moteur.execComd(entree);
				} catch (Exception exept) {

					try {
						interpreteur.executer_cmd(entree);

					} catch (Exception exeption) {

						System.err.println("Commande impossible à éxecuter");
					}
				}
			}

			if (entree.equalsIgnoreCase("quit")) {
				yes = false;
			} else {

				System.out.print("operandes : " + operandes.toString() + "\n");
			}
		}

		clavier.close();

		System.out.println("Resultat : " + operandes.toString());

	}

}
