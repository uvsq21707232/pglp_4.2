package Abdelhafid.pglp_4_2;


import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class TestInterpreteur {
	
	@Test 
	public void testUndo() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo= new Undo(pile);
		Interpreteur interpret = Interpreteur.initialiser(undo);
		
		pile.push(40);
		undo.addHist();
		pile.push(50);
		undo.addHist();
		interpret.executer_cmd("undo");
		
		Stack<Integer> resultat = new Stack<Integer>();
		resultat.push(40);
		assertEquals(pile, resultat);
		
		
	}
	
}

	

