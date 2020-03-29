package Abdelhafid.pglp_4_2;

import java.util.Scanner;
import java.util.Stack;

public class SaisieRPN {
	
	
	 private Stack<Integer> operandes;
	 private MoteurRPN moteur;
	 private Interpreteur interpreteur;
	
	 private Scanner clavier;
	 
	 /* Conssssssstructeur*/
	 public SaisieRPN() {
	        this.operandes = new Stack<Integer>();
	        Undo undo = new Undo(operandes);
	        this.moteur = MoteurRPN.initialiser(operandes, undo);
	        this.interpreteur = Interpreteur.initialiser(undo);
	        
	       
	    }
	 
	 public void  calculer() throws Exception {
		 
		 clavier= new Scanner(System.in);
		 
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
	                    	
	                        System.err.println(
	                                "Commande impossible à éxecuter");
	                    }
	                }
	            }
	            
	            if (entree.equalsIgnoreCase("quit")) {
	                yes = false;
	            } else {
	            	
	                System.out.print("operandes : "
	                        + operandes.toString() + "\n");
	            }
	        }
	        
	        clavier.close();
	        
	        System.out.println("Resultat : " + operandes.toString());
	      
	
		
	 }
	 

}
