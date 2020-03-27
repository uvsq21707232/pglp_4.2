package Abdelhafid.pglp_4_2;

import java.util.Stack;

public class Undo implements GeneriqueCommand {
	
	private static Stack<Stack<Integer>> historique;
	
	  private static Stack<Integer> pileCourante;
   
	/* Constructeur de la classe */
	
    public Undo( final Stack<Integer> pile) {
        historique = new Stack<Stack<Integer>>();
        this.pileCourante=pile;
    }
	
	/* Ajout du dernier état de pileCourante dans historique.*/
    
    public static void addHist() {
    	@SuppressWarnings("unchecked")
    	Stack<Integer> copie = (Stack<Integer>) pileCourante.clone();
        historique.push(copie);
       
    }
	
    private void copiehist() {
        for (int elm : historique.lastElement()) {
            pileCourante.push(elm);
        }
    }
    
    
    
	@Override
	public void apply() {
		 if (!pileCourante.isEmpty()) {
	            while (!pileCourante.isEmpty()) {
	            	pileCourante.pop();
	            }
	            historique.pop();
	            copiehist() ;
	        }
	    }
		
	
	
	
	
	
	}

	
	
	

