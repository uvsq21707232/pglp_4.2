package Abdelhafid.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class MoteurRPN {
	
	private Map<String, SpecificCommand> Operation;
	private Stack<Integer> pile;
	 private Undo undo;
    
	  
	  public MoteurRPN( Stack<Integer> pile , Undo undo) {
		  
	        this.Operation = new HashMap<String, SpecificCommand>();
	        this.pile = pile;
	        this.undo=undo;
	       
	    }
	  
	  
	  /* enregister l'operande dans la pile*/
	  void enregistrer_op(final int a) {
	        pile.push(a);
	        undo.addHist();
	    }
	  
	 
	  
	/*ajouter une operation*/
	  
	  public void Add_cmd( final String commandName, final SpecificCommand command) {
	       this.Operation.put(commandName, command);
	    }
	/* Execute une commande*/
	
	void execComd(final String command) {
		
        if (Operation.containsKey(command) && pile.size() >= 2) {
        	
        	int a=pile.pop();
        	int b=pile.pop();
        	
            pile.push(Operation.get(command).apply(a, b));
            undo.addHist();
            }else {
            	System.out.println("le nombre d'operande est insuffisant");
            }
          
	  
        }
	
	/* Affichage des oreande dans la pile*/
	
	void affichage() {
		
        System.out.printf(" la pile :");
        for (int operande : pile) {
            System.out.printf(" " + operande + " ");
        }
        
        System.out.println("");
    }

	
	 public Stack<Integer> getStack() {
        return pile;
        
    }
	 
	 
	/* initialiser le MoteurRpn avec des fonctions prédéfinis*/
	 
	 public static MoteurRPN initialiser(final Stack<Integer> pile,final Undo undo){
		 
		 MoteurRPN moteur=new MoteurRPN(pile, undo);
		 
		 moteur.Add_cmd("*", new Multiplication());
		 moteur.Add_cmd("/", new Division());
		 moteur.Add_cmd("+", new Addition());
		 moteur.Add_cmd("-", new Soustraction());
		 
		return moteur;
	 }

	
	
	

}
