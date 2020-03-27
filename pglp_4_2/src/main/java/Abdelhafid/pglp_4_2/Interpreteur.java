package Abdelhafid.pglp_4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** The Invoker class */

public class Interpreteur {
	
	
	private Map<String, GeneriqueCommand> commandMap;
	
	/*constructeur de la classe */
	
 private Interpreteur() {
	 
	 this.commandMap= new HashMap<String, GeneriqueCommand>();
	 
 }
	
 /* Création  de la commande commandName 
  *  qui effectue  la commane Generique command*/

	 public void Add_cmd( String commandName,  GeneriqueCommand command) {
	        commandMap.put(commandName, command);
	    }
	    
	 /* Execute la commande commandName.*/
 
	    public void executer_cmd(String commandName) {
	    	
	    	 GeneriqueCommand command = commandMap.get(commandName);
	        if (command == null) {
	            throw new IllegalStateException("no command registered for " + commandName);
	        }
	        	        
	        command.apply();
	        
	        
	    }

	    
	    /* Initialisation de l'interpreteur avec des fonctions qui prennent undo et quit*/
	    
	    static Interpreteur initialiser(final Undo undo) {
			
	        Interpreteur interpret = new Interpreteur();
	       
	        interpret.Add_cmd("quit", new Quit());
	        interpret.Add_cmd("undo", undo);
	        return interpret;
	    }
	    
	    
	    

}

